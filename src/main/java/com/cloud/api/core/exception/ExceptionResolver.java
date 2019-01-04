package com.cloud.api.core.exception;

import java.sql.SQLException;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultCode;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.service.OperationLogService;
import com.cloud.api.util.UrlUtils;

/**
 * 统一异常处理
 * 对于业务异常：返回头 Http 状态码一律使用500，避免浏览器缓存，在响应 Result 中指明异常的状态码 code
 *
 */
@RestControllerAdvice
@SuppressWarnings("rawtypes")
public class ExceptionResolver {
    private final static Logger log = LoggerFactory.getLogger(ExceptionResolver.class);
    
    @Resource
    private OperationLogService operationLogService;
    
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ConstraintViolationException.class)
    public Result validatorException(final ConstraintViolationException e) {
        final String msg = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(","));
        // e.toString 多了不需要用户知道的属性路径
        log.error("==> 验证实体异常: {}", e.toString());
        operationLogService.editFailedOperationLog(msg);
        return ResultGenerator.genFailedResult(ResultCode.VIOLATION_EXCEPTION.getValue(), msg);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ServiceException.class, ServletException.class})
    public Result serviceException(final Throwable e) {
        log.error("==> 服务异常: {}", e.getMessage());
        operationLogService.editFailedOperationLog(e.getMessage());
        return ResultGenerator.genFailedResult(ResultCode.SERVICE_EXCEPTION.getValue(), e.getMessage());
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({NullPointerException.class})
    public Result nullPointException(final Throwable e) {
        log.error("==> 空指针异常: {}", e.getMessage());
        operationLogService.editFailedOperationLog("Runtime exception, please check code!");
        return ResultGenerator.genFailedResult(ResultCode.SERVICE_EXCEPTION.getValue(), "Runtime exception, please check code!");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ResourcesNotFoundException.class})
    public Result resourcesException(final Throwable e) {
        log.error("==> 资源异常: {}", e.getMessage());
        operationLogService.editFailedOperationLog(e.getMessage());
        return ResultGenerator.genFailedResult(ResultCode.RESOURCES_NOT_FOUND_EXCEPTION,e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public Result databaseException(final Throwable e) {
        log.error("==> 数据库异常: {}", e.getMessage());
        operationLogService.editFailedOperationLog(ResultCode.DATABASE_EXCEPTION.getReason());
        return ResultGenerator.genFailedResult(ResultCode.DATABASE_EXCEPTION);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handlerValidateException(MethodArgumentNotValidException ex) {
    	BindingResult bindingResult = ex.getBindingResult();
    	if (bindingResult.hasErrors()) {
    		StringBuffer errorMessage = new StringBuffer();
			for (ObjectError error : bindingResult.getAllErrors()) {
				errorMessage.append(error.getDefaultMessage() + ";");
			}
			log.error("==> 参数异常: {}", errorMessage.toString());
			operationLogService.editFailedOperationLog(errorMessage.toString());
			return ResultGenerator.genFailedResult(ResultCode.VIOLATION_EXCEPTION, errorMessage.toString());
		}else {
			log.error("==> 参数异常: {}", ex.getMessage());
			operationLogService.editFailedOperationLog(ResultCode.ARGS_NO_VALID.getReason());
			return ResultGenerator.genFailedResult(ResultCode.ARGS_NO_VALID);
		}
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ParamInvalidException.class)
    public Result paramInvalidException(ParamInvalidException ex) {
    	 log.error("==> 参数异常: {}", ex.getMessage());
    	 operationLogService.editFailedOperationLog(ex.getMessage());
         return ResultGenerator.genFailedResult(ResultCode.VIOLATION_EXCEPTION.getValue(), ex.getMessage());
    }
    
			
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({BadCredentialsException.class, AuthenticationException.class})
    public Result authException(final Throwable e) {
        log.error("==> 身份验证异常: {}", e.getMessage());
        operationLogService.editFailedOperationLog(ResultCode.UNAUTHORIZED.getReason());
        return ResultGenerator.genFailedResult(ResultCode.UNAUTHORIZED);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({AccessDeniedException.class, UsernameNotFoundException.class})
    public Result accountException(final Throwable e) {
        log.error("==> 账户异常: {}", e.getMessage());
        operationLogService.editFailedOperationLog(e.getMessage());
        return ResultGenerator.genFailedResult(e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result apiNotFoundException(final Throwable e, final HttpServletRequest request) {
        log.error("==> API不存在: {}", e.getMessage());
        operationLogService.editFailedOperationLog("API [" + UrlUtils.getMappingUrl(request) + "] not existed");
        return ResultGenerator.genFailedResult("API [" + UrlUtils.getMappingUrl(request) + "] not existed");
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result globalException(final HttpServletRequest request, final Throwable e) {
    	e.printStackTrace();
        log.error("==> 全局异常: {}", e.getMessage());
        operationLogService.editFailedOperationLog(String.format("%s => %s", UrlUtils.getMappingUrl(request), e.getMessage()));
        return ResultGenerator.genFailedResult(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                String.format("%s => %s", UrlUtils.getMappingUrl(request), e.getMessage()));
    }
}

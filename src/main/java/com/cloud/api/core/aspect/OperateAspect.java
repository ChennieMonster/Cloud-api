package com.cloud.api.core.aspect;

import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.dto.OperationLogDTO;
import com.cloud.api.service.OperationLogService;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.annotation.Operation;

@Aspect
@Component
public class OperateAspect {
	
	private final static Logger log = LoggerFactory.getLogger(OperateAspect.class);
	
	@Resource
	private OperationLogService operationLogService;

	@Pointcut(value = "@annotation(com.cloud.api.util.annotation.Operation)")
	public void pointCut() {
	}

	@Around("pointCut()&& @annotation(operation)")
	public Object testAround(ProceedingJoinPoint pjp, Operation operation) throws Throwable {
		System.out.println("=======================" + operation.action());
		// 操作日志记录开始
		OperationLogDTO operationLogDTO = new OperationLogDTO();
		operationLogDTO.setUuid(IdGen.uuid());
		operationLogDTO.setUserName(MDC.get(MDCConstants.USER_NAME));
		operationLogDTO.setRequestId(MDC.get(MDCConstants.REQUEST_ID_MDC_KEY));
		operationLogDTO.setAction(operation.action());
		operationLogDTO.setResourceType(operation.resourceType());
		operationLogDTO.setLevel(operation.level());
		operationLogDTO.setStartTime(new Date());
		operationLogDTO.setCreatedTime(new Date());
		operationLogService.addOperationLog(operationLogDTO);

		// 执行目标方法
		Object obj = pjp.proceed();

		// 操作日志记录结束
		OperationLogDTO operationLogEdit = new OperationLogDTO();
		operationLogEdit.setUuid(operationLogDTO.getUuid());
		operationLogDTO.setEndTime(new Date());
		operationLogDTO.setResult("success");
		operationLogService.editOperationLog(operationLogDTO);
		System.out.println("======================end");
		return obj;
	}
}

package com.cloud.api.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cloud.api.util.JsonUtils;

//@Aspect
//@Component
public class LogAspect {

	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Pointcut("execution(public * com.cloud.api.controller.*.*(..))") // 两个..代表所有子目录，最后括号里的两个..代表所有参数
	public void logControllerPointCut() {
	}

	@Pointcut("execution(public * com.cloud.api.service.*.*(..))") // 两个..代表所有子目录，最后括号里的两个..代表所有参数
	public void logServicePointCut() {
	}

	@Before("logControllerPointCut()")
	public void doBeforeController(JoinPoint joinPoint) throws Throwable {
		logger.debug("============请求开始===============");
		// 类方法
		logger.debug("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		// 参数
		logger.debug("args={}", JsonUtils.objectToJson(joinPoint.getArgs()));
	}

	@AfterReturning(returning = "ret", pointcut = "logControllerPointCut()") // returning的值和doAfterReturning的参数名一致
	public void doAfterReturningController(Object ret) throws Throwable {
		logger.debug("请求返回值 : " + JsonUtils.objectToJson(ret));
		logger.debug("============请求结束===============");
	}

	@Before("logServicePointCut()")
	public void doBeforeService(JoinPoint joinPoint) {
		logger.debug("__________________enter service=>" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		// 参数
		logger.debug("args={}", JsonUtils.objectToJson(joinPoint.getArgs()));
	}

	@AfterReturning(returning = "ret", pointcut = "logServicePointCut()",argNames="ret") // returning的值和doAfterReturning的参数名一致
	public void doAfterReturningService(JoinPoint joinPoint,Object ret) {
		logger.debug("__________________exit service method: " + joinPoint.getSignature().getName() + "retrun => " + JsonUtils.objectToJson(ret));
	}

}

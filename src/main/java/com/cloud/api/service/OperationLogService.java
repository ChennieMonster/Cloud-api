package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.OperationLogDTO;
import com.cloud.api.entity.GetListParamElement;

public interface OperationLogService {
	
	/**
	 * 添加操作日志
	 * @param operationLog
	 * @return
	 */
	int addOperationLog(OperationLogDTO operationLog);
	
	/**
	 * 修改操作日志
	 * @param operationLog
	 * @return
	 */
	int editOperationLog(OperationLogDTO operationLog);
	
	/**
	 * 根据id查询操作日志
	 * @param operationLogId
	 * @return
	 */
	OperationLogDTO queryOperationLogById(String operationLogId);
	
	/**
	 * 根据userId查询操作日志
	 * @param userId
	 * @return
	 */
	List<OperationLogDTO> queryOperationLogByUserId(String userId);
	
	/**
	 * 查询所有操作日志
	 * @return
	 */
	List<OperationLogDTO> queryAllOperationLog(); 
	
	/**
	 * 根据requestId查询操作日志
	 * @param requestId
	 * @return
	 */
	List<OperationLogDTO> queryOperationLogByRequestId(String requestId);
	
	/**
	 * 发生异常时,记录操作日志
	 * @param failedMessage
	 */
	void editFailedOperationLog(String failedMessage);
	
	/**
	 * 获取log总数
	 * @return
	 */
	long countAllOperationLogs();
	
	/**
	 * 分页查询
	 * @param filterList
	 * @return
	 */
	List<OperationLogDTO> filterOperationLog(OperationLogDTO queryParam);

    long queryLogCount(OperationLogDTO queryParam);
} 

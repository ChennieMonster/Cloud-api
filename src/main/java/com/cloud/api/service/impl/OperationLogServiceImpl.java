package com.cloud.api.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.dto.OperationLogDTO;
import com.cloud.api.dto.OperationLogDTOExample;
import com.cloud.api.dto.OperationLogDTOExample.Criteria;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.mapper.OperationLogMapper;
import com.cloud.api.service.OperationLogService;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class OperationLogServiceImpl implements OperationLogService {

    @Resource
    private OperationLogMapper operationLogMapper;

    @Override
    public int addOperationLog(OperationLogDTO operationLog) {
    	try {
			return operationLogMapper.insertSelective(operationLog);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
    }

    @Override
    public int editOperationLog(OperationLogDTO operationLog) {
        return operationLogMapper.updateByPrimaryKeySelective(operationLog);
    }

    @Override
    public OperationLogDTO queryOperationLogById(String operationLogId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OperationLogDTO> queryOperationLogByUserId(String userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OperationLogDTO> queryAllOperationLog() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OperationLogDTO> queryOperationLogByRequestId(String requestId) {
        OperationLogDTOExample example = new OperationLogDTOExample();
        Criteria criteria = example.createCriteria();
        criteria.andRequestIdEqualTo(requestId);
        example.setOrderByClause("created_time asc");
        return operationLogMapper.selectByExample(example);
    }

    @Override
    public void editFailedOperationLog(String failedMessage) {
        try {
            String requestId = MDC.get(MDCConstants.REQUEST_ID_MDC_KEY);
            OperationLogDTOExample example = new OperationLogDTOExample();
            Criteria criteria = example.createCriteria();
            criteria.andRequestIdEqualTo(requestId);
            criteria.andEndTimeIsNull();

            OperationLogDTO operationLogDTO = new OperationLogDTO();
            operationLogDTO.setEndTime(new Date());
            operationLogDTO.setResult("failed");
            operationLogDTO.setDetail(failedMessage);
            operationLogMapper.updateByExampleSelective(operationLogDTO, example);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public long countAllOperationLogs() {
        OperationLogDTOExample example = new OperationLogDTOExample();
        Criteria criteria = example.createCriteria();
        criteria.getAllCriteria();
        return operationLogMapper.countByExample(example);
    }

    @Override
    public List<OperationLogDTO> filterOperationLog(OperationLogDTO queryParam) {
//		OperationLogDTOExample example = new OperationLogDTOExample();
//		Criteria criteria = example.createCriteria();
//		if (filterList != null && !filterList.isEmpty()) {
//			for (int i = 0; i < filterList.size(); i++) {
//				String key = filterList.get(i).getKey();
//				if (key.equals(Constants.FILTER_NAME_USERNAME)) {
//					String value = filterList.get(i).getValue();
//					criteria.andUserNameLike("%" + value + "%");
//				}
//			}
//		}
//		example.setOrderByClause("created_time desc,start_time asc");
//
//		return operationLogMapper.selectByExample(example);

        String username = MDC.get(MDCConstants.USER_NAME);
        List<OperationLogDTO> list = operationLogMapper.queryLogList(username, queryParam);

        return list;
    }

    @Override
    public long queryLogCount(OperationLogDTO queryParam) {
        String username = MDC.get(MDCConstants.USER_NAME);
        long logCount = operationLogMapper.queryLogCount(username, queryParam);

        return logCount;
    }
}

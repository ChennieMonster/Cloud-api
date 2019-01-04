package com.cloud.api.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.dto.MonitorBlockIoDTO;
import com.cloud.api.dto.MonitorDiskIoDTO;
import com.cloud.api.dto.MonitorHistoryDTO;
import com.cloud.api.dto.MonitorNetworkDTO;

public class ExportExcelUtil {
	
	public static HSSFWorkbook exportExcel(HSSFWorkbook hwb,List<?> dataList, String type, List<String> cellList) {
		HSSFSheet sheet = hwb.createSheet(type);
		HSSFRow row1 = sheet.createRow(0);
		for (int i = 0; i < cellList.size(); i++) {
			row1.createCell(i).setCellValue(cellList.get(i));
		}
		switch(type) {
		case Constants.ITEM_CPU_UTIL:
		case Constants.ITEM_MEMORY_UTIL:
			for (int i = 0; i < dataList.size(); i++) {
				MonitorHistoryDTO monitorHistory = (MonitorHistoryDTO) dataList.get(i);
				HSSFRow row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(StringToUTCDate.date2String(monitorHistory.getCreatedTime()));
				row.createCell(1).setCellValue(monitorHistory.getDataValue() + "%");
			}
			break;
		case Constants.ITEM_NET:
			for (int i = 0; i < dataList.size(); i++) {
				MonitorNetworkDTO network = (MonitorNetworkDTO) dataList.get(i);
				HSSFRow row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(StringToUTCDate.date2String(network.getCreatedTime()));
				row.createCell(1).setCellValue(network.getFlowIn() + "B");
				row.createCell(2).setCellValue(network.getFlowOut() + "B");
			}
			break;
		case Constants.ITEM_DISK:
			for (int i = 0; i < dataList.size(); i++) {
				MonitorDiskIoDTO diskIo = (MonitorDiskIoDTO) dataList.get(i);
				HSSFRow row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(StringToUTCDate.date2String(diskIo.getCreatedTime()));
				row.createCell(1).setCellValue(diskIo.getDiskName());
				row.createCell(2).setCellValue(diskIo.getRps() + "r/s");
				row.createCell(3).setCellValue(diskIo.getWps() + "r/s");
			}
			break;
		case Constants.ITEM_BLOCK:
			for (int i = 0; i < dataList.size(); i++) {
				MonitorBlockIoDTO blockIo = (MonitorBlockIoDTO) dataList.get(i);
				HSSFRow row = sheet.createRow(i + 1);
				row.createCell(0).setCellValue(StringToUTCDate.date2String(blockIo.getCreatedTime()));
				row.createCell(1).setCellValue(blockIo.getBlockIn() + "B");
				row.createCell(2).setCellValue(blockIo.getBlockOut() + "B");
			}
			break;
		}
		
		return hwb;
	}
}

package com.cloud.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.api.service.impl.TemplateServiceImpl;

/**
* @author huang_kefei
* @date 2018年10月22日
* 类说明
*/
public class StringToUTCDate {
	private final static Logger log = LoggerFactory.getLogger(TemplateServiceImpl.class);
	
	public static Date toDate(String unc) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		try {
		      Date dateUnc = sdf1.parse(unc);//拿到Date对象
		      return dateUnc;
		  } catch (Exception e) {
		      e.printStackTrace();
		      log.warn("StringToDate fail!");
		      return null;
		  }
	}
	
	public static String date2String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
}


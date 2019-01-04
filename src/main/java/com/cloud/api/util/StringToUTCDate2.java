package com.cloud.api.util;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author huang_kefei
* @date 2018年10月22日
* 类说明
*/
public class StringToUTCDate2 {
	private final static Logger log = LoggerFactory.getLogger(StringToUTCDate2.class);
	
	public static Date toDate(String unc) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		try {
		      Date dateUnc = sdf1.parse(unc);//拿到Date对象
		      return dateUnc;
		  } catch (Exception e) {
		      e.printStackTrace();
		      log.warn("StringToDate fail!");
		      return null;
		  }
	}
	
}


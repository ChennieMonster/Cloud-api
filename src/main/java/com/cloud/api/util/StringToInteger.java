package com.cloud.api.util;

import java.util.Date;

/**
* @author huang_kefei
* @date 2018年10月22日
* 类说明
*/
public class StringToInteger {
	public static Integer toInteger(String str) {
		Integer i = null;
		if(str!=null){
		     i = Integer.valueOf(str);
		 	return i;
		}
		return null;
	}
}

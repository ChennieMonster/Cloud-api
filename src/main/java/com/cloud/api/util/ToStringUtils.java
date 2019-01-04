/**
 * 
 */
package com.cloud.api.util;

import java.lang.reflect.Field;

/**
 * @author zhao_pengchen
 *
 */
public class ToStringUtils {

	public static void outprint(String s1,Object o){
		
		try {
			Class<?> c = Class.forName(s1);
			Field [] fields = c.getDeclaredFields();
			for(Field f:fields){  
	            f.setAccessible(true);  
	        }
			for(Field f:fields) {
				String field = f.toString().substring(f.toString().lastIndexOf(".")+1); //取出属性名称
				System.out.println("+++++p1.+++++++++++++++"+field+" --> "+f.get(o));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

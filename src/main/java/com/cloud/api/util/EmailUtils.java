/**
 * 
 */
package com.cloud.api.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author zhao_pengchen
 *
 */
public class EmailUtils {

	private static Logger log = LogManager.getLogger(EmailUtils.class);
	
	/*
	 * sendParam has key "notifiTerminalAddr"
	 */
	public static boolean sendEmail(String emailHost,String emailUser,String emailPwd,String emailFrom, String notifiAddr, String notifiSubject, String notifiContent) {
		if (null == emailHost || "".equals(emailHost)) {
			log.warn("==send Email error not config==");
			log.warn(notifiAddr + " : " + notifiContent);
			return false;
		}

		if (null == notifiAddr || "".equals(notifiAddr)) {
			log.warn("==email addr none==");
			return false;
		}
		log.debug("Mail to " + notifiAddr);
		String content = "";
		for (String str : notifiContent.split(";")) {
			content = content + str + "\n";
		}
		SimpleEmail email = new SimpleEmail();
		email.setCharset("utf-8");
		email.setHostName(emailHost);
		email.setAuthentication(emailUser, emailPwd);
		try {
			email.setFrom(emailFrom);
			email.addTo(notifiAddr);
			email.setSubject(notifiSubject);
			email.setMsg(content);
			email.send();
		} catch (EmailException e) {
			log.error("email.error"+e);
			return false;
		}
		return true;
	}
	
}

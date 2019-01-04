package com.cloud.api.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.cloud.api.core.exception.ServiceException;

public class SecretUtils {

	private final static Logger log = LoggerFactory.getLogger(SecretUtils.class);

	public static Map<String, String> createTls(String serviceIp, String serviceName, String routeHostName,
			String project) {
		Map<String, String> map = new HashMap<String, String>();

		// 备份
		try {
			List<String> fileNameList = new ArrayList<String>();
			fileNameList.add("openssl.cnf");
			fileNameList.add("ca.key");
			fileNameList.add("ca.crt");
			String path = System.getProperty("user.dir") + File.separator + "keys" + File.separator + IdGen.uuid()
					+ File.separator;
			for (String fileName : fileNameList) {
				InputStream is = new ClassPathResource("secret" + File.separator + fileName).getInputStream();
				log.debug("");
				File target = new File(path + fileName);
				FileUtil.backUpInputStreamToFile(is, target);
			}
			map.put("path", path);
		} catch (IOException e) {
			e.printStackTrace();
			log.debug("secret dir backup failed!");
			throw new ServiceException("");
		}
		// set opensll
		setOpenssl(serviceIp, serviceName, routeHostName, project, map.get("path") + "openssl.cnf");

		// create tls.key
		runCmd("openssl genrsa -out " + map.get("path") + "tls.key 2048");

		// create tls.csr
		runCmd("openssl req -new -key " + map.get("path") + "tls.key -subj '/CN=server' -config " + map.get("path")
				+ "openssl.cnf -out " + map.get("path") + "tls.csr");

		// create tls.crt
		runCmd("openssl x509 -req -in " + map.get("path") + "tls.csr -CA " + map.get("path") + "ca.crt -CAkey "
				+ map.get("path") + "ca.key -CAcreateserial -out " + map.get("path")
				+ "tls.crt -days 5000 -extensions v3_req -extfile " + map.get("path") + "openssl.cnf");

		// confirm
		runCmd("openssl x509  -noout -text -in " + map.get("path") + "tls.crt | egrep 'IP Address:'");

		String tlsKeyStr = getFileContent(map.get("path") + "tls.key");
		String tlsKeyStrBase64 = getBase64(tlsKeyStr);
		String tlsCrtStr = getFileContent(map.get("path") + "tls.crt");
		String tlsCrtStrBase64 = getBase64(tlsCrtStr);
		map.put("tls.crt", tlsCrtStrBase64);
		map.put("tls.key", tlsKeyStrBase64);
		log.debug(map.toString());
		return map;

	}

	public static void runCmd(String cmd) {

		try {
			log.debug("==========================cmd" + cmd);
			Process ps = Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c", cmd });
			int exitValue = ps.waitFor();
			log.debug("===================exitValue" + exitValue);
			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			String result = sb.toString();
			log.debug("###############################result:" + result);
		} catch (Exception e) {
			log.debug("====runCmd failed:" +e);
			throw new ServiceException("");
		}
	}

	public static String getBase64(String plainText) {
		String encoded = null;
		try {
			byte[] bytes = plainText.getBytes();
			encoded = Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encoded;
	}

	public static String getPath(String fileName) {
		System.out.println("#########################" + File.separator);
		URL url = SecretUtils.class.getClassLoader().getResource(fileName);
		String filePath = url.toString();
		System.out.println("##########################" + filePath);
		filePath = filePath.replace("file:" + File.separator, "");
		return filePath;
	}

	@SuppressWarnings("deprecation")
	public static String getFileContent(String path) {
		log.debug("===getFileContent param: [ path:" + path);
		String str = "";
		try {
			str = FileUtils.readFileToString(new File(path));
		} catch (IOException e) {
			log.debug("===getFileContent failed:" + e);
			throw new ServiceException("");
		}
		return str;
	}

	public static void main(String[] args) throws Exception {
		InputStream is = new ClassPathResource("secret/openssl.cnf").getInputStream();
		String path = System.getProperty("user.dir") + File.separator + IdGen.uuid() + File.separator + "openssl.cnf";
		log.debug("");
		File target = new File(path);
		FileUtil.backUpInputStreamToFile(is, target);
//		System.out.println(System.getProperty("user.dir"));
//		ClassPathResource classPathResource = new ClassPathResource("secret/server.key");
//
//		InputStream is = classPathResource.getInputStream();
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//		StringBuffer sb = new StringBuffer();
//		String line;
//		while ((line = br.readLine()) != null) {
//			sb.append(line);
//		}
//		String str = sb.toString();
//		System.out.println(str);
//		str = getBase64(str);
//		System.out.println(str);
	}

	public static void setOpenssl(String serviceIp, String serviceName, String routeHostName, String project,
			String opensslPath) {
		log.debug("====setOpenssl param : [ serviceIp" + serviceIp + ";serviceName:" + serviceName +";routeHostName:" + routeHostName + ";project:" + project + "]");
		try {
			File file = new File(opensslPath);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			StringBuilder sb = new StringBuilder();
			String temp;
			int lineNum = 1;
			while ((temp = br.readLine()) != null) {

				if (lineNum == 234) {
					temp = temp.replace(temp, "IP.1 = " + serviceIp);
				} else if (lineNum == 235) {
					// DNS.1 = docker-registry-1.cloud-api-test.svc.cluster.local
					temp = temp.replace(temp, "DNS.1 = " + serviceName + "." + project + ".svc.cluster.local");
				} else if (lineNum == 236) {
					temp = temp.replace(temp, "DNS.2 = " + serviceName + "." + project + ".svc");
				} else if (lineNum == 237) {
					temp = temp.replace(temp, "DNS.3 = " + routeHostName + ".apps.example.com");
				}
				// 没读取一行，最后都需要添加一个回车换行，因为temp字符串是不包含回车换行的。
				sb.append(temp).append("\n");
				lineNum++;
			}
			br.close();

			FileOutputStream fos = new FileOutputStream(file);
			fos.write(sb.toString().getBytes());
			fos.close();

		} catch (Exception e) {
			log.debug("====setOpenssl failed:" +e);
			throw new ServiceException("");
		}

	}

}

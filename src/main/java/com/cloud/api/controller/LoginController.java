/**
 * 
 */
package com.cloud.api.controller;

import java.security.SecureRandom;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.api.dto.UserDTO;
import com.cloud.api.mapper.UserMapper;
import com.cloud.api.service.UserService;

/**
 * @author zhao_pengchen
 *
 */
@Validated
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    private UserService userService;
	
	private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128, -65 };
	
	 @RequestMapping(value = "" , method = RequestMethod.POST)
     public String successLogin(HttpServletRequest request) {
         String username = request.getParameter("username");
         String password = request.getParameter("password");  ///123456
         UserDTO user = userService.findByUserName(username);
             if(decryptBasedDes(user.getPassword()).equals(password)) {
                 return "successLogin";
             }
             return "failure";
     }
	
	 /**
	  * 解密
	  * @param cryptData
	  * @return
	  */
	 @SuppressWarnings("restriction")
     public static String decryptBasedDes(String cryptData) {
         String decryptedData = null;
         try {
             // DES算法要求有一个可信任的随机数源
             SecureRandom sr = new SecureRandom();
             DESKeySpec deskey = new DESKeySpec(DES_KEY);
             // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
             SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
             SecretKey key = keyFactory.generateSecret(deskey);
             // 解密对象
             Cipher cipher = Cipher.getInstance("DES");
             cipher.init(Cipher.DECRYPT_MODE, key, sr);
             // 把字符串进行解码，解码为为字节数组，并解密
             decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
         } catch (Exception e) {
             throw new RuntimeException("解密错误，错误信息：", e);
         }
         return decryptedData;
     }
	 
	 
	 /**
	  * 注册
	  * 使用MD5.encode(entity.getSloginpassword())
	  */
	 
}

package com.sogou.bizdev.dubhews.webservice.client.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Encoder;

/**
 * Get image file base64 or byte code
 * 
 * @author @author@ (@author-email@)
 * 
 * @version @version@, $Date: 2013-7-22$
 *
 */
public class ImageUtil {

	public static String GetImageStrInBase64(String imgFile) {
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}
	
	public static byte[] GetImageByte(String imgFile) {
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static byte[] GetBase64ImageByte(String imgFile) {
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 BASE64Encoder encoder = new BASE64Encoder();  
	     try {
			return encoder.encode(data).getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 返回Base64编码过的字节数组字符串  
		return null;
	}
}

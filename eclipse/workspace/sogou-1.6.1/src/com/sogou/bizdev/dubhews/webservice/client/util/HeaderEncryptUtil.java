package com.sogou.bizdev.dubhews.webservice.client.util;

import com.sogou.bizdev.dubhews.webservice.client.core.ValidatorUtils;

/**
 * Soap header encryt utils
 * 
 * @author
 * @author@ (@author-email@)
 * 
 * @version
 * @version@, $Date: 2013-3-28$
 * 
 */
public class HeaderEncryptUtil {

	public static String generateAgentPassword(String agentName,String token,String agentPassword){
		if (ValidatorUtils.isNull(agentName) ||ValidatorUtils.isNull(token) ||ValidatorUtils.isNull(agentPassword)) {
			return null;
		}
		StringBuilder sb = new StringBuilder(128);
		sb.append(agentName).append("\t");
		sb.append(token).append("\t");
		sb.append(agentPassword);
		return MD5.encode(sb.toString());
	}
	
	public static String generateUserPassword(String userName,String token,String userPassword){
		if (ValidatorUtils.isNull(userName) ||ValidatorUtils.isNull(token) ||ValidatorUtils.isNull(userPassword)) {
			return null;
		}
		StringBuilder sb = new StringBuilder(128);
		sb.append(userName).append("\t");
		sb.append(token).append("\t");
		sb.append(userPassword);
		return MD5.encode(sb.toString());
	}
	
	 
	
}

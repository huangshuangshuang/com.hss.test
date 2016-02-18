/**
 * VersionService.java
 *
 * Copyright @year@ @company@, Inc.
 *
 * @company@ licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.sogou.bizdev.dubhews.webservice.client.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.headers.Header;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sogou.bizdev.dubhews.webservice.client.config.Config;
import com.sogou.bizdev.dubhews.webservice.client.examples.report.User;
import com.sogou.bizdev.dubhews.webservice.client.util.HeaderEncryptUtil;
import com.sogou.bizdev.dubhews.webservice.client.util.MD5;
import com.sogou.bizdev.dubhews.webservice.client.version.V1;
import com.sogou.bizdev.dubhews.webservice.client.version.Version;
import com.sogou.bizdev.dubhews.webservice.common.AuthHeader;

/**
 * Internal use only, please ignore.
 * 
 * @author @author@ (@author-email@)
 * 
 * @version @version@, $Date: 2013-7-30$
 * 
 */
public abstract class VersionService implements Config {
	protected static final Logger log = LoggerFactory.getLogger(VersionService.class);

	protected String serverUrl = "";
	protected String agentusername = "";
	protected String agentpassword = "";
	protected String username = "";
	protected String password = "";

	protected String token = "";
	protected String target = null;
	protected AuthHeader authHeader = null;
	protected boolean disableCNCheck = false;
	protected boolean compressMessage = false;

	protected Integer connectTimeoutMills = 10000;
	protected Integer readTimeoutMills = 1800000;

	private List<Header> headers = null;
	private Version currentVersion = V1.v;

	/**
	 * Get the client side serivce using the Json protocol.
	 * 
	 * @param <T>
	 *            The service interface
	 * @param cls
	 *            The service interface
	 * @return The client side serivce stub.
	 */
	public final <T> T getJsonService(Class<T> cls) {
		return JsonProxy.createProxy(cls, this);
	}

	/**
	 * Get the client side serivce stub with the default version.
	 * 
	 * @param <T>
	 *            The service interface
	 * @param cls
	 *            The service interface
	 * @return The client side serivce stub.
	 */
	public final <T> T getService(Class<T> cls) {
		return getService(cls, currentVersion);
	}

	/**
	 * Get the client side serivce stub.
	 * 
	 * @param <T>
	 *            The service interface
	 * @param cls
	 *            The service interface
	 * @param v
	 *            The version instance
	 * @return The client side serivce stub.
	 */
	public final <T> T getService(Class<T> cls, Version v) {
		T proxy = getInternalService(cls, v);
		Map<String, Object> reqCtxt = ((BindingProvider) proxy).getRequestContext();
		reqCtxt.put(Header.HEADER_LIST, headers);
		reqCtxt.put("com.sun.xml.internal.ws.connect.timeout", connectTimeoutMills);
		reqCtxt.put("com.sun.xml.internal.ws.request.timeout", readTimeoutMills);

		// This will show you how to configure the http conduit dynamically
		Client client = ClientProxy.getClient(proxy);

		// This http is used to configure the http related properties.
		HTTPConduit http = (HTTPConduit) client.getConduit();

		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();

		httpClientPolicy.setConnectionTimeout(connectTimeoutMills);
		httpClientPolicy.setAllowChunking(true);
		httpClientPolicy.setReceiveTimeout(readTimeoutMills);

		http.setClient(httpClientPolicy);

		if (disableCNCheck) {
			TLSClientParameters tlsClientParameters = new TLSClientParameters();
			tlsClientParameters.setDisableCNCheck(true);
			tlsClientParameters.setUseHttpsURLConnectionDefaultHostnameVerifier(false);

			http.setTlsClientParameters(tlsClientParameters);
		}

		return proxy;
	}

	/**
	 * Set the current version to be used when call <code>getService</code>
	 * Please do not call this method directly, it will be called automatically
	 * when reading the configuration file.
	 * 
	 * @param str
	 *            The version marker. For example, V1
	 */
	public void setVersion(String str) {
		currentVersion = Version.getVersion(str);
		if (currentVersion == null) {
			throw new ClientInternalException("The Version you set [" + str + "] does not exist!");
		}
	}

	/**
	 * Set the thread pool size.
	 * 
	 * @param value
	 */
	private void setThreadPoolSize(String value) {
		// executor = Executors.newFixedThreadPool(Integer.parseInt(value));
	}

	/**
	 * Please do not call this method directly, it will be called automatically
	 * when reading the configuration file.
	 * 
	 * @param key
	 *            The configuration key
	 * @param value
	 *            The configuration value
	 * 
	 */
	public void setConfig(String key, String value) {
		try {
			if ("version".equalsIgnoreCase(key)) {
				setVersion(value);
			} else if ("threadPoolSize".equalsIgnoreCase(key)) {
				setThreadPoolSize(value);
			} else {
				setField(VersionService.class.getDeclaredField(key), value);
			}
		} catch (Exception e) {
			log.info("Can not set [" + key + "] into config field: " + e.toString());
		}
	}

	// /////////////////////////////////////////////////////////////////////////////
	// Protected or private methods
	// /////////////////////////////////////////////////////////////////////////////

	protected abstract <T> T getInternalService(Class<T> cls, Version v);

	public void generateHeader() {
		try {
			authHeader = new AuthHeader();
			if (username != null && !"".equals(username)) {
				authHeader.setUsername(username);
				authHeader.setPassword(HeaderEncryptUtil.generateUserPassword(username, token, MD5.encode(password)));
			}
			if (agentusername != null && !"".equals(agentusername)) {
				authHeader.setAgentusername(agentusername);
				authHeader.setAgentpassword(
						HeaderEncryptUtil.generateUserPassword(agentusername, token, MD5.encode(agentpassword)));
			} // authHeader.setToken(token);
				// authHeader.setTarget(target);

			Header header = new Header(new QName(currentVersion.getHeaderNameSpace(), "AuthHeader"), authHeader,
					new JAXBDataBinding(AuthHeader.class));
			headers = new ArrayList<Header>();
			headers.add(header);
			log.info("Current user: " + username);
		} catch (JAXBException e) {
			log.error("Failed to genarate AuthHeader!", e);
			throw new ClientInternalException("Failed to genarate AuthHeader!");
		}
	}

	/**
	 * 自定义函数
	 * 
	 * @param user
	 * @param serverUrl
	 */
	public void init(User user, String serverUrl) {
		this.serverUrl = serverUrl;
		username = user.getApiName();
		password = user.getApiPass();
		token = user.getAccountKey();
		if (username == null || "".equals(username) || token == null||serverUrl==null) {
			throw new IllegalArgumentException("client user information is illegal,username: " + username
					+ " , password: " + password + " , token: " + token+" , serverUrl: "+serverUrl);
		}
		connectTimeoutMills = 10000;
		readTimeoutMills = 1800000;
		generateHeader();
		// 暂留
		/*
		 * if(agentusername!=null&&!"".equals(agentusername)){
		 * authHeader.setAgentusername(agentusername);
		 * authHeader.setAgentpassword(HeaderEncryptUtil.generateUserPassword(
		 * agentusername, token, MD5.encode(agentpassword))); }
		 */
	}

	/**
	 * Change the user in header into another one.
	 * 
	 * @param authHeader
	 * @param service
	 *            The client side service sub.
	 */
	public void updateHeader(AuthHeader authHeader, Object service) {
		try {
			Header header = new Header(new QName(currentVersion.getHeaderNameSpace(), "AuthHeader"), authHeader,
					new JAXBDataBinding(AuthHeader.class));
			List<Header> tmpHeaders = new ArrayList<Header>();
			tmpHeaders.add(header);
			if (service instanceof BindingProvider) {
				Map<String, Object> reqCtxt = ((BindingProvider) service).getRequestContext();
				reqCtxt.put(Header.HEADER_LIST, tmpHeaders);
				log.info("Current user changed to: " + authHeader.getUsername());
			} else {
				throw new IllegalArgumentException("service instance is not correct!");
			}
		} catch (JAXBException e) {
			log.error("Failed to genarate AuthHeader!", e);
			throw new ClientInternalException("Failed to update AuthHeader!");
		}
	}

	private void setField(Field field, String value) throws Exception {
		field.setAccessible(true);
		Class<?> cls = field.getType();
		if (cls.equals(int.class)) {
			field.setInt(this, Integer.parseInt(value));
		} else if (cls.equals(long.class)) {
			field.setLong(this, Long.parseLong(value));
		} else if (cls.equals(boolean.class)) {
			field.setBoolean(this, Boolean.parseBoolean(value));
		} else if (cls.equals(Integer.class)) {
			field.set(this, Integer.parseInt(value));
		} else if (cls.equals(Long.class)) {
			field.set(this, Long.parseLong(value));
		} else if (cls.equals(Boolean.class)) {
			field.set(this, Boolean.parseBoolean(value));
		} else {
			field.set(this, value);
		}
	}
}

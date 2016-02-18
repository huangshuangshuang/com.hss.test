/**
 * ServiceFactory.java
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

import java.util.Properties;
import java.util.Map.Entry;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.common.gzip.GZIPInInterceptor;
import org.apache.cxf.transport.common.gzip.GZIPOutInterceptor;

import com.sogou.bizdev.dubhews.webservice.client.examples.report.User;
import com.sogou.bizdev.dubhews.webservice.client.version.Version;
 
/**
 * The Service Factory, please use this class to create client side service stub.
 * 
 * @author @author@ (@author-email@)
 * 
 * @version @version@, $Date: 2013-7-30$
 * 
 */
public class ServiceFactory extends VersionService {
    
    private static final GZIPInInterceptor IN = new GZIPInInterceptor();
    private static final GZIPOutInterceptor OUT = new GZIPOutInterceptor();

    
    /**
     * The default static block, initialize the GZIP threshold.
     */
    static {
        OUT.setThreshold(1024);
    }

    /**
     * Create ServiceFactory by default properties file: sogou-api.properties
     */
    public ServiceFactory() {
        this("/sogou-api.properties");
    }
    
    /**
     * 自定义构造函数
     * @param user
     */
    public ServiceFactory(User user,String serverUrl) {
    	this(user,serverUrl,false,false);
    }
    /**
     * 自定义构造函数
     * @param user
     */
    public ServiceFactory(User user,String serverUrl,boolean disableCNCheck,boolean compressMessage) {
    	super.init(user,serverUrl);
    	super.disableCNCheck=disableCNCheck;
    	super.compressMessage=compressMessage;
    }

    
  
    
    /**
     * Create ServiceFactory by the given properties file.
     * 
     * @param propertiesFileName
     *            The configuration file name. This file must be put in the classpath.
     */
    public ServiceFactory(String propertiesFileName) {
        super();
        Properties props = new Properties();
        try {
            props.load(ServiceFactory.class.getResourceAsStream(propertiesFileName));
            readConfig(props);
            if (disableCNCheck) {
                // Pass the Host name Verifier, always return true.
                javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(new PassHostnameVerifier());
            }
        } catch (Exception ioe) {
            log.error("Cannot access the config file [" + propertiesFileName + "].", ioe);
        }
        this.generateHeader();
        log.info("Instantiate properties for [" + propertiesFileName + "] was successful.");
    }

    /**
     * Get an instance of ServiceFactory, use <code>sogou-api.properties</code> as the configuration file.
     * 
     * @return ServiceFactory
     */
    public static ServiceFactory getInstance() {
        return new ServiceFactory();
    }

    /**
     * 自定义方法
     * @return
     */
    public static ServiceFactory getInstance(User user,String serverUrl) {
        return new ServiceFactory(user,serverUrl);
    }

    
    
    /**
     * Get an instance of ServiceFactory, use the configuration file you provided.
     * 
     * @param propertiesFileName
     * @return ServiceFactory
     */
    public static ServiceFactory getInstance(String propertiesFileName) {
        return new ServiceFactory(propertiesFileName);
    }

    // /////////////////////////////////////////////////////////////////////////////
    // Protected or private methods
    // /////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    protected <T> T getInternalService(Class<T> cls, Version v) {
        if (cls == null || v == null)
            throw new IllegalArgumentException("Null parameter is not allowed!");
        try {
            String addr = v.getAddr(cls);
            if (addr == null)
                throw new ClientInternalException("Service [" + cls.getSimpleName() + "] not supported by version - "
                        + v.getVersion());
            addr = serverUrl + addr;
            log.info("Current Calling URL: " + addr);
            log.info("Compress Message: " + compressMessage);
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(cls);
            factory.setAddress(addr);
            // This endpoint is used to configure the interceptors.
            if (compressMessage) {
                factory.getInInterceptors().add(IN);
                factory.getInFaultInterceptors().add(IN);
                factory.getOutInterceptors().add(OUT);
                factory.getOutFaultInterceptors().add(OUT);
            }
            
            return (T) factory.create();
        } catch (Exception e) {
            throw new ClientInternalException(e);
        }
    }

    private void readConfig(Properties props) {
        for (Entry<Object, Object> entry : props.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            super.setConfig(key, value);
        }
    }
}

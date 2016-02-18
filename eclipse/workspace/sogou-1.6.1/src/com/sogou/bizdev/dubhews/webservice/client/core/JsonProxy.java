/**
 * JsonProxy.java
 *
 * Copyright 2011 Sogou, Inc.
 *
 * Sogou licenses this file to you under the Apache License, version 2.0
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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sogou.bizdev.dubhews.webservice.client.util.GZIPJsonConnection;
import com.sogou.bizdev.dubhews.webservice.common.AuthHeader;
import com.sogou.bizdev.dubhews.webservice.common.ResHeader;

/**
 * @author @author@ (@author-email@)
 * 
 * @version @version@, $Date: 2013-5-10$
 * 
 */
public class JsonProxy<I> implements InvocationHandler {
    protected static final Logger log = LoggerFactory.getLogger(JsonProxy.class);
    
    private Class<I> interfaces;
    private VersionService service;
    
    /**
     * @param interfaces
     */
    public JsonProxy(Class<I> interfaces, VersionService service) {
        super();
        this.interfaces = interfaces;
        this.service = service;
    }

    /**
     * Create the proxy instance of api client stub. Proxied by JsonProxy.
     * 
     * @param <T> The proxy instannce type.
     * @param interfaces The proxy instannce type class.
     * @param service The original object.
     * @return The proxied object.
     */
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Class<T> interfaces, VersionService service) {
        JsonProxy<T> proxy = new JsonProxy<T>(interfaces, service);
        return (T) Proxy.newProxyInstance(JsonProxy.class.getClassLoader(), new Class<?>[]{interfaces},
                proxy);
    }

    /* (non-Javadoc)
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String addr = service.serverUrl + "/json/sms/v2/" + interfaces.getSimpleName() + '/' + method.getName();
        log.info("Current Calling URL: " + addr);
        JsonConnection conn = new GZIPJsonConnection(addr);
        conn.setConnectTimeout(service.connectTimeoutMills);
        conn.setReadTimeout(service.readTimeoutMills);
        conn.sendRequest(makeRequest(args[0]));
        JsonEnvelop<ResHeader, ?> response = conn.readResponse(ResHeader.class, method.getReturnType());
        ResHeaderUtil.resHeader.set(response.getHeader());
        return response.getBody();
    }
    
    private <K> JsonEnvelop<?, ?> makeRequest(Object args) {
        JsonEnvelop<AuthHeader, Object> body = new JsonEnvelop<AuthHeader, Object>();
        body.setHeader(service.authHeader);
        body.setBody(args);
        return body;
    }

}

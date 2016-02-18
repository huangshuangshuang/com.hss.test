/**
 * GZIPJsonConnection.java
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
package com.sogou.bizdev.dubhews.webservice.client.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.sogou.bizdev.dubhews.webservice.client.core.ClientInternalException;
import com.sogou.bizdev.dubhews.webservice.client.core.JsonConnection;

/**
 * Gzip json connection.
 *  
 * @author @author@ (@author-email@)
 * 
 * @version @version@, $Date: 2013-6-2$
 * 
 */
public class GZIPJsonConnection extends JsonConnection {

    /**
     * @param url The request URL
     * @throws MalformedURLException
     * @throws IOException
     */
    public GZIPJsonConnection(String url) throws MalformedURLException, IOException {
        super(url + "/gzip");
    }

    @Override
    protected InputStream readResponse() {
        try {
            return new GZIPInputStream(super.readResponse());
        } catch (IOException e) {
            throw new ClientInternalException(e);
        }
    }

    @Override
    protected OutputStream sendRequest() {
        try {
            return new GZIPOutputStream(super.sendRequest());
        } catch (IOException e) {
            throw new ClientInternalException(e);
        }
    }

    
}

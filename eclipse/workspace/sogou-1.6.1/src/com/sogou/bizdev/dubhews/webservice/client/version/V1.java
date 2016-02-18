/**
 * Configer.java
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
package com.sogou.bizdev.dubhews.webservice.client.version;


/**
 * The current version configuration class, used to configure QName and service address.
 * 
 * @author @author@ (@author-email@)
 * 
 * @version @version@, $Date: 2013-7-30$
 * 
 */
public class V1 extends Version {
	private static final String NAMESPACE_COMMON = "http://api.sogou.com/sem/common/v1";
	
	public static final V1 v = new V1();

	private V1() {}

	@Override
	public String getVersion() {
		return "V1";
	}

	@Override
	public <T> String getAddr(Class<T> cls) {
	    String pkgName = cls.getPackage().getName();
	    if (pkgName.contains("sms"))
	        return "/sem/sms/v1/" + cls.getSimpleName();
	    else
	        return "/sem/nms/v1/" + cls.getSimpleName();
	}

	@Override
	public String getHeaderNameSpace() {
		return NAMESPACE_COMMON;
	}

}

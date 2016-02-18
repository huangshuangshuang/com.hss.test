/**
 * ValidatorUtils.java
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

import java.math.BigDecimal;
import java.util.List;
/**
 * The Validator Utils, please use this class to validate object is null.
 * 
 * @author @author@ (@author-email@)
 * 
 * @version @version@, $Date: 2013-7-30$
 * 
 */
public class ValidatorUtils {
	public static boolean isNull(Object object){
		if(object==null){
			return true;
		}else if(object instanceof Long){
			Long temp=(Long)object;
			if(temp==null||temp.intValue()==0){
				return true;
			}
 		}else if(object instanceof Double){
 			Double temp=(Double)object;
 			BigDecimal data1 = new BigDecimal(temp); 
 			BigDecimal data2 = new BigDecimal(0.0d); 
 			if(temp==null||data1.compareTo(data2) ==0){
 				return true;
 			}
 		}else if(object instanceof String){
 			String temp=(String)object;
  			if(temp==null||"".equals(temp)){
 				return true;
 			}
 		}else if(object instanceof List){
 			List temp=(List)object;
  			if(temp==null||temp.isEmpty()){
 				return true;
 			}
 		}
		return false;
	}
	
	
}

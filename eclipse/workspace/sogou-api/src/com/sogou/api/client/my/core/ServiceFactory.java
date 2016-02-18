/**
 * 
 */
package com.sogou.api.client.my.core;

/**
 * @author zhangjuncheng
 *
 */
public interface ServiceFactory {

	public <T> T getWebService(Class<T> clz);

}

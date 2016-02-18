package com.sogou.api.client.my.core;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import com.sogou.api.sem.v1.report.service.ReportService;

public class VersionOne implements APIVersion {

	public static final String NAMESPACE_COMMON = "http://api.sogou.com/sem/common/v1";
	public static final String NAME_SPACE = "https://api.sogou.com/sem/nms/v1";
	private static Map<String, String> urls = new HashMap<String, String>();
	private static Map<String, QName> qNames = new HashMap<String, QName>();

	static {
		registerURL(ReportService.class);
		registerQName(ReportService.class);

	}

	private static <T> void registerURL(Class<T> clz) {
		urls.put(clz.getName(), "/sem/nms/v1/" + clz.getSimpleName() + "?wsdl");
	}

	private static <T> void registerQName(Class<T> clz) {
		qNames.put(clz.getName(), new QName(NAME_SPACE, clz.getSimpleName()));
	}

	@Override
	public <T> String getServiceURL(Class<T> clz) {
		return urls.get(clz.getName());
	}

	@Override
	public <T> QName getServiceQName(Class<T> clz) {
		return qNames.get(clz.getName());
	}

	public static APIVersion VERSION = new VersionOne();

	private VersionOne() {
		super();
	}

	@Override
	public String getVersion() {

		return "v1";
	}

}

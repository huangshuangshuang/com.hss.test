package com.sogou.bizdev.dubhews.webservice.client.examples.report;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sogou.bizdev.dubhews.webservice.client.core.ServiceFactory;
import com.sogou.bizdev.dubhews.webservice.client.core.VersionService;
import com.sogou.bizdev.dubhews.webservice.report.service.ReportService;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportFileUrlRequest;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportFileUrlResponse;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportIdRequest;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportIdResponse;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportStateRequest;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportStateResponse;
import com.sogou.bizdev.dubhews.webservice.report.type.ReportRequestType;

public class Test {
	private ReportService service;
	ReportRequestType reportRequestType=new ReportRequestType();
	public void update(User user) throws Exception {
		VersionService factory = ServiceFactory.getInstance(user,Address.SOGOU_ALLIANCE);
		this.service = factory.getService(ReportService.class);
		GetReportIdRequest parameter = new GetReportIdRequest();
		ReportRequestType request = new ReportRequestType();
		request.setReportName("sogou"+System.currentTimeMillis());
		request.setReportType(103);//103. 创意报告
		request.setReportDataSource(10);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date startDate=format.parse("2015-10-01");
		request.setStartDate(startDate);
		Date endDate=format.parse("2015-10-30");
		request.setEndDate(endDate);
		request.setStatRange(4);//4. 计划
		request.getPerformanceData().add(2);//click
		request.getPerformanceData().add(4);//pv
		request.getPerformanceData().add(5);//ctr
		request.getPerformanceData().add(7);//consume
		request.getPerformanceData().add(8);//cpc 
		//idOnly is not required, default value is false which means you can get literal info of material in returned result.
		//When literal info is not that useful for you, we appreciate you set true to this field, which could provide you with higher performance
		request.setIdOnly(false);
		//format is not required, default value is 0, means zip. you can specify 1 to csv
		request.setTimeGranularity(0);//0.天
		parameter.setReportRequestType(request);
		// Invoke the method.
		GetReportIdResponse ret = service.getReportId(parameter);
		// This is the request
		
		// Deal with the response header, the second parameter controls whether to print the response header to console
		// or not.
		GetReportStateResponse ret0;
		do{
			Thread.sleep(500);
			GetReportStateRequest parameters = new GetReportStateRequest();
			parameters.setReportId(ret.getReportId());
			// Invoke the method.
			ret0 = service.getReportState(parameters);
		}while(ret0.getIsGenerated()!=6&&ret0.getIsGenerated()!=7);
		GetReportFileUrlRequest parame = new GetReportFileUrlRequest();
		parame.setReportId(ret.getReportId());
		// Invoke the method.
		GetReportFileUrlResponse ret1 = service.getReportFileUrl(parame);
		System.out.println(ret1.getReportFilePath());
		System.err.println("完成报告代码："+ret0.getIsGenerated());
				
	}
	public static void main(String[] args) {
		Test test=new Test();
		User user=new User();
		user.setApiName("haowuchina@sohu.com");
		user.setApiPass("Zghwid@123");
		user.setAccountKey("74f2992836440aaf0e541e4491e81571");
		try {
			test.update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.sogou.bizdev.dubhews.webservice.client.examples.report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sogou.bizdev.dubhews.webservice.client.core.ClientBusinessException;
import com.sogou.bizdev.dubhews.webservice.client.core.ResHeaderUtil;
import com.sogou.bizdev.dubhews.webservice.client.core.ServiceFactory;
import com.sogou.bizdev.dubhews.webservice.client.core.VersionService;
import com.sogou.bizdev.dubhews.webservice.client.util.ObjToStringUtil;
import com.sogou.bizdev.dubhews.webservice.common.ResHeader;
import com.sogou.bizdev.dubhews.webservice.report.service.ReportService;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportFileUrlRequest;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportFileUrlResponse;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportIdRequest;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportIdResponse;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportStateRequest;
import com.sogou.bizdev.dubhews.webservice.report.type.GetReportStateResponse;
import com.sogou.bizdev.dubhews.webservice.report.type.ReportRequestType;
 

/**
 * 
 * ClassName: ReportServiceExample  <br>
 * Function: TODO ADD FUNCTION
 *
 * @author Sogou API Team
 * @date 2013-7-30
 */
public class ReportServiceExample {

	private ReportService service;

	public ReportServiceExample() {
		// Get service factory. Your authentication information will be popped up automatically from
		// sogou-api.properties
		VersionService factory = ServiceFactory.getInstance();
		// Get service stub by given the Service interface.
		// Please see the bean-api.tar.gz to get more details about all the service interfaces.
		this.service = factory.getService(ReportService.class);
	}

	public GetReportIdResponse getReportId() {
		// Prepare your parameters.
		GetReportIdRequest parameter = new GetReportIdRequest();
		// get report
		ReportRequestType request = new ReportRequestType();
		request.setReportName("sogou"+System.currentTimeMillis());
		request.setReportType(103);//103. 创意报告
		request.setReportDataSource(10);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate = format.parse("2015-10-01");
			request.setStartDate(startDate);
			Date endDate=format.parse("2015-10-30");
			request.setEndDate(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		// Deal with the response header, the second parameter controls whether to print the response header to console
		// or not.
		ResHeader rheader = ResHeaderUtil.getResHeader(service, true);
		// If status equals zero, there is no error. Otherwise, you need to check the errors in the response header.
		if (rheader.getStatus() == 0) {
			System.out.println("result\n" + ObjToStringUtil.objToString(ret));
			return ret;
		} else {
			throw new ClientBusinessException(rheader, ret);
		}
	}

	public GetReportStateResponse getReportState(long reportId) {
		// This is the request
		GetReportStateRequest parameters = new GetReportStateRequest();
		parameters.setReportId(reportId);
		// Invoke the method.
		GetReportStateResponse ret = service.getReportState(parameters);
		// Deal with the response header, the second parameter controls whether to print the response header to console
		// or not.
		ResHeader rheader = ResHeaderUtil.getResHeader(service, true);
		// If status equals zero, there is no error. Otherwise, you need to check the errors in the response header.
		if (rheader.getStatus() == 0) {
			System.out.println("getReportState.result\n" + ObjToStringUtil.objToString(ret));
			return ret;
		} else {
			throw new ClientBusinessException(rheader, ret);
		}
	}

	public GetReportFileUrlResponse getReportFileUrl(long reportId) {
		// This is the request
		GetReportFileUrlRequest parameters = new GetReportFileUrlRequest();
		parameters.setReportId(reportId);
		// Invoke the method.
		GetReportFileUrlResponse ret = service.getReportFileUrl(parameters);
		// Deal with the response header, the second parameter controls whether to print the response header to console
		// or not.
		ResHeader rheader = ResHeaderUtil.getResHeader(service, true);
		// If status equals zero, there is no error. Otherwise, you need to check the errors in the response header.
		if (rheader.getStatus() == 0) {
			System.out.println("getReportFileUrl.result\n" + ObjToStringUtil.objToString(ret));
			return ret;
		} else {
			throw new ClientBusinessException(rheader, ret);
		}
	}

	public static void main(String[] args) throws Exception {
		ReportServiceExample example = new ReportServiceExample();
		GetReportIdResponse id = example.getReportId();

		while(example.getReportState(id.getReportId()).getIsGenerated()!=7&&example.getReportState(id.getReportId()).getIsGenerated()!=6){
			Thread.sleep(1000);
		}
		System.out.println(example.getReportState(id.getReportId()).getIsGenerated());
		GetReportFileUrlResponse urlRes = example.getReportFileUrl(id.getReportId()); 
		System.out.println("urlRes="+urlRes.getReportFilePath());
	}

}

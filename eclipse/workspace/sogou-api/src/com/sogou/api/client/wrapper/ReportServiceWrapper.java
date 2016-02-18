package com.sogou.api.client.wrapper;

import javax.xml.ws.BindingProvider;

import com.sogou.api.client.core.ServiceFactory;
import com.sogou.api.client.core.SogouAdServiceFactory;
import com.sogou.api.client.exception.BusinessException;
import com.sogou.api.client.utils.ResHeaderUtils;
import com.sogou.api.sem.v1.common.ResHeader;
import com.sogou.api.sem.v1.report.GetReportIdRequest;
import com.sogou.api.sem.v1.report.GetReportIdResponse;
import com.sogou.api.sem.v1.report.GetReportPathRequest;
import com.sogou.api.sem.v1.report.GetReportPathResponse;
import com.sogou.api.sem.v1.report.GetReportStateRequest;
import com.sogou.api.sem.v1.report.GetReportStateResponse;
import com.sogou.api.sem.v1.report.ReportService;

public class ReportServiceWrapper {

	private ReportService reportService;

	public ReportServiceWrapper() {
		ServiceFactory sf = SogouAdServiceFactory.getInstance();
		reportService = sf.getWebService(ReportService.class);
	}

	public GetReportStateResponse getReportState(GetReportStateRequest parameters) {
		GetReportStateResponse response = reportService.getReportState(parameters);
		ResHeader rheader = ResHeaderUtils.getResHeader((BindingProvider) reportService);
		if (rheader.getStatus() != 0) {
			throw new BusinessException(rheader, response);
		}
		return response;
	}

	public GetReportPathResponse getReportPath(GetReportPathRequest parameters) {
		GetReportPathResponse response = reportService.getReportPath(parameters);
		ResHeader rheader = ResHeaderUtils.getResHeader((BindingProvider) reportService);
		if (rheader.getStatus() != 0) {
			throw new BusinessException(rheader, response);
		}
		return response;
	}

	public GetReportIdResponse getReportId(GetReportIdRequest parameters) {
		GetReportIdResponse response = reportService.getReportId(parameters);
		ResHeader rheader = ResHeaderUtils.getResHeader((BindingProvider) reportService);
		if (rheader.getStatus() != 0) {
			throw new BusinessException(rheader, response);
		}
		return response;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

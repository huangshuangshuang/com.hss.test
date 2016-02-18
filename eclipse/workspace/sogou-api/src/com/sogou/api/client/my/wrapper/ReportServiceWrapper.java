package com.sogou.api.client.my.wrapper;

import javax.xml.ws.BindingProvider;

import com.sogou.api.client.my.core.ServiceFactory;
import com.sogou.api.client.my.core.SogouAdServiceFactory;
import com.sogou.api.client.my.exception.BusinessException;
import com.sogou.api.client.my.util.ResHeaderUtils;
import com.sogou.api.sem.v1.common.ResHeader;
import com.sogou.api.sem.v1.report.service.DeleteReportRequest;
import com.sogou.api.sem.v1.report.service.DeleteReportResponse;
import com.sogou.api.sem.v1.report.service.GetReportFileUrlRequest;
import com.sogou.api.sem.v1.report.service.GetReportFileUrlResponse;
import com.sogou.api.sem.v1.report.service.GetReportIdRequest;
import com.sogou.api.sem.v1.report.service.GetReportIdResponse;
import com.sogou.api.sem.v1.report.service.GetReportStateRequest;
import com.sogou.api.sem.v1.report.service.GetReportStateResponse;
import com.sogou.api.sem.v1.report.service.ReportService;

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

	public GetReportFileUrlResponse getReportFileUrl(GetReportFileUrlRequest parameters) {
		GetReportFileUrlResponse response = reportService.getReportFileUrl(parameters);
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

	public DeleteReportResponse deleteReport(DeleteReportRequest parameters) {
		DeleteReportResponse response = reportService.deleteReport(parameters);
		ResHeader rHeader = ResHeaderUtils.getResHeader((BindingProvider) reportService);
		if (rHeader.getStatus() != 0) {
			throw new BusinessException(rHeader, response);
		}
		return response;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

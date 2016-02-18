package com.sogou.api.client.my.examples;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sogou.api.client.my.util.FileDownloadUtils;
import com.sogou.api.client.my.util.ReportUtils;
import com.sogou.api.client.my.util.ZipUtils;
import com.sogou.api.sem.v1.report.service.GetReportIdRequest;
import com.sogou.api.sem.v1.report.service.ReportRequestType;

public class Test {
	public static void main(String[] args) {
		GetReportIdRequest getReportIdRequest = new GetReportIdRequest();
		ReportRequestType reportRequestType = new ReportRequestType();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date createTime = null;
		try {
			createTime = sdf.parse("2015-10-31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date endTime = null;
		try {
			endTime = sdf.parse("2015-10-31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reportRequestType.setStartDate(createTime);
		reportRequestType.setEndDate(endTime);
		reportRequestType.setTimeGranularity(0);
		reportRequestType.setReportType(103);
		// reportRequestType.setReportDataSource(10);
		reportRequestType.setReportName("what");
		reportRequestType.setStatRange(4);
		reportRequestType.setPerformanceData(new int[] { 2, 4, 5, 7, 8 });
		getReportIdRequest.setReportRequestType(reportRequestType);

		String url = ReportUtils.getReportDownloadURL(getReportIdRequest, 10);
		System.out.println("aaa" + url);
		try {
			String reportFile = "D:/logs/report.gzip";
			FileDownloadUtils.downloadFile(url, reportFile);
			// 报表使用的gzip进行的压缩
			ZipUtils.unGzipFile(reportFile, "D:/logs/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

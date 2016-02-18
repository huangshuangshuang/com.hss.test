package com.sogou.api.client.examples;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sogou.api.client.utils.FileDownloadUtils;
import com.sogou.api.client.utils.ReportUtils;
import com.sogou.api.client.utils.ZipUtils;
import com.sogou.api.sem.v1.report.GetReportIdRequest;
import com.sogou.api.sem.v1.report.ReportRequestType;

public class ReportServiceExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GetReportIdRequest getReportIdRequest = new GetReportIdRequest();
		ReportRequestType reportRequestType = new ReportRequestType();
		List<String> list = new ArrayList<String>();
		list.add("cost");
		list.add("cpc");
		list.add("click");
		list.add("impression");
		list.add("ctr");

		reportRequestType.setPerformanceData(list);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		Date createTime = null;
		try {
			createTime = sdf.parse("2015-10-01T00:00:00.000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date endTime = null;
		try {
			endTime = sdf.parse("2015-10-05T23:59:59.000");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reportRequestType.setStartDate(createTime);
		reportRequestType.setEndDate(endTime);
		reportRequestType.setReportType(5);
		getReportIdRequest.setReportRequestType(reportRequestType);

		getReportIdRequest.setReportRequestType(reportRequestType);
		String url = ReportUtils.getReportDownloadURL(getReportIdRequest, 10);
		System.out.println(url);
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

package com.sogou.api.sem.v1.report.service;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sogou.api.sem.v1.common.Adapter1;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportRequestType", namespace = "https://api.sogou.com/sem/nms/v1", propOrder = { "reportName",
		"emails", "timeGranularity", "startDate", "endDate", "performanceData", "idOnly", "reportType", "statRange",
		"statIds", "reportDataSource", "fileType" })

public class ReportRequestType {
	@XmlElement(name = "")
	private String reportName;
	@XmlElement(name = "")
	private String[] emails;
	@XmlElement(name = "")
	private int timeGranularity;
	@XmlElement(namespace = "", required = true, type = String.class)
	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlSchemaType(name = "date")
	private Date startDate;
	@XmlElement(namespace = "", required = true, type = String.class)
	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlSchemaType(name = "date")
	private Date endDate;
	@XmlElement(name = "")
	private int[] performanceData;
	@XmlElement(name = "")
	private boolean idOnly;
	@XmlElement(name = "")
	private int reportType;
	@XmlElement(name = "")
	private int statRange;
	@XmlElement(name = "")
	private long[] statIds;
	@XmlElement(name = "")
	private int reportDataSource;
	@XmlElement(name = "")
	private int fileType;

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String[] getEmails() {
		return emails;
	}

	public void setEmails(String[] emails) {
		this.emails = emails;
	}

	public int getTimeGranularity() {
		return timeGranularity;
	}

	public void setTimeGranularity(int timeGranularity) {
		this.timeGranularity = timeGranularity;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int[] getPerformanceData() {
		return performanceData;
	}

	public void setPerformanceData(int[] performanceData) {
		this.performanceData = performanceData;
	}

	public boolean isIdOnly() {
		return idOnly;
	}

	public void setIdOnly(boolean idOnly) {
		this.idOnly = idOnly;
	}

	public int getReportType() {
		return reportType;
	}

	public void setReportType(int reportType) {
		this.reportType = reportType;
	}

	public int getStatRange() {
		return statRange;
	}

	public void setStatRange(int statRange) {
		this.statRange = statRange;
	}

	public long[] getStatIds() {
		return statIds;
	}

	public void setStatIds(long[] statIds) {
		this.statIds = statIds;
	}

	public int getReportDataSource() {
		return reportDataSource;
	}

	public void setReportDataSource(int reportDataSource) {
		this.reportDataSource = reportDataSource;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

}

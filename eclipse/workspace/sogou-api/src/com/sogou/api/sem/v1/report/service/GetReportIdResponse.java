
package com.sogou.api.sem.v1.report.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "reportId" })
@XmlRootElement(name = "getReportIdResponse", namespace = "https://api.sogou.com/sem/nms/v1")
public class GetReportIdResponse {

	@XmlElement(namespace = "")
	protected Long reportId;

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		if (reportId != null) {
			System.out.println(reportId);
		}
		this.reportId = reportId;
	}

}

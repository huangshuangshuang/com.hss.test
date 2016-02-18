
package com.sogou.api.sem.v1.report.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "reportRequestType" })
@XmlRootElement(name = "getReportIdRequest", namespace = "https://api.sogou.com/sem/nms/v1")
public class GetReportIdRequest {

	@XmlElement(namespace = "", required = true)
	protected ReportRequestType reportRequestType;

	/**
	 * Gets the value of the reportRequestType property.
	 * 
	 * @return possible object is {@link ReportRequestType }
	 * 
	 */
	public ReportRequestType getReportRequestType() {
		return reportRequestType;
	}

	/**
	 * Sets the value of the reportRequestType property.
	 * 
	 * @param value
	 *            allowed object is {@link ReportRequestType }
	 * 
	 */
	public void setReportRequestType(ReportRequestType value) {
		this.reportRequestType = value;
	}

}

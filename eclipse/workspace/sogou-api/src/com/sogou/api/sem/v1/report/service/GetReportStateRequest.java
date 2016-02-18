
package com.sogou.api.sem.v1.report.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "reportId" })
@XmlRootElement(name = "getReportStateRequest", namespace = "https://api.sogou.com/sem/nms/v1")
public class GetReportStateRequest {

	@XmlElement(namespace = "", required = true)
	protected Long reportId;

	/**
	 * Gets the value of the reportId property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getReportId() {
		return reportId;
	}

	/**
	 * Sets the value of the reportId property.
	 * 
	 * @param value
	 *            allowed object is {@link Long }
	 * 
	 */
	public void setReportId(Long value) {
		this.reportId = value;
	}

}

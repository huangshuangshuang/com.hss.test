package com.sogou.api.sem.v1.report.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "isDeleted" })
@XmlRootElement(name = "deleteReportResponse", namespace = "https://api.sogou.com/sem/nms/v1")
public class DeleteReportResponse {

	@XmlElement(namespace = "")
	protected Integer isDeleted;

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

}

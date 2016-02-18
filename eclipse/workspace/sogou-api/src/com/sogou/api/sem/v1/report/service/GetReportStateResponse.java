
package com.sogou.api.sem.v1.report.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "isGenerated" })
@XmlRootElement(name = "getReportStateResponse", namespace = "https://api.sogou.com/sem/nms/v1")
public class GetReportStateResponse {
	/**
	 * PAUSED = 0, //("报告暂停中"), NORMAL = 1, //("报告正常"), RUNNING = 2, //("正在运行"),
	 * FAILED_FINISH_DATA_ERROR = 3, //("非正常运行完毕(数据错误)"),
	 * FAILED_FINISH_MAIL_ERROR = 4, //("非正常运行完毕(邮件发送误)"), FAILED_FINISH = 5,
	 * //("非正常运行完"), SUCCESS_FINISH = 6, //("正常运行完毕"); SUCCESS_NO_DATA = 7,
	 * //("正常运行完毕,但没有数据");
	 */
	@XmlElement(namespace = "")
	protected Integer isGenerated;

	/**
	 * Gets the value of the isGenerated property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getIsGenerated() {
		return isGenerated;
	}

	/**
	 * Sets the value of the isGenerated property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setIsGenerated(Integer value) {
		this.isGenerated = value;
	}

}


package com.sogou.api.sem.v1.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sogou.api.sem.v1.common.Adapter1;
import com.sogou.api.sem.v1.common.OptType;

/**
 * <p>
 * Java class for ReportRequestType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ReportRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="performanceData" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="idOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="levelOfDetails" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="opt" type="{http://api.sogou.com/sem/common/v1}OptType" minOccurs="0"/>
 *         &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="reportType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="statIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="statRange" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="unitOfTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="platform" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportRequestType", namespace = " https://api.sogou.com/sem/sms/v1", propOrder = { "performanceData",
		"startDate", "endDate", "idOnly", "levelOfDetails", "opt", "format", "reportType", "statIds", "statRange",
		"unitOfTime", "platform" })
public class ReportRequestType {

	@XmlElement(namespace = "", required = true)
	protected List<String> performanceData;
	@XmlElement(namespace = "", required = true, type = String.class)
	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlSchemaType(name = "dateTime")
	protected Date startDate;
	@XmlElement(namespace = "", required = true, type = String.class)
	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlSchemaType(name = "dateTime")
	protected Date endDate;
	@XmlElement(namespace = "")
	protected Boolean idOnly;
	@XmlElement(namespace = "")
	protected Integer levelOfDetails;
	@XmlElement(namespace = "")
	protected OptType opt;
	@XmlElement(namespace = "")
	protected Integer format;
	@XmlElement(namespace = "")
	protected int reportType;
	@XmlElement(namespace = "", type = Long.class)
	protected List<Long> statIds;
	@XmlElement(namespace = "")
	protected Integer statRange;
	@XmlElement(namespace = "")
	protected Integer unitOfTime;
	@XmlElement(namespace = "")
	protected Integer platform;

	public void setPerformanceData(List<String> performanceData) {
		this.performanceData = performanceData;
	}

	public Boolean getIdOnly() {
		return idOnly;
	}

	public void setStatIds(List<Long> statIds) {
		this.statIds = statIds;
	}

	/**
	 * Gets the value of the performanceData property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the performanceData property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPerformanceData().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */

	public List<String> getPerformanceData() {
		if (performanceData == null) {
			performanceData = new ArrayList<String>();
		}
		return this.performanceData;
	}

	/**
	 * Gets the value of the startDate property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the value of the startDate property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStartDate(Date value) {
		this.startDate = value;
	}

	/**
	 * Gets the value of the endDate property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the value of the endDate property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEndDate(Date value) {
		this.endDate = value;
	}

	/**
	 * Gets the value of the idOnly property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIdOnly() {
		return idOnly;
	}

	/**
	 * Sets the value of the idOnly property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIdOnly(Boolean value) {
		this.idOnly = value;
	}

	/**
	 * Gets the value of the levelOfDetails property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getLevelOfDetails() {
		return levelOfDetails;
	}

	/**
	 * Sets the value of the levelOfDetails property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setLevelOfDetails(Integer value) {
		this.levelOfDetails = value;
	}

	/**
	 * Gets the value of the opt property.
	 * 
	 * @return possible object is {@link com.sogou.api.sem.v1.common.OptType }
	 * 
	 */
	public OptType getOpt() {
		return opt;
	}

	/**
	 * Sets the value of the opt property.
	 * 
	 * @param value
	 *            allowed object is {@link com.sogou.api.sem.v1.common.OptType }
	 * 
	 */
	public void setOpt(OptType value) {
		this.opt = value;
	}

	/**
	 * Gets the value of the format property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getFormat() {
		return format;
	}

	/**
	 * Sets the value of the format property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setFormat(Integer value) {
		this.format = value;
	}

	/**
	 * Gets the value of the reportType property.
	 * 
	 */
	public int getReportType() {
		return reportType;
	}

	/**
	 * Sets the value of the reportType property.
	 * 
	 */
	public void setReportType(int value) {
		this.reportType = value;
	}

	/**
	 * Gets the value of the statIds property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the statIds property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getStatIds().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Long }
	 * 
	 * 
	 */
	public List<Long> getStatIds() {
		if (statIds == null) {
			statIds = new ArrayList<Long>();
		}
		return this.statIds;
	}

	/**
	 * Gets the value of the statRange property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getStatRange() {
		return statRange;
	}

	/**
	 * Sets the value of the statRange property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setStatRange(Integer value) {
		this.statRange = value;
	}

	/**
	 * Gets the value of the unitOfTime property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getUnitOfTime() {
		return unitOfTime;
	}

	/**
	 * Sets the value of the unitOfTime property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setUnitOfTime(Integer value) {
		this.unitOfTime = value;
	}

	/**
	 * Gets the value of the platform property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getPlatform() {
		return platform;
	}

	/**
	 * Sets the value of the platform property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setPlatform(Integer value) {
		this.platform = value;
	}

	@Override
	public String toString() {
		return "ReportRequestType [performanceData=" + performanceData + ", startDate=" + startDate + ", endDate="
				+ endDate + ", idOnly=" + idOnly + ", levelOfDetails=" + levelOfDetails + ", opt=" + opt + ", format="
				+ format + ", reportType=" + reportType + ", statIds=" + statIds + ", statRange=" + statRange
				+ ", unitOfTime=" + unitOfTime + ", platform=" + platform + "]";
	}

}

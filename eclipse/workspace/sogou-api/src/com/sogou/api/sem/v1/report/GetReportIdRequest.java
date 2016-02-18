
package com.sogou.api.sem.v1.report;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reportRequestType" type="{https://api.sogou.com/sem/sms/v1}ReportRequestType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reportRequestType"
})
@XmlRootElement(name = "getReportIdRequest", namespace = "https://api.sogou.com/sem/sms/v1")
public class GetReportIdRequest {

    @XmlElement(namespace = "", required = true)
    protected ReportRequestType reportRequestType;

    /**
     * Gets the value of the reportRequestType property.
     * 
     * @return
     *     possible object is
     *     {@link ReportRequestType }
     *     
     */
    public ReportRequestType getReportRequestType() {
        return reportRequestType;
    }

    /**
     * Sets the value of the reportRequestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportRequestType }
     *     
     */
    public void setReportRequestType(ReportRequestType value) {
        this.reportRequestType = value;
    }

}

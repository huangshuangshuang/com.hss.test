
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
 *         &lt;element name="reportFilePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "reportFilePath"
})
@XmlRootElement(name = "getReportPathResponse", namespace = "https://api.sogou.com/sem/sms/v1")
public class GetReportPathResponse {

    @XmlElement(namespace = "")
    protected String reportFilePath;

    /**
     * Gets the value of the reportFilePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportFilePath() {
        return reportFilePath;
    }

    /**
     * Sets the value of the reportFilePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportFilePath(String value) {
        this.reportFilePath = value;
    }

}

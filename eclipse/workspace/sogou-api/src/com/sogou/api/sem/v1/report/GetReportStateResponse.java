
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
 *         &lt;element name="isGenerated" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "isGenerated"
})
@XmlRootElement(name = "getReportStateResponse", namespace = "https://api.sogou.com/sem/sms/v1")
public class GetReportStateResponse {

    @XmlElement(namespace = "")
    protected Integer isGenerated;

    /**
     * Gets the value of the isGenerated property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIsGenerated() {
        return isGenerated;
    }

    /**
     * Sets the value of the isGenerated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIsGenerated(Integer value) {
        this.isGenerated = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.27 at 04:04:49 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DescribeLaunchConfigurationsResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DescribeLaunchConfigurationsResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LaunchConfigurations" type="{}LaunchConfigurations"/>
 *         &lt;element name="NextToken" type="{}XmlString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DescribeLaunchConfigurationsResultType", propOrder = {
    "launchConfigurations",
    "nextToken"
})
public class DescribeLaunchConfigurationsResultType {

    @XmlElement(name = "LaunchConfigurations", required = true)
    protected LaunchConfigurationsType launchConfigurations;
    @XmlElement(name = "NextToken")
    protected String nextToken;

    /**
     * Gets the value of the launchConfigurations property.
     * 
     * @return
     *     possible object is
     *     {@link LaunchConfigurations }
     *     
     */
    public LaunchConfigurationsType getLaunchConfigurations() {
        return launchConfigurations;
    }

    /**
     * Sets the value of the launchConfigurations property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaunchConfigurations }
     *     
     */
    public void setLaunchConfigurations(LaunchConfigurationsType value) {
        this.launchConfigurations = value;
    }

    /**
     * Gets the value of the nextToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextToken() {
        return nextToken;
    }

    /**
     * Sets the value of the nextToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextToken(String value) {
        this.nextToken = value;
    }

}

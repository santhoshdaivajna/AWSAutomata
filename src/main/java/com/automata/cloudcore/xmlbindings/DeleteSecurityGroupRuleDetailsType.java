//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.28 at 01:31:38 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeleteSecurityGroupRuleDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeleteSecurityGroupRuleDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SecurityGroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FromPort" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ToPort" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Protocol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CidrIP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Region" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeleteSecurityGroupRuleDetailsType", propOrder = {
    "securityGroupName",
    "fromPort",
    "toPort",
    "protocol",
    "cidrIP",
    "region",
    "status"
})
public class DeleteSecurityGroupRuleDetailsType {

    @XmlElement(name = "SecurityGroupName", required = true)
    protected String securityGroupName;
    @XmlElement(name = "FromPort")
    protected int fromPort;
    @XmlElement(name = "ToPort")
    protected int toPort;
    @XmlElement(name = "Protocol", required = true)
    protected String protocol;
    @XmlElement(name = "CidrIP", required = true)
    protected String cidrIP;
    @XmlElement(name = "Region", required = true)
    protected String region;
    @XmlElement(name = "Status", required = true)
    protected String status;

    /**
     * Gets the value of the securityGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityGroupName() {
        return securityGroupName;
    }

    /**
     * Sets the value of the securityGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityGroupName(String value) {
        this.securityGroupName = value;
    }

    /**
     * Gets the value of the fromPort property.
     * 
     */
    public int getFromPort() {
        return fromPort;
    }

    /**
     * Sets the value of the fromPort property.
     * 
     */
    public void setFromPort(int value) {
        this.fromPort = value;
    }

    /**
     * Gets the value of the toPort property.
     * 
     */
    public int getToPort() {
        return toPort;
    }

    /**
     * Sets the value of the toPort property.
     * 
     */
    public void setToPort(int value) {
        this.toPort = value;
    }

    /**
     * Gets the value of the protocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocol(String value) {
        this.protocol = value;
    }

    /**
     * Gets the value of the cidrIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCidrIP() {
        return cidrIP;
    }

    /**
     * Sets the value of the cidrIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCidrIP(String value) {
        this.cidrIP = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}

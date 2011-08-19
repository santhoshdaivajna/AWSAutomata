//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.08.06 at 02:19:19 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BlockDeviceMappingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BlockDeviceMappingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualName" type="{}XmlStringMaxLen255" minOccurs="0"/>
 *         &lt;element name="DeviceName" type="{}XmlStringMaxLen255"/>
 *         &lt;element name="Ebs" type="{}EbsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BlockDeviceMappingType", propOrder = {
    "virtualName",
    "deviceName",
    "ebs"
})
public class BlockDeviceMappingType {

    @XmlElement(name = "VirtualName")
    protected String virtualName;
    @XmlElement(name = "DeviceName", required = true)
    protected String deviceName;
    @XmlElement(name = "Ebs")
    protected EbsType ebs;

    /**
     * Gets the value of the virtualName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVirtualName() {
        return virtualName;
    }

    /**
     * Sets the value of the virtualName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVirtualName(String value) {
        this.virtualName = value;
    }

    /**
     * Gets the value of the deviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Sets the value of the deviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceName(String value) {
        this.deviceName = value;
    }

    /**
     * Gets the value of the ebs property.
     * 
     * @return
     *     possible object is
     *     {@link EbsType }
     *     
     */
    public EbsType getEbs() {
        return ebs;
    }

    /**
     * Sets the value of the ebs property.
     * 
     * @param value
     *     allowed object is
     *     {@link EbsType }
     *     
     */
    public void setEbs(EbsType value) {
        this.ebs = value;
    }

}

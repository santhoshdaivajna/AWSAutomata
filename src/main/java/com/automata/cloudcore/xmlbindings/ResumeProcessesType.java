//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.13 at 03:54:52 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResumeProcessesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResumeProcessesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AutoScalingGroupName" type="{}ResourceName"/>
 *         &lt;element name="ScalingProcesses" type="{}ProcessNames" minOccurs="0"/>
 *         &lt;element name="Region" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResumeProcessesType", propOrder = {
    "autoScalingGroupName",
    "scalingProcesses",
    "region"
})
public class ResumeProcessesType {

    @XmlElement(name = "AutoScalingGroupName", required = true)
    protected String autoScalingGroupName;
    @XmlElement(name = "ScalingProcesses")
    protected ProcessNames scalingProcesses;
    @XmlElement(name = "Region", required = true)
    protected String region;

    /**
     * Gets the value of the autoScalingGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoScalingGroupName() {
        return autoScalingGroupName;
    }

    /**
     * Sets the value of the autoScalingGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoScalingGroupName(String value) {
        this.autoScalingGroupName = value;
    }

    /**
     * Gets the value of the scalingProcesses property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessNames }
     *     
     */
    public ProcessNames getScalingProcesses() {
        return scalingProcesses;
    }

    /**
     * Sets the value of the scalingProcesses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessNames }
     *     
     */
    public void setScalingProcesses(ProcessNames value) {
        this.scalingProcesses = value;
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

}

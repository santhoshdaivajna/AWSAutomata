//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.11 at 03:46:42 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DescribeInstancesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DescribeInstancesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instancesSet" type="{}DescribeInstancesInfoType"/>
 *         &lt;element name="filterSet" type="{}FilterSetType" minOccurs="0"/>
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
@XmlType(name = "DescribeInstancesType", propOrder = {
    "instancesSet",
    "filterSet",
    "region"
})
public class DescribeInstancesType {

    @XmlElement(required = true)
    protected DescribeInstancesInfoType instancesSet;
    protected FilterSetType filterSet;
    @XmlElement(name = "Region", required = true)
    protected String region;

    /**
     * Gets the value of the instancesSet property.
     * 
     * @return
     *     possible object is
     *     {@link DescribeInstancesInfoType }
     *     
     */
    public DescribeInstancesInfoType getInstancesSet() {
        return instancesSet;
    }

    /**
     * Sets the value of the instancesSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescribeInstancesInfoType }
     *     
     */
    public void setInstancesSet(DescribeInstancesInfoType value) {
        this.instancesSet = value;
    }

    /**
     * Gets the value of the filterSet property.
     * 
     * @return
     *     possible object is
     *     {@link FilterSetType }
     *     
     */
    public FilterSetType getFilterSet() {
        return filterSet;
    }

    /**
     * Sets the value of the filterSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterSetType }
     *     
     */
    public void setFilterSet(FilterSetType value) {
        this.filterSet = value;
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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.27 at 01:43:51 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for LoadBalancerDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoadBalancerDescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoadBalancerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DNSName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ListenerDescriptions" type="{}ListenerDescriptionsType" minOccurs="0"/>
 *         &lt;element name="Policies" type="{}PoliciesType" minOccurs="0"/>
 *         &lt;element name="AvailabilityZones" type="{}AvailabilityZones" minOccurs="0"/>
 *         &lt;element name="InstancesType" type="{}InstancesType" minOccurs="0"/>
 *         &lt;element name="HealthCheckType" type="{}HealthCheckType" minOccurs="0"/>
 *         &lt;element name="CreatedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadBalancerDescriptionType", propOrder = {
    "loadBalancerName",
    "dnsName",
    "listenerDescriptions",
    "policies",
    "availabilityZones",
    "instancesType",
    "healthCheckType",
    "createdTime"
})
public class LoadBalancerDescriptionType {

    @XmlElement(name = "LoadBalancerName")
    protected String loadBalancerName;
    @XmlElement(name = "DNSName")
    protected String dnsName;
    @XmlElement(name = "ListenerDescriptions")
    protected ListenerDescriptionsType listenerDescriptions;
    @XmlElement(name = "Policies")
    protected PoliciesType policies;
    @XmlElement(name = "AvailabilityZones")
    protected AvailabilityZonesType availabilityZones;
    @XmlElement(name = "InstancesType")
    protected InstancesType instancesType;
    @XmlElement(name = "HealthCheckType")
    protected HealthCheckType healthCheckType;
    @XmlElement(name = "CreatedTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdTime;

    /**
     * Gets the value of the loadBalancerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoadBalancerName() {
        return loadBalancerName;
    }

    /**
     * Sets the value of the loadBalancerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoadBalancerName(String value) {
        this.loadBalancerName = value;
    }

    /**
     * Gets the value of the dnsName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDNSName() {
        return dnsName;
    }

    /**
     * Sets the value of the dnsName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDNSName(String value) {
        this.dnsName = value;
    }

    /**
     * Gets the value of the listenerDescriptions property.
     * 
     * @return
     *     possible object is
     *     {@link ListenerDescriptionsType }
     *     
     */
    public ListenerDescriptionsType getListenerDescriptions() {
        return listenerDescriptions;
    }

    /**
     * Sets the value of the listenerDescriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListenerDescriptionsType }
     *     
     */
    public void setListenerDescriptions(ListenerDescriptionsType value) {
        this.listenerDescriptions = value;
    }

    /**
     * Gets the value of the policies property.
     * 
     * @return
     *     possible object is
     *     {@link PoliciesType }
     *     
     */
    public PoliciesType getPolicies() {
        return policies;
    }

    /**
     * Sets the value of the policies property.
     * 
     * @param value
     *     allowed object is
     *     {@link PoliciesType }
     *     
     */
    public void setPolicies(PoliciesType value) {
        this.policies = value;
    }

    /**
     * Gets the value of the availabilityZones property.
     * 
     * @return
     *     possible object is
     *     {@link AvailabilityZones }
     *     
     */
    public AvailabilityZonesType getAvailabilityZones() {
        return availabilityZones;
    }

    /**
     * Sets the value of the availabilityZones property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailabilityZones }
     *     
     */
    public void setAvailabilityZones(AvailabilityZonesType value) {
        this.availabilityZones = value;
    }

    /**
     * Gets the value of the instancesType property.
     * 
     * @return
     *     possible object is
     *     {@link InstancesType }
     *     
     */
    public InstancesType getInstancesType() {
        return instancesType;
    }

    /**
     * Sets the value of the instancesType property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstancesType }
     *     
     */
    public void setInstancesType(InstancesType value) {
        this.instancesType = value;
    }

    /**
     * Gets the value of the healthCheckType property.
     * 
     * @return
     *     possible object is
     *     {@link HealthCheckType }
     *     
     */
    public HealthCheckType getHealthCheckType() {
        return healthCheckType;
    }

    /**
     * Sets the value of the healthCheckType property.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthCheckType }
     *     
     */
    public void setHealthCheckType(HealthCheckType value) {
        this.healthCheckType = value;
    }

    /**
     * Gets the value of the createdTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedTime() {
        return createdTime;
    }

    /**
     * Sets the value of the createdTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedTime(XMLGregorianCalendar value) {
        this.createdTime = value;
    }

}

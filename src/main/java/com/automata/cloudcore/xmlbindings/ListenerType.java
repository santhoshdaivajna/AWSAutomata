//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.30 at 07:01:24 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListenerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListenerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Protocol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LoadBalancerPort" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="InstancePort" type="{}InstancePortType"/>
 *         &lt;element name="SSLCertificateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListenerType", propOrder = {
    "protocol",
    "loadBalancerPort",
    "instancePort",
    "sslCertificateId"
})
public class ListenerType {

    @XmlElement(name = "Protocol", required = true)
    protected String protocol;
    @XmlElement(name = "LoadBalancerPort", required = true)
    protected Integer loadBalancerPort;
    @XmlElement(name = "InstancePort", required = true)
    protected Integer instancePort;
    @XmlElement(name = "SSLCertificateId")
    protected String sslCertificateId;

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
     * Gets the value of the loadBalancerPort property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     * 
     */
    public Integer getLoadBalancerPort() {
        return loadBalancerPort;
    }

    /**
     * Sets the value of the loadBalancerPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     * 
     */
    public void setLoadBalancerPort(Integer value) {
        this.loadBalancerPort = value;
    }

    /**
     * Gets the value of the instancePort property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInstancePort() {
        return instancePort;
    }

    /**
     * Sets the value of the instancePort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInstancePort(Integer value) {
        this.instancePort = value;
    }

    /**
     * Gets the value of the sslCertificateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSLCertificateId() {
        return sslCertificateId;
    }

    /**
     * Sets the value of the sslCertificateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSLCertificateId(String value) {
        this.sslCertificateId = value;
    }

}

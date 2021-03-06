//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.08.09 at 07:45:32 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateKeyPairResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateKeyPairResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Request" type="{}CreateKeyPairType"/>
 *         &lt;element name="KeyFingerprint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="KeyMaterial" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "CreateKeyPairResponse", propOrder = {
    "request",
    "keyFingerprint",
    "keyMaterial",
    "status"
})
public class CreateKeyPairResponse {

    @XmlElement(name = "Request", required = true)
    protected CreateKeyPairType request;
    @XmlElement(name = "KeyFingerprint", required = true)
    protected String keyFingerprint;
    @XmlElement(name = "KeyMaterial", required = true)
    protected String keyMaterial;
    @XmlElement(name = "Status", required = true)
    protected String status;

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link CreateKeyPairType }
     *     
     */
    public CreateKeyPairType getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateKeyPairType }
     *     
     */
    public void setRequest(CreateKeyPairType value) {
        this.request = value;
    }

    /**
     * Gets the value of the keyFingerprint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyFingerprint() {
        return keyFingerprint;
    }

    /**
     * Sets the value of the keyFingerprint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyFingerprint(String value) {
        this.keyFingerprint = value;
    }

    /**
     * Gets the value of the keyMaterial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyMaterial() {
        return keyMaterial;
    }

    /**
     * Sets the value of the keyMaterial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyMaterial(String value) {
        this.keyMaterial = value;
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

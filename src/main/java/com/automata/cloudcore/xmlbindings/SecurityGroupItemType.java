//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.21 at 05:35:52 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecurityGroupItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecurityGroupItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ownerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="groupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="groupDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vpcId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipPermissions" type="{}IpPermissionSetType"/>
 *         &lt;element name="ipPermissionsEgress" type="{}IpPermissionSetType" minOccurs="0"/>
 *         &lt;element name="tagSet" type="{}ResourceTagSetType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityGroupItemType", propOrder = {
    "ownerId",
    "groupId",
    "groupName",
    "groupDescription",
    "vpcId",
    "ipPermissions",
    "ipPermissionsEgress",
    "tagSet"
})
public class SecurityGroupItemType {

    @XmlElement(required = true)
    protected String ownerId;
    @XmlElement(required = true)
    protected String groupId;
    @XmlElement(required = true)
    protected String groupName;
    @XmlElement(required = true)
    protected String groupDescription;
    protected String vpcId;
    @XmlElement(required = true)
    protected IpPermissionSetType ipPermissions;
    protected IpPermissionSetType ipPermissionsEgress;
    protected ResourceTagSetType tagSet;

    /**
     * Gets the value of the ownerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the value of the ownerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerId(String value) {
        this.ownerId = value;
    }

    /**
     * Gets the value of the groupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupId(String value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * Gets the value of the groupDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupDescription() {
        return groupDescription;
    }

    /**
     * Sets the value of the groupDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupDescription(String value) {
        this.groupDescription = value;
    }

    /**
     * Gets the value of the vpcId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVpcId() {
        return vpcId;
    }

    /**
     * Sets the value of the vpcId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVpcId(String value) {
        this.vpcId = value;
    }

    /**
     * Gets the value of the ipPermissions property.
     * 
     * @return
     *     possible object is
     *     {@link IpPermissionSetType }
     *     
     */
    public IpPermissionSetType getIpPermissions() {
        return ipPermissions;
    }

    /**
     * Sets the value of the ipPermissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link IpPermissionSetType }
     *     
     */
    public void setIpPermissions(IpPermissionSetType value) {
        this.ipPermissions = value;
    }

    /**
     * Gets the value of the ipPermissionsEgress property.
     * 
     * @return
     *     possible object is
     *     {@link IpPermissionSetType }
     *     
     */
    public IpPermissionSetType getIpPermissionsEgress() {
        return ipPermissionsEgress;
    }

    /**
     * Sets the value of the ipPermissionsEgress property.
     * 
     * @param value
     *     allowed object is
     *     {@link IpPermissionSetType }
     *     
     */
    public void setIpPermissionsEgress(IpPermissionSetType value) {
        this.ipPermissionsEgress = value;
    }

    /**
     * Gets the value of the tagSet property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceTagSetType }
     *     
     */
    public ResourceTagSetType getTagSet() {
        return tagSet;
    }

    /**
     * Sets the value of the tagSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceTagSetType }
     *     
     */
    public void setTagSet(ResourceTagSetType value) {
        this.tagSet = value;
    }

}

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

import com.automata.cloudcore.util.TransformObject;


/**
 * <p>Java class for DBSecurityGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DBSecurityGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OwnerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DBSecurityGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DBSecurityGroupDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EC2SecurityGroups" type="{}EC2SecurityGroupList" minOccurs="0"/>
 *         &lt;element name="IPRanges" type="{}IPRangeList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBSecurityGroup", propOrder = {
    "ownerId",
    "dbSecurityGroupName",
    "dbSecurityGroupDescription",
    "ec2SecurityGroups",
    "ipRanges"
})
public class DBSecurityGroup {

    @XmlElement(name = "OwnerId")
    protected String ownerId;
    @XmlElement(name = "DBSecurityGroupName")
    protected String dbSecurityGroupName;
    @XmlElement(name = "DBSecurityGroupDescription")
    protected String dbSecurityGroupDescription;
    @XmlElement(name = "EC2SecurityGroups")
    protected EC2SecurityGroupList ec2SecurityGroups;
    @XmlElement(name = "IPRanges")
    protected IPRangeList ipRanges;

    public DBSecurityGroup(){}
    
    public DBSecurityGroup( com.amazonaws.services.rds.model.DBSecurityGroup dbSecGrp) {
    	
    	this.ownerId = dbSecGrp.getOwnerId();
    	this.dbSecurityGroupName = dbSecGrp.getDBSecurityGroupName();
    	this.dbSecurityGroupDescription = dbSecGrp.getDBSecurityGroupDescription();
    	this.ec2SecurityGroups = TransformObject.getEC2SecurityGroupList(dbSecGrp.getEC2SecurityGroups());
    	this.ipRanges = TransformObject.getIPRangeList(dbSecGrp.getIPRanges());
	}

	

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
     * Gets the value of the dbSecurityGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDBSecurityGroupName() {
        return dbSecurityGroupName;
    }

    /**
     * Sets the value of the dbSecurityGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDBSecurityGroupName(String value) {
        this.dbSecurityGroupName = value;
    }

    /**
     * Gets the value of the dbSecurityGroupDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDBSecurityGroupDescription() {
        return dbSecurityGroupDescription;
    }

    /**
     * Sets the value of the dbSecurityGroupDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDBSecurityGroupDescription(String value) {
        this.dbSecurityGroupDescription = value;
    }

    /**
     * Gets the value of the ec2SecurityGroups property.
     * 
     * @return
     *     possible object is
     *     {@link EC2SecurityGroupList }
     *     
     */
    public EC2SecurityGroupList getEC2SecurityGroups() {
        return ec2SecurityGroups;
    }

    /**
     * Sets the value of the ec2SecurityGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link EC2SecurityGroupList }
     *     
     */
    public void setEC2SecurityGroups(EC2SecurityGroupList value) {
        this.ec2SecurityGroups = value;
    }

    /**
     * Gets the value of the ipRanges property.
     * 
     * @return
     *     possible object is
     *     {@link IPRangeList }
     *     
     */
    public IPRangeList getIPRanges() {
        return ipRanges;
    }

    /**
     * Sets the value of the ipRanges property.
     * 
     * @param value
     *     allowed object is
     *     {@link IPRangeList }
     *     
     */
    public void setIPRanges(IPRangeList value) {
        this.ipRanges = value;
    }

}

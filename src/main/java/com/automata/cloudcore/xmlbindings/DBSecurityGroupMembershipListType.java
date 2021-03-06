//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.05 at 03:50:31 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DBSecurityGroupMembershipListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DBSecurityGroupMembershipListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DBSecurityGroup" type="{}DBSecurityGroupMembershipType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBSecurityGroupMembershipListType", propOrder = {
    "dbSecurityGroupMemberships"
})
public class DBSecurityGroupMembershipListType {

    @XmlElement(name = "DBSecurityGroup", required = true)
    protected List<DBSecurityGroupMembershipType> dbSecurityGroupMemberships;

    /**
     * Gets the value of the dbSecurityGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dbSecurityGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDBSecurityGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DBSecurityGroupMembershipType }
     * 
     * 
     */

	public List<DBSecurityGroupMembershipType> getDbSecurityGroup() {
		return dbSecurityGroupMemberships;
	}

	public void setDbSecurityGroup(
			List<DBSecurityGroupMembershipType> dbSecurityGroup) {
		this.dbSecurityGroupMemberships = dbSecurityGroup;
	}

    
}

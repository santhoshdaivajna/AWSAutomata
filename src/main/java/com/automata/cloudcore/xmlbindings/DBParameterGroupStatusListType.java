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
 * <p>Java class for DBParameterGroupStatusListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DBParameterGroupStatusListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DBParameterGroup" type="{}DBParameterGroupStatusType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBParameterGroupStatusListType", propOrder = {
    "dbParameterGroup"
})
public class DBParameterGroupStatusListType {

    @XmlElement(name = "DBParameterGroup", required = true)
    protected List<DBParameterGroupStatusType> dbParameterGroup;

    /**
     * Gets the value of the dbParameterGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dbParameterGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDBParameterGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DBParameterGroupStatusType }
     * 
     * 
     */

	public List<DBParameterGroupStatusType> getDbParameterGroup() {
		return dbParameterGroup;
	}

	public void setDbParameterGroup(
			List<DBParameterGroupStatusType> dbParameterGroup) {
		this.dbParameterGroup = dbParameterGroup;
	}
    
    

}

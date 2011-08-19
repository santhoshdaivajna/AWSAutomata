//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.05 at 05:43:26 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeleteDBInstanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeleteDBInstanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DBInstanceIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SkipFinalSnapshot" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="FinalDBSnapshotIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DeleteDBInstanceType", propOrder = {
    "dbInstanceIdentifier",
    "skipFinalSnapshot",
    "finalDBSnapshotIdentifier",
    "region"
})
public class DeleteDBInstanceType {

    @XmlElement(name = "DBInstanceIdentifier", required = true)
    protected String dbInstanceIdentifier;
    @XmlElement(name = "SkipFinalSnapshot")
    protected Boolean skipFinalSnapshot;
    @XmlElement(name = "FinalDBSnapshotIdentifier")
    protected String finalDBSnapshotIdentifier;
    @XmlElement(name = "Region", required = true)
    protected String region;

    /**
     * Gets the value of the dbInstanceIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDBInstanceIdentifier() {
        return dbInstanceIdentifier;
    }

    /**
     * Sets the value of the dbInstanceIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDBInstanceIdentifier(String value) {
        this.dbInstanceIdentifier = value;
    }

    /**
     * Gets the value of the skipFinalSnapshot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkipFinalSnapshot() {
        return skipFinalSnapshot;
    }

    /**
     * Sets the value of the skipFinalSnapshot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkipFinalSnapshot(Boolean value) {
        this.skipFinalSnapshot = value;
    }

    /**
     * Gets the value of the finalDBSnapshotIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalDBSnapshotIdentifier() {
        return finalDBSnapshotIdentifier;
    }

    /**
     * Sets the value of the finalDBSnapshotIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalDBSnapshotIdentifier(String value) {
        this.finalDBSnapshotIdentifier = value;
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

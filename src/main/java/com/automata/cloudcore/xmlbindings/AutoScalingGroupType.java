//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.08.06 at 02:19:19 PM IST 
//


package com.automata.cloudcore.xmlbindings;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.amazonaws.services.autoscaling.model.AutoScalingGroup;
import com.automata.cloudcore.util.TransformObject;


/**
 * <p>Java class for AutoScalingGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AutoScalingGroupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AutoScalingGroupName" type="{}XmlStringMaxLen255"/>
 *         &lt;element name="AutoScalingGroupARN" type="{}ResourceName" minOccurs="0"/>
 *         &lt;element name="LaunchConfigurationName" type="{}XmlStringMaxLen255"/>
 *         &lt;element name="MinSize" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="MaxSize" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="DesiredCapacity" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="DefaultCooldown" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="AvailabilityZones" type="{}AvailabilityZonesType"/>
 *         &lt;element name="LoadBalancerNames" type="{}LoadBalancerNamesType" minOccurs="0"/>
 *         &lt;element name="HealthCheckType" type="{}XmlStringMaxLen32"/>
 *         &lt;element name="HealthCheckGracePeriod" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="Instances" type="{}InstancesType" minOccurs="0"/>
 *         &lt;element name="CreatedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SuspendedProcesses" type="{}SuspendedProcessesType" minOccurs="0"/>
 *         &lt;element name="PlacementGroup" type="{}XmlStringMaxLen255" minOccurs="0"/>
 *         &lt;element name="VPCZoneIdentifier" type="{}XmlStringMaxLen255" minOccurs="0"/>
 *         &lt;element name="EnabledMetrics" type="{}EnabledMetricsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutoScalingGroupType", propOrder = {
    "autoScalingGroupName",
    "autoScalingGroupARN",
    "launchConfigurationName",
    "minSize",
    "maxSize",
    "desiredCapacity",
    "defaultCooldown",
    "availabilityZones",
    "loadBalancerNames",
    "healthCheckType",
    "healthCheckGracePeriod",
    "instances",
    "createdTime",
    "suspendedProcesses",
    "placementGroup",
    "vpcZoneIdentifier",
    "enabledMetrics"
})
public class AutoScalingGroupType {

    @XmlElement(name = "AutoScalingGroupName", required = true)
    protected String autoScalingGroupName;
    @XmlElement(name = "AutoScalingGroupARN")
    protected String autoScalingGroupARN;
    @XmlElement(name = "LaunchConfigurationName", required = true)
    protected String launchConfigurationName;
    @XmlElement(name = "MinSize", required = true)
    protected Integer minSize;
    @XmlElement(name = "MaxSize", required = true)
    protected Integer maxSize;
    @XmlElement(name = "DesiredCapacity", required = true)
    protected Integer desiredCapacity;
    @XmlElement(name = "DefaultCooldown", required = true)
    protected Integer defaultCooldown;
    @XmlElement(name = "AvailabilityZones", required = true)
    protected AvailabilityZonesType availabilityZones;
    @XmlElement(name = "LoadBalancerNames")
    protected LoadBalancerNamesType loadBalancerNames;
    @XmlElement(name = "HealthCheckType", required = true)
    protected String healthCheckType;
    @XmlElement(name = "HealthCheckGracePeriod")
    protected Integer healthCheckGracePeriod;
    @XmlElement(name = "Instances")
    protected InstancesType instances;
    @XmlElement(name = "CreatedTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date createdTime;
    @XmlElement(name = "SuspendedProcesses")
    protected SuspendedProcessesType suspendedProcesses;
    @XmlElement(name = "PlacementGroup")
    protected String placementGroup;
    @XmlElement(name = "VPCZoneIdentifier")
    protected String vpcZoneIdentifier;
    @XmlElement(name = "EnabledMetrics")
    protected EnabledMetricsType enabledMetrics;

    public AutoScalingGroupType() {
		
	}
    
	public AutoScalingGroupType(AutoScalingGroup autoScalingGrp) {

		this.autoScalingGroupName = autoScalingGrp.getAutoScalingGroupName();
		this.autoScalingGroupARN = autoScalingGrp.getAutoScalingGroupARN();
		this.launchConfigurationName = autoScalingGrp
				.getLaunchConfigurationName();
		this.minSize = autoScalingGrp.getMinSize();
		this.maxSize = autoScalingGrp.getMaxSize();
		this.desiredCapacity = autoScalingGrp.getDesiredCapacity();
		this.defaultCooldown = autoScalingGrp.getDefaultCooldown();

		AvailabilityZonesType az = new AvailabilityZonesType();
		az.setMember(autoScalingGrp.getAvailabilityZones());
		this.availabilityZones = az;

		LoadBalancerNamesType lbNames = new LoadBalancerNamesType();
		lbNames.setMember(autoScalingGrp.getLoadBalancerNames());
		this.loadBalancerNames = lbNames;

		this.healthCheckType = autoScalingGrp.getHealthCheckType();
		this.healthCheckGracePeriod = autoScalingGrp
				.getHealthCheckGracePeriod();
		this.instances = TransformObject.getASInstancesType(autoScalingGrp
				.getInstances());
		this.createdTime = autoScalingGrp.getCreatedTime();
		this.suspendedProcesses = TransformObject
				.getSuspendedProcessesType(autoScalingGrp
						.getSuspendedProcesses());
		this.placementGroup = autoScalingGrp.getPlacementGroup();
		this.vpcZoneIdentifier = autoScalingGrp.getVPCZoneIdentifier();
		this.enabledMetrics = TransformObject
				.getEnabledMetricsType(autoScalingGrp.getEnabledMetrics());
	}

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
     * Gets the value of the autoScalingGroupARN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoScalingGroupARN() {
        return autoScalingGroupARN;
    }

    /**
     * Sets the value of the autoScalingGroupARN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoScalingGroupARN(String value) {
        this.autoScalingGroupARN = value;
    }

    /**
     * Gets the value of the launchConfigurationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaunchConfigurationName() {
        return launchConfigurationName;
    }

    /**
     * Sets the value of the launchConfigurationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaunchConfigurationName(String value) {
        this.launchConfigurationName = value;
    }

    /**
     * Gets the value of the minSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinSize() {
        return minSize;
    }

    /**
     * Sets the value of the minSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinSize(Integer value) {
        this.minSize = value;
    }

    /**
     * Gets the value of the maxSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxSize() {
        return maxSize;
    }

    /**
     * Sets the value of the maxSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxSize(Integer value) {
        this.maxSize = value;
    }

    /**
     * Gets the value of the desiredCapacity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDesiredCapacity() {
        return desiredCapacity;
    }

    /**
     * Sets the value of the desiredCapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDesiredCapacity(Integer value) {
        this.desiredCapacity = value;
    }

    /**
     * Gets the value of the defaultCooldown property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultCooldown() {
        return defaultCooldown;
    }

    /**
     * Sets the value of the defaultCooldown property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultCooldown(Integer value) {
        this.defaultCooldown = value;
    }

    /**
     * Gets the value of the availabilityZones property.
     * 
     * @return
     *     possible object is
     *     {@link AvailabilityZonesType }
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
     *     {@link AvailabilityZonesType }
     *     
     */
    public void setAvailabilityZones(AvailabilityZonesType value) {
        this.availabilityZones = value;
    }

    /**
     * Gets the value of the loadBalancerNames property.
     * 
     * @return
     *     possible object is
     *     {@link LoadBalancerNamesType }
     *     
     */
    public LoadBalancerNamesType getLoadBalancerNames() {
        return loadBalancerNames;
    }

    /**
     * Sets the value of the loadBalancerNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadBalancerNamesType }
     *     
     */
    public void setLoadBalancerNames(LoadBalancerNamesType value) {
        this.loadBalancerNames = value;
    }

    /**
     * Gets the value of the healthCheckType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHealthCheckType() {
        return healthCheckType;
    }

    /**
     * Sets the value of the healthCheckType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHealthCheckType(String value) {
        this.healthCheckType = value;
    }

    /**
     * Gets the value of the healthCheckGracePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHealthCheckGracePeriod() {
        return healthCheckGracePeriod;
    }

    /**
     * Sets the value of the healthCheckGracePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHealthCheckGracePeriod(Integer value) {
        this.healthCheckGracePeriod = value;
    }

    /**
     * Gets the value of the instances property.
     * 
     * @return
     *     possible object is
     *     {@link InstancesType }
     *     
     */
    public InstancesType getInstances() {
        return instances;
    }

    /**
     * Sets the value of the instances property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstancesType }
     *     
     */
    public void setInstances(InstancesType value) {
        this.instances = value;
    }

    /**
     * Gets the value of the createdTime property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * Sets the value of the createdTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setCreatedTime(Date value) {
        this.createdTime = value;
    }

    /**
     * Gets the value of the suspendedProcesses property.
     * 
     * @return
     *     possible object is
     *     {@link SuspendedProcessesType }
     *     
     */
    public SuspendedProcessesType getSuspendedProcesses() {
        return suspendedProcesses;
    }

    /**
     * Sets the value of the suspendedProcesses property.
     * 
     * @param value
     *     allowed object is
     *     {@link SuspendedProcessesType }
     *     
     */
    public void setSuspendedProcesses(SuspendedProcessesType value) {
        this.suspendedProcesses = value;
    }

    /**
     * Gets the value of the placementGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlacementGroup() {
        return placementGroup;
    }

    /**
     * Sets the value of the placementGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlacementGroup(String value) {
        this.placementGroup = value;
    }

    /**
     * Gets the value of the vpcZoneIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVPCZoneIdentifier() {
        return vpcZoneIdentifier;
    }

    /**
     * Sets the value of the vpcZoneIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVPCZoneIdentifier(String value) {
        this.vpcZoneIdentifier = value;
    }

    /**
     * Gets the value of the enabledMetrics property.
     * 
     * @return
     *     possible object is
     *     {@link EnabledMetricsType }
     *     
     */
    public EnabledMetricsType getEnabledMetrics() {
        return enabledMetrics;
    }

    /**
     * Sets the value of the enabledMetrics property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnabledMetricsType }
     *     
     */
    public void setEnabledMetrics(EnabledMetricsType value) {
        this.enabledMetrics = value;
    }

}

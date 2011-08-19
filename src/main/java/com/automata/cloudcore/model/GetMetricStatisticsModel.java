package com.automata.cloudcore.model;

import com.amazonaws.services.cloudwatch.model.Dimension;

// TODO: Auto-generated Javadoc
/**
 * The Class GetMetricStatisticsModel.
 */
public class GetMetricStatisticsModel {
	
    /** The namespace. */
    private String namespace;
    
    /** The metric name. */
    private String metricName;
    
    /** The dimensions. */
    private java.util.List<Dimension> dimensions;
    
    /** The start time. */
    private java.util.Date startTime;
    
    /** The end time. */
    private java.util.Date endTime;
    
    /** The period. */
    private Integer period;
    
    /** The statistics. */
    private java.util.List<String> statistics;
    
    /** The unit. */
    private String unit;
    
    /** The region. */
    private String region;
    
	/**
	 * Gets the namespace.
	 *
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}
	
	/**
	 * Sets the namespace.
	 *
	 * @param namespace the new namespace
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	/**
	 * Gets the metric name.
	 *
	 * @return the metric name
	 */
	public String getMetricName() {
		return metricName;
	}
	
	/**
	 * Sets the metric name.
	 *
	 * @param metricName the new metric name
	 */
	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}
	
	/**
	 * Gets the dimensions.
	 *
	 * @return the dimensions
	 */
	public java.util.List<Dimension> getDimensions() {
		return dimensions;
	}
	
	/**
	 * Sets the dimensions.
	 *
	 * @param dimensions the new dimensions
	 */
	public void setDimensions(java.util.List<Dimension> dimensions) {
		this.dimensions = dimensions;
	}
	
	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public java.util.Date getStartTime() {
		return startTime;
	}
	
	/**
	 * Sets the start time.
	 *
	 * @param startTime the new start time
	 */
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public java.util.Date getEndTime() {
		return endTime;
	}
	
	/**
	 * Sets the end time.
	 *
	 * @param endTime the new end time
	 */
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Gets the period.
	 *
	 * @return the period
	 */
	public Integer getPeriod() {
		return period;
	}
	
	/**
	 * Sets the period.
	 *
	 * @param period the new period
	 */
	public void setPeriod(Integer period) {
		this.period = period;
	}
	
	/**
	 * Gets the statistics.
	 *
	 * @return the statistics
	 */
	public java.util.List<String> getStatistics() {
		return statistics;
	}
	
	/**
	 * Sets the statistics.
	 *
	 * @param statistics the new statistics
	 */
	public void setStatistics(java.util.List<String> statistics) {
		this.statistics = statistics;
	}
	
	/**
	 * Gets the unit.
	 *
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	
	/**
	 * Sets the unit.
	 *
	 * @param unit the new unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * Gets the region.
	 *
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	
	/**
	 * Sets the region.
	 *
	 * @param region the new region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("GetMetricStatisticsModel [dimensions=");
		stringBuilder.append(dimensions);
		stringBuilder.append(", endTime=");
		stringBuilder.append(endTime);
		stringBuilder.append(", metricName=");
		stringBuilder.append(metricName);
		stringBuilder.append(", namespace=");
		stringBuilder.append(namespace);
		stringBuilder.append(", period=");
		stringBuilder.append(period);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append(", startTime=");
		stringBuilder.append(startTime);
		stringBuilder.append(", statistics=");
		stringBuilder.append(statistics);
		stringBuilder.append(", unit=");
		stringBuilder.append(unit);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
 
}

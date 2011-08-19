package com.automata.cloudcore.model;

import java.util.List;

import com.amazonaws.services.elasticloadbalancing.model.Listener;

// TODO: Auto-generated Javadoc
/**
 * The Class ELBModel.
 */
public class ELBModel {
	
	/** The load balancer name. */
	private String loadBalancerName;
	
	/** The availability zones. */
	private List<String> availabilityZones;
	
	/** The listeners. */
	private List<Listener> listeners;
	
	/** The end point. */
	private String endPoint;
	
	public ELBModel() {}
	
	public ELBModel(List<String> availabilityZones, String loadbalancerName,
			String endPoint, List<Listener> listenerList) {
		
		this.availabilityZones = availabilityZones;
		this.loadBalancerName = loadbalancerName;
		this.endPoint = endPoint;
		this.listeners = listenerList;
	}

	/**
	 * Gets the load balancer name.
	 *
	 * @return the load balancer name
	 */
	public String getLoadBalancerName() {
		return loadBalancerName;
	}
	
	/**
	 * Sets the load balancer name.
	 *
	 * @param loadBalancerName the new load balancer name
	 */
	public void setLoadBalancerName(String loadBalancerName) {
		this.loadBalancerName = loadBalancerName;
	}
	
	/**
	 * Gets the availability zones.
	 *
	 * @return the availability zones
	 */
	public List<String> getAvailabilityZones() {
		return availabilityZones;
	}
	
	/**
	 * Sets the availability zones.
	 *
	 * @param availabilityZones the new availability zones
	 */
	public void setAvailabilityZones(List<String> availabilityZones) {
		this.availabilityZones = availabilityZones;
	}
	
	/**
	 * Gets the listeners.
	 *
	 * @return the listeners
	 */
	public List<Listener> getListeners() {
		return listeners;
	}
	
	/**
	 * Sets the listeners.
	 *
	 * @param listeners the new listeners
	 */
	public void setListeners(List<Listener> listeners) {
		this.listeners = listeners;
	}
	
	/**
	 * Gets the end point.
	 *
	 * @return the end point
	 */
	public String getEndPoint() {
		return endPoint;
	}
	
	/**
	 * Sets the end point.
	 *
	 * @param endPoint the new end point
	 */
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ELBModel [loadBalancerName="
				+ loadBalancerName + ", availabilityZones=" + availabilityZones
				+ ", listeners=" + listeners + ", endPoint=" + endPoint + "]";
	}
	
	

}

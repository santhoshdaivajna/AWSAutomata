package com.automata.cloudcore.model;

import java.util.List;

import com.automata.cloudcore.xmlbindings.SuspendProcessesType;

// TODO: Auto-generated Javadoc
/**
 * The Class SuspendProcessesModel.
 */
public class SuspendProcessesModel {

	/** The auto scaling group name. */
	private String autoScalingGroupName;
	
	/** The scaling processes. */
	private List<String> scalingProcesses;
	
	/** The region. */
	private String region;

	/**
	 * Instantiates a new suspend processes model.
	 */
	public SuspendProcessesModel() {
	}

	/**
	 * Instantiates a new suspend processes model.
	 *
	 * @param suspendProcess the suspend process
	 */
	public SuspendProcessesModel(SuspendProcessesType suspendProcess) {
		this.autoScalingGroupName = suspendProcess.getAutoScalingGroupName();
		this.scalingProcesses = suspendProcess.getScalingProcesses()
				.getMember();
		this.region = suspendProcess.getRegion();
	}

	/**
	 * Gets the auto scaling group name.
	 *
	 * @return the auto scaling group name
	 */
	public String getAutoScalingGroupName() {
		return autoScalingGroupName;
	}

	/**
	 * Sets the auto scaling group name.
	 *
	 * @param autoScalingGroupName the new auto scaling group name
	 */
	public void setAutoScalingGroupName(String autoScalingGroupName) {
		this.autoScalingGroupName = autoScalingGroupName;
	}

	/**
	 * Gets the scaling processes.
	 *
	 * @return the scaling processes
	 */
	public List<String> getScalingProcesses() {
		return scalingProcesses;
	}

	/**
	 * Sets the scaling processes.
	 *
	 * @param scalingProcesses the new scaling processes
	 */
	public void setScalingProcesses(List<String> scalingProcesses) {
		this.scalingProcesses = scalingProcesses;
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
		stringBuilder.append("SuspendProcessesModel [autoScalingGroupName=");
		stringBuilder.append(autoScalingGroupName);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append(", scalingProcesses=");
		stringBuilder.append(scalingProcesses);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}

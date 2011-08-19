package com.automata.cloudcore.model;

import java.util.ArrayList;
import java.util.List;

import com.automata.cloudcore.xmlbindings.InstanceIdType;
import com.automata.cloudcore.xmlbindings.TerminateInstancesType;

// TODO: Auto-generated Javadoc
/**
 * The Class TerminateInstancesModel.
 */
public class TerminateInstancesModel {

	/** The instance ids. */
	private List<String> instanceIds;
	
	/** The region. */
	private String region;

	/**
	 * Instantiates a new terminate instances model.
	 */
	public TerminateInstancesModel() {
	}

	/**
	 * Instantiates a new terminate instances model.
	 *
	 * @param StopInstancesType the stop instances type
	 */
	public TerminateInstancesModel(TerminateInstancesType StopInstancesType) {

		this.region = StopInstancesType.getRegion();
		List<String> instanceIds = new ArrayList<String>();
		List<InstanceIdType> instanceIdTypeList = StopInstancesType
				.getInstancesSet().getItem();
		for (InstanceIdType instanceIdType : instanceIdTypeList) {
			instanceIds.add(instanceIdType.getInstanceId());
		}
		this.instanceIds = instanceIds;
	}

	/**
	 * Gets the instance ids.
	 *
	 * @return the instance ids
	 */
	public List<String> getInstanceIds() {
		return instanceIds;
	}

	/**
	 * Sets the instance ids.
	 *
	 * @param instanceIds the new instance ids
	 */
	public void setInstanceIds(List<String> instanceIds) {
		this.instanceIds = instanceIds;
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
		stringBuilder.append("TerminateInstancesModel [instanceIds=");
		stringBuilder.append(instanceIds);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}

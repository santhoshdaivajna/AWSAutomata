package com.automata.cloudcore.model;

import java.util.ArrayList;
import java.util.List;

import com.automata.cloudcore.xmlbindings.InstanceIdType;
import com.automata.cloudcore.xmlbindings.StartInstancesType;

// TODO: Auto-generated Javadoc
/**
 * The Class StartInstancesModel.
 */
public class StartInstancesModel {

	/** The instance ids. */
	private List<String> instanceIds;
	
	/** The region. */
	private String region;

	/**
	 * Instantiates a new start instances model.
	 */
	public StartInstancesModel() {
	}

	/**
	 * Instantiates a new start instances model.
	 *
	 * @param startInstancesType the start instances type
	 */
	public StartInstancesModel(StartInstancesType startInstancesType) {

		this.region = startInstancesType.getRegion();
		List<String> instanceIds = new ArrayList<String>();
		List<InstanceIdType> instanceIdTypeList = startInstancesType
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
		stringBuilder.append("StartInstancesModel [instanceIds=");
		stringBuilder.append(instanceIds);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}

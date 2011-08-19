package com.automata.cloudcore.model;

import com.automata.cloudcore.xmlbindings.RestoreDBInstanceFromDBSnapshotType;

// TODO: Auto-generated Javadoc
/**
 * The Class RestoreDBInstanceFromDBSnapshotModel.
 */
public class RestoreDBInstanceFromDBSnapshotModel {

	/** The d b instance identifier. */
	private String dBInstanceIdentifier;
	
	/** The d b snapshot identifier. */
	private String dBSnapshotIdentifier;
	
	/** The d b instance class. */
	private String dBInstanceClass;
	
	/** The port. */
	private Integer port;
	
	/** The availability zone. */
	private String availabilityZone;
	
	/** The multi az. */
	private boolean multiAZ;
	
	/** The auto minor version upgrade. */
	private boolean autoMinorVersionUpgrade;
	
	/** The region. */
	private String region;

	/**
	 * Instantiates a new restore db instance from db snapshot model.
	 *
	 * @param rds the rds
	 */
	public RestoreDBInstanceFromDBSnapshotModel(
			RestoreDBInstanceFromDBSnapshotType rds) {
		
		this.dBInstanceIdentifier = rds.getDBInstanceIdentifier();
		this.dBSnapshotIdentifier = rds.getDBSnapshotIdentifier();
		this.dBInstanceClass = rds.getDBInstanceClass();
		this.port = rds.getPort();
		this.availabilityZone = rds.getAvailabilityZone();
		this.multiAZ = rds.isMultiAZ();
		this.autoMinorVersionUpgrade = rds.isAutoMinorVersionUpgrade();
		this.region = rds.getRegion();
		
	}

	/**
	 * Gets the d b instance identifier.
	 *
	 * @return the d b instance identifier
	 */
	public String getdBInstanceIdentifier() {
		return dBInstanceIdentifier;
	}

	/**
	 * Sets the d b instance identifier.
	 *
	 * @param dBInstanceIdentifier the new d b instance identifier
	 */
	public void setdBInstanceIdentifier(String dBInstanceIdentifier) {
		this.dBInstanceIdentifier = dBInstanceIdentifier;
	}

	/**
	 * Gets the d b snapshot identifier.
	 *
	 * @return the d b snapshot identifier
	 */
	public String getdBSnapshotIdentifier() {
		return dBSnapshotIdentifier;
	}

	/**
	 * Sets the d b snapshot identifier.
	 *
	 * @param dBSnapshotIdentifier the new d b snapshot identifier
	 */
	public void setdBSnapshotIdentifier(String dBSnapshotIdentifier) {
		this.dBSnapshotIdentifier = dBSnapshotIdentifier;
	}

	/**
	 * Gets the d b instance class.
	 *
	 * @return the d b instance class
	 */
	public String getdBInstanceClass() {
		return dBInstanceClass;
	}

	/**
	 * Sets the d b instance class.
	 *
	 * @param dBInstanceClass the new d b instance class
	 */
	public void setdBInstanceClass(String dBInstanceClass) {
		this.dBInstanceClass = dBInstanceClass;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * Gets the availability zone.
	 *
	 * @return the availability zone
	 */
	public String getAvailabilityZone() {
		return availabilityZone;
	}

	/**
	 * Sets the availability zone.
	 *
	 * @param availabilityZone the new availability zone
	 */
	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	/**
	 * Checks if is multi az.
	 *
	 * @return true, if is multi az
	 */
	public boolean isMultiAZ() {
		return multiAZ;
	}

	/**
	 * Sets the multi az.
	 *
	 * @param multiAZ the new multi az
	 */
	public void setMultiAZ(boolean multiAZ) {
		this.multiAZ = multiAZ;
	}

	/**
	 * Checks if is auto minor version upgrade.
	 *
	 * @return true, if is auto minor version upgrade
	 */
	public boolean isAutoMinorVersionUpgrade() {
		return autoMinorVersionUpgrade;
	}

	/**
	 * Sets the auto minor version upgrade.
	 *
	 * @param autoMinorVersionUpgrade the new auto minor version upgrade
	 */
	public void setAutoMinorVersionUpgrade(boolean autoMinorVersionUpgrade) {
		this.autoMinorVersionUpgrade = autoMinorVersionUpgrade;
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
		stringBuilder.append("RestoreDBInstanceFromDBSnapshotModel [autoMinorVersionUpgrade=");
		stringBuilder.append(autoMinorVersionUpgrade);
		stringBuilder.append(", availabilityZone=");
		stringBuilder.append(availabilityZone);
		stringBuilder.append(", dBInstanceClass=");
		stringBuilder.append(dBInstanceClass);
		stringBuilder.append(", dBInstanceIdentifier=");
		stringBuilder.append(dBInstanceIdentifier);
		stringBuilder.append(", dBSnapshotIdentifier=");
		stringBuilder.append(dBSnapshotIdentifier);
		stringBuilder.append(", multiAZ=");
		stringBuilder.append(multiAZ);
		stringBuilder.append(", port=");
		stringBuilder.append(port);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}

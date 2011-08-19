package com.automata.cloudcore.model;

import com.automata.cloudcore.xmlbindings.CreateDBInstanceReadReplicaType;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateDBInstanceReadReplicaModel.
 */
public class CreateDBInstanceReadReplicaModel {

	/** The db instance identifier. */
	private String dbInstanceIdentifier;
	
	/** The source db instance identifier. */
	private String sourceDBInstanceIdentifier;
	
	/** The d b instance class. */
	private String dBInstanceClass;
	
	/** The availability zone. */
	private String availabilityZone;
	
	/** The port. */
	private Integer port;
	
	/** The auto minor version upgrade. */
	private Boolean autoMinorVersionUpgrade;
	
	/** The region. */
	private String region;

	/**
	 * Instantiates a new creates the db instance read replica model.
	 */
	public CreateDBInstanceReadReplicaModel() {
	}

	/**
	 * Instantiates a new creates the db instance read replica model.
	 *
	 * @param dbInstanceIdentifier the db instance identifier
	 * @param sourceDBInstanceIdentifier the source db instance identifier
	 * @param dBInstanceClass the d b instance class
	 * @param availabilityZone the availability zone
	 * @param port the port
	 * @param autoMinorVersionUpgrade the auto minor version upgrade
	 * @param region the region
	 */
	public CreateDBInstanceReadReplicaModel(String dbInstanceIdentifier,
			String sourceDBInstanceIdentifier, String dBInstanceClass,
			String availabilityZone, Integer port,
			Boolean autoMinorVersionUpgrade, String region) {
		super();
		this.dbInstanceIdentifier = dbInstanceIdentifier;
		this.sourceDBInstanceIdentifier = sourceDBInstanceIdentifier;
		this.dBInstanceClass = dBInstanceClass;
		this.availabilityZone = availabilityZone;
		this.port = port;
		this.autoMinorVersionUpgrade = autoMinorVersionUpgrade;
		this.region = region;
	}

	/**
	 * Instantiates a new creates the db instance read replica model.
	 *
	 * @param createDBInstanceReadReplica the create db instance read replica
	 */
	public CreateDBInstanceReadReplicaModel(
			CreateDBInstanceReadReplicaType createDBInstanceReadReplica) {
		super();
		this.dbInstanceIdentifier = createDBInstanceReadReplica
				.getDBInstanceIdentifier();
		this.sourceDBInstanceIdentifier = createDBInstanceReadReplica
				.getSourceDBInstanceIdentifier();
		this.dBInstanceClass = createDBInstanceReadReplica.getDBInstanceClass();
		this.availabilityZone = createDBInstanceReadReplica
				.getAvailabilityZone();
		this.port = createDBInstanceReadReplica.getPort();
		this.autoMinorVersionUpgrade = createDBInstanceReadReplica
				.isAutoMinorVersionUpgrade();
		this.region = createDBInstanceReadReplica.getRegion();
	}

	/**
	 * Gets the db instance identifier.
	 *
	 * @return the db instance identifier
	 */
	public String getDbInstanceIdentifier() {
		return dbInstanceIdentifier;
	}

	/**
	 * Sets the db instance identifier.
	 *
	 * @param dbInstanceIdentifier the new db instance identifier
	 */
	public void setDbInstanceIdentifier(String dbInstanceIdentifier) {
		this.dbInstanceIdentifier = dbInstanceIdentifier;
	}

	/**
	 * Gets the source db instance identifier.
	 *
	 * @return the source db instance identifier
	 */
	public String getSourceDBInstanceIdentifier() {
		return sourceDBInstanceIdentifier;
	}

	/**
	 * Sets the source db instance identifier.
	 *
	 * @param sourceDBInstanceIdentifier the new source db instance identifier
	 */
	public void setSourceDBInstanceIdentifier(String sourceDBInstanceIdentifier) {
		this.sourceDBInstanceIdentifier = sourceDBInstanceIdentifier;
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
	 * Gets the auto minor version upgrade.
	 *
	 * @return the auto minor version upgrade
	 */
	public Boolean getAutoMinorVersionUpgrade() {
		return autoMinorVersionUpgrade;
	}

	/**
	 * Sets the auto minor version upgrade.
	 *
	 * @param autoMinorVersionUpgrade the new auto minor version upgrade
	 */
	public void setAutoMinorVersionUpgrade(Boolean autoMinorVersionUpgrade) {
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
		stringBuilder
				.append("CreateDBInstanceReadReplicaModel [autoMinorVersionUpgrade=");
		stringBuilder.append(autoMinorVersionUpgrade);
		stringBuilder.append(", availabilityZone=");
		stringBuilder.append(availabilityZone);
		stringBuilder.append(", dBInstanceClass=");
		stringBuilder.append(dBInstanceClass);
		stringBuilder.append(", dbInstanceIdentifier=");
		stringBuilder.append(dbInstanceIdentifier);
		stringBuilder.append(", port=");
		stringBuilder.append(port);
		stringBuilder.append(", region=");
		stringBuilder.append(region);
		stringBuilder.append(", sourceDBInstanceIdentifier=");
		stringBuilder.append(sourceDBInstanceIdentifier);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}

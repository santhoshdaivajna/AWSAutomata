package com.automata.cloudcore.model;

import java.util.List;

import com.automata.cloudcore.xmlbindings.CreateDBInstanceType;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateDBInstanceModel.
 */
public class CreateDBInstanceModel {

	/** The d b name. */
	private String dBName;
	
	/** The d b instance identifier. */
	private String dBInstanceIdentifier;
	
	/** The allocated storage. */
	private Integer allocatedStorage;
	
	/** The d b instance class. */
	private String dBInstanceClass;
	
	/** The engine. */
	private String engine;
	
	/** The master username. */
	private String masterUsername;
	
	/** The master user password. */
	private String masterUserPassword;
	
	/** The d b security groups. */
	private java.util.List<String> dBSecurityGroups;
	
	/** The availability zone. */
	private String availabilityZone;
	
	/** The preferred maintenance window. */
	private String preferredMaintenanceWindow;
	
	/** The d b parameter group name. */
	private String dBParameterGroupName;
	
	/** The backup retention period. */
	private Integer backupRetentionPeriod;
	
	/** The preferred backup window. */
	private String preferredBackupWindow;
	
	/** The port. */
	private Integer port;
	
	/** The multi az. */
	private Boolean multiAZ;
	
	/** The engine version. */
	private String engineVersion;
	
	/** The auto minor version upgrade. */
	private Boolean autoMinorVersionUpgrade;
	
	/** The region. */
	private String region;

	/**
	 * Instantiates a new creates the db instance model.
	 */
	public CreateDBInstanceModel() {
	}

	/**
	 * Instantiates a new creates the db instance model.
	 *
	 * @param dBInstanceIdentifier the d b instance identifier
	 * @param allocatedStorage the allocated storage
	 * @param dBInstanceClass the d b instance class
	 * @param engine the engine
	 * @param masterUsername the master username
	 * @param masterUserPassword the master user password
	 * @param region the region
	 */
	public CreateDBInstanceModel(String dBInstanceIdentifier,
			Integer allocatedStorage, String dBInstanceClass, String engine,
			String masterUsername, String masterUserPassword, String region) {
		this.dBInstanceIdentifier = dBInstanceIdentifier;
		this.allocatedStorage = allocatedStorage;
		this.dBInstanceClass = dBInstanceClass;
		this.engine = engine;
		this.masterUsername = masterUsername;
		this.masterUserPassword = masterUserPassword;
		this.region = region;

	}

	/**
	 * Instantiates a new creates the db instance model.
	 *
	 * @param dBName the d b name
	 * @param dBInstanceIdentifier the d b instance identifier
	 * @param allocatedStorage the allocated storage
	 * @param dBInstanceClass the d b instance class
	 * @param engine the engine
	 * @param masterUsername the master username
	 * @param masterUserPassword the master user password
	 * @param dBSecurityGroups the d b security groups
	 * @param availabilityZone the availability zone
	 * @param preferredMaintenanceWindow the preferred maintenance window
	 * @param dBParameterGroupName the d b parameter group name
	 * @param backupRetentionPeriod the backup retention period
	 * @param preferredBackupWindow the preferred backup window
	 * @param port the port
	 * @param multiAZ the multi az
	 * @param engineVersion the engine version
	 * @param autoMinorVersionUpgrade the auto minor version upgrade
	 * @param region the region
	 */
	public CreateDBInstanceModel(String dBName, String dBInstanceIdentifier,
			Integer allocatedStorage, String dBInstanceClass, String engine,
			String masterUsername, String masterUserPassword,
			List<String> dBSecurityGroups, String availabilityZone,
			String preferredMaintenanceWindow, String dBParameterGroupName,
			Integer backupRetentionPeriod, String preferredBackupWindow,
			Integer port, Boolean multiAZ, String engineVersion,
			Boolean autoMinorVersionUpgrade, String region) {
		super();
		this.dBName = dBName;
		this.dBInstanceIdentifier = dBInstanceIdentifier;
		this.allocatedStorage = allocatedStorage;
		this.dBInstanceClass = dBInstanceClass;
		this.engine = engine;
		this.masterUsername = masterUsername;
		this.masterUserPassword = masterUserPassword;
		this.dBSecurityGroups = dBSecurityGroups;
		this.availabilityZone = availabilityZone;
		this.preferredMaintenanceWindow = preferredMaintenanceWindow;
		this.dBParameterGroupName = dBParameterGroupName;
		this.backupRetentionPeriod = backupRetentionPeriod;
		this.preferredBackupWindow = preferredBackupWindow;
		this.port = port;
		this.multiAZ = multiAZ;
		this.engineVersion = engineVersion;
		this.autoMinorVersionUpgrade = autoMinorVersionUpgrade;
		this.region = region;
		
		
	}

	/**
	 * Instantiates a new creates the db instance model.
	 *
	 * @param launchRDSInstance the launch rds instance
	 */
	public CreateDBInstanceModel( CreateDBInstanceType launchRDSInstance ){
		this.dBName 					= launchRDSInstance.getDBName();
		this.dBInstanceIdentifier 		= launchRDSInstance.getDBInstanceIdentifier();
		this.allocatedStorage 			= Integer.parseInt(launchRDSInstance.getAllocatedStorage());
		this.dBInstanceClass 			= launchRDSInstance.getDBInstanceClass();
		this.engine 					= launchRDSInstance.getEngine();
		this.masterUsername 			= launchRDSInstance.getMasterUsername();
		this.masterUserPassword 		= launchRDSInstance.getMasterUserPassword();
		this.dBSecurityGroups 			= launchRDSInstance.getDBSecurityGroups().getDBSecurityGroupName();
		this.availabilityZone 			= launchRDSInstance.getAvailabilityZone();
		this.preferredMaintenanceWindow = launchRDSInstance.getPreferredMaintenanceWindow();
		this.dBParameterGroupName 		= launchRDSInstance.getDBParameterGroupName();
		this.backupRetentionPeriod 		= launchRDSInstance.getBackupRetentionPeriod();
		this.preferredBackupWindow 		= launchRDSInstance.getPreferredBackupWindow();
		this.port 						= Integer.parseInt(launchRDSInstance.getPort());
		this.multiAZ					= Boolean.getBoolean(launchRDSInstance.getMultiAZ());
		this.engineVersion 				= launchRDSInstance.getEngineVersion();
		this.autoMinorVersionUpgrade 	= Boolean.getBoolean(launchRDSInstance.getAutoMinorVersionUpgrade());
		this.region 					= launchRDSInstance.getRegion();
	}
	
	/**
	 * Gets the dB name.
	 *
	 * @return the dB name
	 */
	public String getDBName() {
		return dBName;
	}

	/**
	 * Sets the dB name.
	 *
	 * @param dBName the new dB name
	 */
	public void setDBName(String dBName) {
		this.dBName = dBName;
	}

	/**
	 * With db name.
	 *
	 * @param dBName the d b name
	 * @return the creates the db instance model
	 */
	public CreateDBInstanceModel withDBName(String dBName) {
		this.dBName = dBName;
		return this;
	}

	/**
	 * Gets the dB instance identifier.
	 *
	 * @return the dB instance identifier
	 */
	public String getDBInstanceIdentifier() {
		return dBInstanceIdentifier;
	}

	/**
	 * The DB Instance identifier. This parameter is stored as a lowercase
	 * string.
	 * 
	 * @param dBInstanceIdentifier
	 *            The DB Instance identifier. This parameter is stored as a
	 *            lowercase string.
	 */
	public void setDBInstanceIdentifier(String dBInstanceIdentifier) {
		this.dBInstanceIdentifier = dBInstanceIdentifier;
	}

	/**
	 * The DB Instance identifier. This parameter is stored as a lowercase
	 * string.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param dBInstanceIdentifier
	 *            The DB Instance identifier. This parameter is stored as a
	 *            lowercase string.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withDBInstanceIdentifier(
			String dBInstanceIdentifier) {
		this.dBInstanceIdentifier = dBInstanceIdentifier;
		return this;
	}

	/**
	 * The amount of storage (in gigabytes) to be initially allocated for the
	 * database instance.
	 * 
	 * @return The amount of storage (in gigabytes) to be initially allocated
	 *         for the database instance.
	 */
	public Integer getAllocatedStorage() {
		return allocatedStorage;
	}

	/**
	 * The amount of storage (in gigabytes) to be initially allocated for the
	 * database instance.
	 * 
	 * @param allocatedStorage
	 *            The amount of storage (in gigabytes) to be initially allocated
	 *            for the database instance.
	 */
	public void setAllocatedStorage(Integer allocatedStorage) {
		this.allocatedStorage = allocatedStorage;
	}

	/**
	 * The amount of storage (in gigabytes) to be initially allocated for the
	 * database instance.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param allocatedStorage
	 *            The amount of storage (in gigabytes) to be initially allocated
	 *            for the database instance.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withAllocatedStorage(Integer allocatedStorage) {
		this.allocatedStorage = allocatedStorage;
		return this;
	}

	/**
	 * The compute and memory capacity of the DB Instance.
	 * 
	 * @return The compute and memory capacity of the DB Instance.
	 */
	public String getDBInstanceClass() {
		return dBInstanceClass;
	}

	/**
	 * The compute and memory capacity of the DB Instance.
	 * 
	 * @param dBInstanceClass
	 *            The compute and memory capacity of the DB Instance.
	 */
	public void setDBInstanceClass(String dBInstanceClass) {
		this.dBInstanceClass = dBInstanceClass;
	}

	/**
	 * The compute and memory capacity of the DB Instance.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param dBInstanceClass
	 *            The compute and memory capacity of the DB Instance.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withDBInstanceClass(String dBInstanceClass) {
		this.dBInstanceClass = dBInstanceClass;
		return this;
	}

	/**
	 * The name of the database engine to be used for this instance.
	 * 
	 * @return The name of the database engine to be used for this instance.
	 */
	public String getEngine() {
		return engine;
	}

	/**
	 * The name of the database engine to be used for this instance.
	 * 
	 * @param engine
	 *            The name of the database engine to be used for this instance.
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}

	/**
	 * The name of the database engine to be used for this instance.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param engine
	 *            The name of the database engine to be used for this instance.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withEngine(String engine) {
		this.engine = engine;
		return this;
	}

	/**
	 * The name of master user for the client DB Instance.
	 * 
	 * @return The name of master user for the client DB Instance.
	 */
	public String getMasterUsername() {
		return masterUsername;
	}

	/**
	 * The name of master user for the client DB Instance.
	 * 
	 * @param masterUsername
	 *            The name of master user for the client DB Instance.
	 */
	public void setMasterUsername(String masterUsername) {
		this.masterUsername = masterUsername;
	}

	/**
	 * The name of master user for the client DB Instance.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param masterUsername
	 *            The name of master user for the client DB Instance.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withMasterUsername(String masterUsername) {
		this.masterUsername = masterUsername;
		return this;
	}

	/**
	 * The password for the master DB Instance user.
	 * 
	 * @return The password for the master DB Instance user.
	 */
	public String getMasterUserPassword() {
		return masterUserPassword;
	}

	/**
	 * The password for the master DB Instance user.
	 * 
	 * @param masterUserPassword
	 *            The password for the master DB Instance user.
	 */
	public void setMasterUserPassword(String masterUserPassword) {
		this.masterUserPassword = masterUserPassword;
	}

	/**
	 * The password for the master DB Instance user.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param masterUserPassword
	 *            The password for the master DB Instance user.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withMasterUserPassword(
			String masterUserPassword) {
		this.masterUserPassword = masterUserPassword;
		return this;
	}

	/**
	 * A list of DB Security Groups to associate with this DB Instance.
	 * 
	 * @return A list of DB Security Groups to associate with this DB Instance.
	 */
	public java.util.List<String> getDBSecurityGroups() {
		if (dBSecurityGroups == null) {
			dBSecurityGroups = new java.util.ArrayList<String>();
		}
		return dBSecurityGroups;
	}

	/**
	 * A list of DB Security Groups to associate with this DB Instance.
	 * 
	 * @param dBSecurityGroups
	 *            A list of DB Security Groups to associate with this DB
	 *            Instance.
	 */
	public void setDBSecurityGroups(
			java.util.Collection<String> dBSecurityGroups) {
		java.util.List<String> dBSecurityGroupsCopy = new java.util.ArrayList<String>();
		if (dBSecurityGroups != null) {
			dBSecurityGroupsCopy.addAll(dBSecurityGroups);
		}
		this.dBSecurityGroups = dBSecurityGroupsCopy;
	}

	/**
	 * A list of DB Security Groups to associate with this DB Instance.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param dBSecurityGroups
	 *            A list of DB Security Groups to associate with this DB
	 *            Instance.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withDBSecurityGroups(
			String... dBSecurityGroups) {
		for (String value : dBSecurityGroups) {
			getDBSecurityGroups().add(value);
		}
		return this;
	}

	/**
	 * A list of DB Security Groups to associate with this DB Instance.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param dBSecurityGroups
	 *            A list of DB Security Groups to associate with this DB
	 *            Instance.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withDBSecurityGroups(
			java.util.Collection<String> dBSecurityGroups) {
		java.util.List<String> dBSecurityGroupsCopy = new java.util.ArrayList<String>();
		if (dBSecurityGroups != null) {
			dBSecurityGroupsCopy.addAll(dBSecurityGroups);
		}
		this.dBSecurityGroups = dBSecurityGroupsCopy;

		return this;
	}

	/**
	 * The EC2 Availability Zone that the database instance will be created in.
	 * 
	 * @return The EC2 Availability Zone that the database instance will be
	 *         created in.
	 */
	public String getAvailabilityZone() {
		return availabilityZone;
	}

	/**
	 * The EC2 Availability Zone that the database instance will be created in.
	 * 
	 * @param availabilityZone
	 *            The EC2 Availability Zone that the database instance will be
	 *            created in.
	 */
	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	/**
	 * The EC2 Availability Zone that the database instance will be created in.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param availabilityZone
	 *            The EC2 Availability Zone that the database instance will be
	 *            created in.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
		return this;
	}

	/**
	 * The weekly time range (in UTC) during which system maintenance can occur.
	 * 
	 * @return The weekly time range (in UTC) during which system maintenance
	 *         can occur.
	 */
	public String getPreferredMaintenanceWindow() {
		return preferredMaintenanceWindow;
	}

	/**
	 * The weekly time range (in UTC) during which system maintenance can occur.
	 * 
	 * @param preferredMaintenanceWindow
	 *            The weekly time range (in UTC) during which system maintenance
	 *            can occur.
	 */
	public void setPreferredMaintenanceWindow(String preferredMaintenanceWindow) {
		this.preferredMaintenanceWindow = preferredMaintenanceWindow;
	}

	/**
	 * The weekly time range (in UTC) during which system maintenance can occur.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param preferredMaintenanceWindow
	 *            The weekly time range (in UTC) during which system maintenance
	 *            can occur.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withPreferredMaintenanceWindow(
			String preferredMaintenanceWindow) {
		this.preferredMaintenanceWindow = preferredMaintenanceWindow;
		return this;
	}

	/**
	 * The name of the database parameter group to associate with this DB
	 * instance. If this argument is omitted, the default DBParameterGroup for
	 * the specified engine will be used.
	 * 
	 * @return The name of the database parameter group to associate with this
	 *         DB instance. If this argument is omitted, the default
	 *         DBParameterGroup for the specified engine will be used.
	 */
	public String getDBParameterGroupName() {
		return dBParameterGroupName;
	}

	/**
	 * The name of the database parameter group to associate with this DB
	 * instance. If this argument is omitted, the default DBParameterGroup for
	 * the specified engine will be used.
	 * 
	 * @param dBParameterGroupName
	 *            The name of the database parameter group to associate with
	 *            this DB instance. If this argument is omitted, the default
	 *            DBParameterGroup for the specified engine will be used.
	 */
	public void setDBParameterGroupName(String dBParameterGroupName) {
		this.dBParameterGroupName = dBParameterGroupName;
	}

	/**
	 * The name of the database parameter group to associate with this DB
	 * instance. If this argument is omitted, the default DBParameterGroup for
	 * the specified engine will be used.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param dBParameterGroupName
	 *            The name of the database parameter group to associate with
	 *            this DB instance. If this argument is omitted, the default
	 *            DBParameterGroup for the specified engine will be used.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withDBParameterGroupName(
			String dBParameterGroupName) {
		this.dBParameterGroupName = dBParameterGroupName;
		return this;
	}

	/**
	 * The number of days for which automated backups are retained. Setting this
	 * parameter to a positive number enables backups. Setting this parameter to
	 * 0 disables automated backups.
	 * 
	 * @return The number of days for which automated backups are retained.
	 *         Setting this parameter to a positive number enables backups.
	 *         Setting this parameter to 0 disables automated backups.
	 */
	public Integer getBackupRetentionPeriod() {
		return backupRetentionPeriod;
	}

	/**
	 * The number of days for which automated backups are retained. Setting this
	 * parameter to a positive number enables backups. Setting this parameter to
	 * 0 disables automated backups.
	 * 
	 * @param backupRetentionPeriod
	 *            The number of days for which automated backups are retained.
	 *            Setting this parameter to a positive number enables backups.
	 *            Setting this parameter to 0 disables automated backups.
	 */
	public void setBackupRetentionPeriod(Integer backupRetentionPeriod) {
		this.backupRetentionPeriod = backupRetentionPeriod;
	}

	/**
	 * The number of days for which automated backups are retained. Setting this
	 * parameter to a positive number enables backups. Setting this parameter to
	 * 0 disables automated backups.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param backupRetentionPeriod
	 *            The number of days for which automated backups are retained.
	 *            Setting this parameter to a positive number enables backups.
	 *            Setting this parameter to 0 disables automated backups.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withBackupRetentionPeriod(
			Integer backupRetentionPeriod) {
		this.backupRetentionPeriod = backupRetentionPeriod;
		return this;
	}

	/**
	 * The daily time range during which automated backups are created if
	 * automated backups are enabled, as determined by the
	 * <i>BackupRetentionPeriod</i>.
	 *
	 * @return The daily time range during which automated backups are created
	 * if automated backups are enabled, as determined by the
	 * .
	 */
	public String getPreferredBackupWindow() {
		return preferredBackupWindow;
	}

	/**
	 * The daily time range during which automated backups are created if
	 * automated backups are enabled, as determined by the
	 * <i>BackupRetentionPeriod</i>.
	 * 
	 * @param preferredBackupWindow
	 *            The daily time range during which automated backups are
	 *            created if automated backups are enabled, as determined by the
	 *            <i>BackupRetentionPeriod</i>.
	 */
	public void setPreferredBackupWindow(String preferredBackupWindow) {
		this.preferredBackupWindow = preferredBackupWindow;
	}

	/**
	 * The daily time range during which automated backups are created if
	 * automated backups are enabled, as determined by the
	 * <i>BackupRetentionPeriod</i>.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param preferredBackupWindow
	 *            The daily time range during which automated backups are
	 *            created if automated backups are enabled, as determined by the
	 *            <i>BackupRetentionPeriod</i>.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withPreferredBackupWindow(
			String preferredBackupWindow) {
		this.preferredBackupWindow = preferredBackupWindow;
		return this;
	}

	/**
	 * The port number on which the database accepts connections.
	 * 
	 * @return The port number on which the database accepts connections.
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * The port number on which the database accepts connections.
	 * 
	 * @param port
	 *            The port number on which the database accepts connections.
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * The port number on which the database accepts connections.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param port
	 *            The port number on which the database accepts connections.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withPort(Integer port) {
		this.port = port;
		return this;
	}

	/**
	 * Returns the value of the MultiAZ property for this object.
	 * 
	 * @return The value of the MultiAZ property for this object.
	 */
	public Boolean isMultiAZ() {
		return multiAZ;
	}

	/**
	 * Sets the value of the MultiAZ property for this object.
	 * 
	 * @param multiAZ
	 *            The new value for the MultiAZ property for this object.
	 */
	public void setMultiAZ(Boolean multiAZ) {
		this.multiAZ = multiAZ;
	}

	/**
	 * Sets the value of the MultiAZ property for this object.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param multiAZ
	 *            The new value for the MultiAZ property for this object.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withMultiAZ(Boolean multiAZ) {
		this.multiAZ = multiAZ;
		return this;
	}

	/**
	 * Returns the value of the MultiAZ property for this object.
	 * 
	 * @return The value of the MultiAZ property for this object.
	 */
	public Boolean getMultiAZ() {
		return multiAZ;
	}

	/**
	 * Returns the value of the EngineVersion property for this object.
	 * 
	 * @return The value of the EngineVersion property for this object.
	 */
	public String getEngineVersion() {
		return engineVersion;
	}

	/**
	 * Sets the value of the EngineVersion property for this object.
	 * 
	 * @param engineVersion
	 *            The new value for the EngineVersion property for this object.
	 */
	public void setEngineVersion(String engineVersion) {
		this.engineVersion = engineVersion;
	}

	/**
	 * Sets the value of the EngineVersion property for this object.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param engineVersion
	 *            The new value for the EngineVersion property for this object.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withEngineVersion(String engineVersion) {
		this.engineVersion = engineVersion;
		return this;
	}

	/**
	 * Returns the value of the AutoMinorVersionUpgrade property for this
	 * object.
	 * 
	 * @return The value of the AutoMinorVersionUpgrade property for this
	 *         object.
	 */
	public Boolean isAutoMinorVersionUpgrade() {
		return autoMinorVersionUpgrade;
	}

	/**
	 * Sets the value of the AutoMinorVersionUpgrade property for this object.
	 * 
	 * @param autoMinorVersionUpgrade
	 *            The new value for the AutoMinorVersionUpgrade property for
	 *            this object.
	 */
	public void setAutoMinorVersionUpgrade(Boolean autoMinorVersionUpgrade) {
		this.autoMinorVersionUpgrade = autoMinorVersionUpgrade;
	}

	/**
	 * Sets the value of the AutoMinorVersionUpgrade property for this object.
	 * <p>
	 * Returns a reference to this object so that method calls can be chained
	 * together.
	 * 
	 * @param autoMinorVersionUpgrade
	 *            The new value for the AutoMinorVersionUpgrade property for
	 *            this object.
	 * 
	 * @return A reference to this updated object so that method calls can be
	 *         chained together.
	 */
	public CreateDBInstanceModel withAutoMinorVersionUpgrade(
			Boolean autoMinorVersionUpgrade) {
		this.autoMinorVersionUpgrade = autoMinorVersionUpgrade;
		return this;
	}

	/**
	 * Returns the value of the AutoMinorVersionUpgrade property for this
	 * object.
	 * 
	 * @return The value of the AutoMinorVersionUpgrade property for this
	 *         object.
	 */
	public Boolean getAutoMinorVersionUpgrade() {
		return autoMinorVersionUpgrade;
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

	/**
	 * Returns a string representation of this object; useful for testing and
	 * debugging.
	 * 
	 * @return A string representation of this object.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("DBName: " + dBName + ", ");
		sb.append("DBInstanceIdentifier: " + dBInstanceIdentifier + ", ");
		sb.append("AllocatedStorage: " + allocatedStorage + ", ");
		sb.append("DBInstanceClass: " + dBInstanceClass + ", ");
		sb.append("Engine: " + engine + ", ");
		sb.append("MasterUsername: " + masterUsername + ", ");
		sb.append("MasterUserPassword: " + masterUserPassword + ", ");
		sb.append("DBSecurityGroups: " + dBSecurityGroups + ", ");
		sb.append("AvailabilityZone: " + availabilityZone + ", ");
		sb.append("PreferredMaintenanceWindow: " + preferredMaintenanceWindow+ ", ");
		sb.append("DBParameterGroupName: " + dBParameterGroupName + ", ");
		sb.append("BackupRetentionPeriod: " + backupRetentionPeriod + ", ");
		sb.append("PreferredBackupWindow: " + preferredBackupWindow + ", ");
		sb.append("Port: " + port + ", ");
		sb.append("MultiAZ: " + multiAZ + ", ");
		sb.append("EngineVersion: " + engineVersion + ", ");
		sb.append("AutoMinorVersionUpgrade: " + autoMinorVersionUpgrade + ", ");
		sb.append("region: " + region + ", ");
		sb.append("}");
		return sb.toString();
	}

}

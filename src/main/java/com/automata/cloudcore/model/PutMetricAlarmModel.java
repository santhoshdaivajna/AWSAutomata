package com.automata.cloudcore.model;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.cloudwatch.model.Dimension;
import com.automata.cloudcore.xmlbindings.PutMetricAlarmType;

// TODO: Auto-generated Javadoc
/**
 * The Class PutMetricAlarmModel.
 */
public class PutMetricAlarmModel {

	/** The alarm name. */
	private String alarmName;
	
	/** The alarm description. */
	private String alarmDescription;
	
	/** The actions enabled. */
	private boolean actionsEnabled;
	
	/** The ok actions. */
	private List<String> okActions;
	
	/** The alarm actions. */
	private List<String> alarmActions;
	
	/** The insufficient data actions. */
	private List<String> insufficientDataActions;
	
	/** The metric name. */
	private String metricName;
	
	/** The namespace. */
	private String namespace;
	
	/** The statistic. */
	private String statistic;
	
	/** The dimensions. */
	private List<Dimension> dimensions;
	
	/** The period. */
	private Integer period;
	
	/** The unit. */
	private String unit;
	
	/** The evaluation periods. */
	private Integer evaluationPeriods;
	
	/** The threshold. */
	private Double threshold;
	
	/** The comparison operator. */
	private String comparisonOperator;

	/**
	 * Instantiates a new put metric alarm model.
	 */
	public PutMetricAlarmModel() {
	}

	/**
	 * Instantiates a new put metric alarm model.
	 *
	 * @param alarmName the alarm name
	 * @param alarmDescription the alarm description
	 * @param actionsEnabled the actions enabled
	 * @param okActions the ok actions
	 * @param alarmActions the alarm actions
	 * @param insufficientDataActions the insufficient data actions
	 * @param metricName the metric name
	 * @param namespace the namespace
	 * @param statistic the statistic
	 * @param dimensions the dimensions
	 * @param period the period
	 * @param unit the unit
	 * @param evaluationPeriods the evaluation periods
	 * @param threshold the threshold
	 * @param comparisonOperator the comparison operator
	 */
	public PutMetricAlarmModel(String alarmName, String alarmDescription,
			boolean actionsEnabled, List<String> okActions,
			List<String> alarmActions, List<String> insufficientDataActions,
			String metricName, String namespace, String statistic,
			List<Dimension> dimensions, Integer period, String unit,
			Integer evaluationPeriods, Double threshold,
			String comparisonOperator) {
		super();
		this.alarmName = alarmName;
		this.alarmDescription = alarmDescription;
		this.actionsEnabled = actionsEnabled;
		this.okActions = okActions;
		this.alarmActions = alarmActions;
		this.insufficientDataActions = insufficientDataActions;
		this.metricName = metricName;
		this.namespace = namespace;
		this.statistic = statistic;
		this.dimensions = dimensions;
		this.period = period;
		this.unit = unit;
		this.evaluationPeriods = evaluationPeriods;
		this.threshold = threshold;
		this.comparisonOperator = comparisonOperator;
	}

	/**
	 * Instantiates a new put metric alarm model.
	 *
	 * @param putMetricAlarmType the put metric alarm type
	 */
	public PutMetricAlarmModel(PutMetricAlarmType putMetricAlarmType) {

		this.alarmName = putMetricAlarmType.getAlarmName();
		this.alarmDescription = putMetricAlarmType.getAlarmDescription();
		this.actionsEnabled = putMetricAlarmType.isActionsEnabled();
		if (putMetricAlarmType.getOKActions() != null)
			this.okActions = putMetricAlarmType.getOKActions().getMember();
		if (putMetricAlarmType.getAlarmActions() != null)
			this.alarmActions = putMetricAlarmType.getAlarmActions()
					.getMember();
		if (putMetricAlarmType.getInsufficientDataActions() != null)
			this.insufficientDataActions = putMetricAlarmType
					.getInsufficientDataActions().getMember();
		this.metricName = putMetricAlarmType.getMetricName();
		this.namespace = putMetricAlarmType.getNamespace();
		this.statistic = putMetricAlarmType.getStatistic().value();

		List<com.automata.cloudcore.xmlbindings.Dimension> inputDimensionList = null;
		List<Dimension> dimensionList = null;
		if (putMetricAlarmType.getDimensions() != null) {
			inputDimensionList = putMetricAlarmType.getDimensions().getMember();
			dimensionList = new ArrayList<Dimension>();
			Dimension dimension = null;
			for (com.automata.cloudcore.xmlbindings.Dimension inputDimension : inputDimensionList) {
				dimension = new Dimension();
				dimension.setName(inputDimension.getName());
				dimension.setValue(inputDimension.getValue());
				dimensionList.add(dimension);
			}
		}
		this.dimensions = dimensionList;
		this.period = putMetricAlarmType.getPeriod();
		this.unit = putMetricAlarmType.getUnit().value();
		this.evaluationPeriods = putMetricAlarmType.getEvaluationPeriods();
		this.threshold = putMetricAlarmType.getThreshold();
		this.comparisonOperator = putMetricAlarmType.getComparisonOperator()
				.value();
	}

	/**
	 * Gets the alarm name.
	 *
	 * @return the alarm name
	 */
	public String getAlarmName() {
		return alarmName;
	}

	/**
	 * Sets the alarm name.
	 *
	 * @param alarmName the new alarm name
	 */
	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}

	/**
	 * Gets the alarm description.
	 *
	 * @return the alarm description
	 */
	public String getAlarmDescription() {
		return alarmDescription;
	}

	/**
	 * Sets the alarm description.
	 *
	 * @param alarmDescription the new alarm description
	 */
	public void setAlarmDescription(String alarmDescription) {
		this.alarmDescription = alarmDescription;
	}

	/**
	 * Checks if is actions enabled.
	 *
	 * @return true, if is actions enabled
	 */
	public boolean isActionsEnabled() {
		return actionsEnabled;
	}

	/**
	 * Sets the actions enabled.
	 *
	 * @param actionsEnabled the new actions enabled
	 */
	public void setActionsEnabled(boolean actionsEnabled) {
		this.actionsEnabled = actionsEnabled;
	}

	/**
	 * Gets the ok actions.
	 *
	 * @return the ok actions
	 */
	public List<String> getOkActions() {
		return okActions;
	}

	/**
	 * Sets the ok actions.
	 *
	 * @param okActions the new ok actions
	 */
	public void setOkActions(List<String> okActions) {
		this.okActions = okActions;
	}

	/**
	 * Gets the alarm actions.
	 *
	 * @return the alarm actions
	 */
	public List<String> getAlarmActions() {
		return alarmActions;
	}

	/**
	 * Sets the alarm actions.
	 *
	 * @param alarmActions the new alarm actions
	 */
	public void setAlarmActions(List<String> alarmActions) {
		this.alarmActions = alarmActions;
	}

	/**
	 * Gets the insufficient data actions.
	 *
	 * @return the insufficient data actions
	 */
	public List<String> getInsufficientDataActions() {
		return insufficientDataActions;
	}

	/**
	 * Sets the insufficient data actions.
	 *
	 * @param insufficientDataActions the new insufficient data actions
	 */
	public void setInsufficientDataActions(List<String> insufficientDataActions) {
		this.insufficientDataActions = insufficientDataActions;
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
	 * Gets the statistic.
	 *
	 * @return the statistic
	 */
	public String getStatistic() {
		return statistic;
	}

	/**
	 * Sets the statistic.
	 *
	 * @param statistic the new statistic
	 */
	public void setStatistic(String statistic) {
		this.statistic = statistic;
	}

	/**
	 * Gets the dimensions.
	 *
	 * @return the dimensions
	 */
	public List<Dimension> getDimensions() {
		return dimensions;
	}

	/**
	 * Sets the dimensions.
	 *
	 * @param dimensions the new dimensions
	 */
	public void setDimensions(List<Dimension> dimensions) {
		this.dimensions = dimensions;
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
	 * Gets the evaluation periods.
	 *
	 * @return the evaluation periods
	 */
	public Integer getEvaluationPeriods() {
		return evaluationPeriods;
	}

	/**
	 * Sets the evaluation periods.
	 *
	 * @param evaluationPeriods the new evaluation periods
	 */
	public void setEvaluationPeriods(Integer evaluationPeriods) {
		this.evaluationPeriods = evaluationPeriods;
	}

	/**
	 * Gets the threshold.
	 *
	 * @return the threshold
	 */
	public Double getThreshold() {
		return threshold;
	}

	/**
	 * Sets the threshold.
	 *
	 * @param thresholds the new threshold
	 */
	public void setThreshold(Double thresholds) {
		this.threshold = thresholds;
	}

	/**
	 * Gets the comparison operator.
	 *
	 * @return the comparison operator
	 */
	public String getComparisonOperator() {
		return comparisonOperator;
	}

	/**
	 * Sets the comparison operator.
	 *
	 * @param comparisonOperator the new comparison operator
	 */
	public void setComparisonOperator(String comparisonOperator) {
		this.comparisonOperator = comparisonOperator;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("PutMetricAlarmModel [actionsEnabled=");
		stringBuilder.append(actionsEnabled);
		stringBuilder.append(", alarmActions=");
		stringBuilder.append(alarmActions);
		stringBuilder.append(", alarmDescription=");
		stringBuilder.append(alarmDescription);
		stringBuilder.append(", alarmName=");
		stringBuilder.append(alarmName);
		stringBuilder.append(", comparisonOperator=");
		stringBuilder.append(comparisonOperator);
		stringBuilder.append(", dimensions=");
		stringBuilder.append(dimensions);
		stringBuilder.append(", evaluationPeriods=");
		stringBuilder.append(evaluationPeriods);
		stringBuilder.append(", insufficientDataActions=");
		stringBuilder.append(insufficientDataActions);
		stringBuilder.append(", metricName=");
		stringBuilder.append(metricName);
		stringBuilder.append(", namespace=");
		stringBuilder.append(namespace);
		stringBuilder.append(", okActions=");
		stringBuilder.append(okActions);
		stringBuilder.append(", period=");
		stringBuilder.append(period);
		stringBuilder.append(", statistic=");
		stringBuilder.append(statistic);
		stringBuilder.append(", threshold=");
		stringBuilder.append(threshold);
		stringBuilder.append(", unit=");
		stringBuilder.append(unit);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}

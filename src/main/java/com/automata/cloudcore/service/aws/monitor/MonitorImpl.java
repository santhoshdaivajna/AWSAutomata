package com.automata.cloudcore.service.aws.monitor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import com.amazonaws.services.cloudwatch.model.PutMetricAlarmRequest;
import com.automata.cloudcore.model.GetMetricStatisticsModel;
import com.automata.cloudcore.model.PutMetricAlarmModel;

@Component
public class MonitorImpl implements IMonitor {

	private static AmazonCloudWatch cw;

	public MonitorImpl() throws Exception {
		init();
	}

	public GetMetricStatisticsResult getCloudWatchMetrics(
			GetMetricStatisticsModel metric) {

		GetMetricStatisticsRequest getMetricStatisticsRequest = null;
		GetMetricStatisticsResult getMetricStatisticsResult = null;
		List<Dimension> dimensions = null;

		cw.setEndpoint(metric.getRegion());
		getMetricStatisticsRequest = new GetMetricStatisticsRequest()
				.withDimensions(metric.getDimensions())
				.withMetricName(metric.getMetricName())
				.withPeriod(metric.getPeriod())
				.withStatistics(metric.getStatistics())
				.withEndTime(metric.getEndTime())
				.withStartTime(metric.getStartTime())
				.withNamespace(metric.getNamespace())
				.withUnit(metric.getUnit());
		
		dimensions = metric.getDimensions(); 
		if (dimensions != null && !dimensions.isEmpty() )
			getMetricStatisticsRequest.withDimensions(dimensions);
		
		getMetricStatisticsResult = cw
				.getMetricStatistics(getMetricStatisticsRequest);

		logger.debug(getMetricStatisticsResult.getDatapoints().toString());
		return getMetricStatisticsResult;
	}

	public void putMetricAlarm(PutMetricAlarmModel putMetricAlarmModel) {

		PutMetricAlarmRequest metricAlarmReq;
		
		String alarmDescription	 	= putMetricAlarmModel.getAlarmDescription();
		boolean actionsEnabled 		= putMetricAlarmModel.isActionsEnabled();
		List<String> okActions 		= putMetricAlarmModel.getOkActions();
		List<String> alarmActions 	= putMetricAlarmModel.getAlarmActions();
		List<String> insufficientDataActions = putMetricAlarmModel
		.getInsufficientDataActions();
		List<Dimension> dimensions 	= putMetricAlarmModel.getDimensions();
		Integer period 				= putMetricAlarmModel.getPeriod();
		String unit 				= putMetricAlarmModel.getUnit();

		metricAlarmReq = new PutMetricAlarmRequest();
		metricAlarmReq.withAlarmName(putMetricAlarmModel.getAlarmName())
		.withComparisonOperator(putMetricAlarmModel.getComparisonOperator())
		.withEvaluationPeriods(putMetricAlarmModel.getEvaluationPeriods())
		.withMetricName(putMetricAlarmModel.getMetricName())
		.withNamespace(putMetricAlarmModel.getNamespace())
		.withPeriod(period).withStatistic(putMetricAlarmModel.getStatistic())
		.withThreshold(putMetricAlarmModel.getThreshold());
		
		if (actionsEnabled)
			metricAlarmReq.withActionsEnabled(actionsEnabled);
		
		if (alarmActions != null && alarmActions.size() > 0)
			metricAlarmReq.withAlarmActions(alarmActions);
		
		if (StringUtils.hasLength(alarmDescription))
			metricAlarmReq.withAlarmDescription(alarmDescription);
		
		if (dimensions != null && dimensions.size() > 0)
			metricAlarmReq.withDimensions(dimensions);
		
		if (insufficientDataActions != null && insufficientDataActions.size() > 0)
			metricAlarmReq.withInsufficientDataActions(insufficientDataActions);
		
		if (okActions != null && okActions.size() > 0)
			metricAlarmReq.withOKActions(okActions);
		
		if(StringUtils.hasLength(unit))
			metricAlarmReq.withUnit(unit);
		cw.putMetricAlarm(metricAlarmReq);
	}

	private void init() throws IOException {
		AWSCredentials credentials;
		credentials = new PropertiesCredentials(new File("AwsCredentials.properties"));
		cw = new AmazonCloudWatchClient(credentials);
	}

	private static Logger logger = LoggerFactory.getLogger(MonitorImpl.class
			.getName());
}

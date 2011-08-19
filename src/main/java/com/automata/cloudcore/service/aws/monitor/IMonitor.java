package com.automata.cloudcore.service.aws.monitor;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import com.automata.cloudcore.model.GetMetricStatisticsModel;
import com.automata.cloudcore.model.PutMetricAlarmModel;

public interface IMonitor {

	public GetMetricStatisticsResult getCloudWatchMetrics(
			GetMetricStatisticsModel metric) throws AmazonServiceException,
			AmazonClientException;

	public void putMetricAlarm(PutMetricAlarmModel putMetricAlarmModel)
			throws AmazonServiceException, AmazonClientException;
}

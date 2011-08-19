package com.automata.cloudcore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.automata.cloudcore.model.PutMetricAlarmModel;
import com.automata.cloudcore.service.aws.monitor.IMonitor;
import com.automata.cloudcore.xmlbindings.Automata;
import com.automata.cloudcore.xmlbindings.PutMetricAlarmDetailsType;
import com.automata.cloudcore.xmlbindings.PutMetricAlarmType;
@Component
public class PutMetricAlarmController implements IController {

	@Autowired
	private IMonitor cw;

	@Override
	public Object execute(Object obj) throws Exception {

		Automata automata = null;
		List<PutMetricAlarmType> putMetricAlarmList = null;
		List<PutMetricAlarmDetailsType> putMetricAlarmDetailsList = null;
		PutMetricAlarmDetailsType putMetricAlarmDetails = null;
		PutMetricAlarmModel putMetricAlarmModel = null;
		automata = (Automata) obj;
		putMetricAlarmList = automata.getResources().getPutMetricAlarm();
		putMetricAlarmDetailsList = new ArrayList<PutMetricAlarmDetailsType>();

		for (PutMetricAlarmType putMetricAlarmType : putMetricAlarmList ) {
			try{
				putMetricAlarmModel = new PutMetricAlarmModel(putMetricAlarmType);
				putMetricAlarmDetails = new PutMetricAlarmDetailsType(putMetricAlarmType);
				cw.putMetricAlarm(putMetricAlarmModel);
				putMetricAlarmDetails.setStatus("Metric alarm -"+putMetricAlarmModel.getAlarmName()+" added successfully");

			} catch (AmazonServiceException ase) {
				putMetricAlarmDetails.setStatus(ase.getMessage());
				logger.error("AmazonServiceException while creating metric alarm "
						+ ase.getMessage(), ase);
			} catch (AmazonClientException ace) {
				putMetricAlarmDetails.setStatus(ace.getMessage());
				logger.error("AmazonClientException while creating metric alarm", ace);
			}
			putMetricAlarmDetailsList.add(putMetricAlarmDetails);
		}
		automata.getOutputs().setPutMetricAlarmDetails(putMetricAlarmDetailsList);
		return automata;
	}

	private static Logger logger = LoggerFactory
	.getLogger(PutMetricAlarmController.class.getName());

}

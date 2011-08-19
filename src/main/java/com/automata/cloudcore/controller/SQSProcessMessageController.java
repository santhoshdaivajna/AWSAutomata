package com.automata.cloudcore.controller;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.model.SQSReceiveMessage;
import com.automata.cloudcore.service.aws.sqs.ISQS;
import com.automata.cloudcore.util.JAXBUtil;
import com.automata.cloudcore.util.LocateController;
import com.automata.cloudcore.xmlbindings.Automata;

/**
 * The Class ProcessMessageController.
 */
//TODO: remove all static references
public class SQSProcessMessageController {

	@Autowired
	private static ISQS sqs;

	public static void main(String[] args) {

		Automata automata = null;
		JAXBContext jc = null;
		Unmarshaller u = null;
		Marshaller m = null;
		String action = "";
		IController controller = null;
		Object obj = null;
		ByteArrayInputStream input = null;

		List<String> inputXmlList = null;
		String outputXml = "";
		try{

			jc 	= JAXBContext.newInstance(Constants.XML_BINDINGS_PACKAGENAME);
			u 	= jc.createUnmarshaller();
			inputXmlList = getSQSMessages();
			
			for (String xml : inputXmlList){

				try {
					//automata = ((JAXBElement<AutomataType>) u.unmarshal(new FileInputStream("EC2InstancesTemplate2.0.0.xml"))).getValue();
					input = new ByteArrayInputStream (xml.getBytes());
					automata = ((JAXBElement<Automata>) u.unmarshal(input)).getValue();
					//u.setSchema(SchemaFactory.newInstance(""http://www.w3.org/2001/XMLSchema"").newSchema(new File("D:\\8KMiles\\REngine\\schema0.xsd")));
					action = automata.getAction();
					controller = LocateController.locate(action);
					obj = controller.execute(automata);
					outputXml = JAXBUtil.marshallAsString(jc, obj);
					System.out.println("outputXml = "+outputXml);
					
				} catch (Exception e) {
					logger.error(e.toString(),e);
					e.printStackTrace();
				}
			}
		}catch (Exception e) {
			logger.error(e.toString(),e);
			e.printStackTrace();
		}
	}

	private static List<String> getSQSMessages() 
		throws Exception {

		SQSReceiveMessage message = null;
		ReceiveMessageResult result;
		List<Message> messages;
		List<String> inputXmlList = null;
		
		// TODO: add the queue URL to constants and  number of messages
		message = new SQSReceiveMessage();
		message.setQueueUrl(Constants.MESSAGE_QUEUE);
		Integer maxNumberOfMessages = 1;
		message.setMaxNumberOfMessages(maxNumberOfMessages);
		
		result = sqs.recieveMessage(message);
		messages = result.getMessages();
		inputXmlList = new ArrayList<String>();
		for (Message msg : messages) {
			inputXmlList.add(msg.getBody());
		}

		return inputXmlList;
	}
	
	/** The Constant LOG. */
	private static final Logger logger = LoggerFactory.getLogger(SQSProcessMessageController.class);

}

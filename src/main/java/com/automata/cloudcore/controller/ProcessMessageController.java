package com.automata.cloudcore.controller;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.util.JAXBUtil;
import com.automata.cloudcore.util.LocateController;
import com.automata.cloudcore.xmlbindings.Automata;

/**
 * The Class ProcessMessageController.
 * reads the input, marshalls the data, call the respective action controller.
 * The action controller processes the data and takes the neccessary actions
 * and builds the output.
 * 
 * @author Santhosh Daivajna
 */
@Component
public class ProcessMessageController {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		Automata automata	 = null;
		IController controller = null;
		String action = "";
		Object obj = null;
		String fileName = "TerminateAutomata.xml";

		try {
			automata = JAXBUtil.unmarshall(fileName);
			action = automata.getAction();
			logger.debug("Automata - "+automata +"\n Action =["+action+"]");
			controller = LocateController.locate(action);
			obj = controller.execute(automata);
			JAXBUtil.marshall(obj);
			automata.setStatus(Constants.AUTOMATA_SUCCESS);
		}catch(JAXBException je){
			automata.setStatus("JAXBException thrown in "+ProcessMessageController.class.getName());
			logger.error("JAXBException thrown in "+ProcessMessageController.class.getName(), je);
		}catch (Exception e) {
			automata.setStatus("Exception thrown in "+ProcessMessageController.class.getName());
			logger.error("Exception thrown in "+ProcessMessageController.class.getName(), e);
		}
	}

	/** The Constant LOG. */
	private static final Logger logger = LoggerFactory.getLogger(ProcessMessageController.class);

}

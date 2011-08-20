package com.automata.cloudcore.util;

import com.automata.cloudcore.bean.BeanLocatorUtil;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.controller.IController;

public class LocateController {
	
	public static IController locate(String action) throws Exception {
		
		IController controller = null;
		String controllerName = "";
		if (action.equalsIgnoreCase(Constants.CREATE)){
			controllerName = "createAutomataController";
		} else if (action.equalsIgnoreCase(Constants.STOP)) {
			controllerName = "stopAutomataController";
		} else if (action.equalsIgnoreCase(Constants.RESUME)){
			controllerName = "resumeAutomataController";
		} else if (action.equalsIgnoreCase(Constants.TERMINATE)) {
			controllerName = "terminateAutomataController";
		} else if (action.equalsIgnoreCase(Constants.DESCRIBE)) {
			controllerName = "describeAutomataController";
		}
		controller = (IController) BeanLocatorUtil.locate(controllerName);
		return controller;
	}

}

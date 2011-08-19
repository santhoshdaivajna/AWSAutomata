package com.automata.cloudcore.util;

import com.automata.cloudcore.bean.BeanLocatorUtil;
import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.controller.IController;

public class LocateController {
	
	public static IController locate(String action) throws Exception {
		
		IController controller = null;
		String controllerName = "";
		if (action.equalsIgnoreCase(Constants.CREATE)){
			controllerName = "CreateAutomataController";
		} else if (action.equalsIgnoreCase(Constants.STOP)) {
			controllerName = "StopAutomataController";
		} else if (action.equalsIgnoreCase(Constants.RESUME)){
			controllerName = "ResumeAutomataController";
		} else if (action.equalsIgnoreCase(Constants.TERMINATE)) {
			controllerName = "TerminateAutomataController";
		} else if (action.equalsIgnoreCase(Constants.DESCRIBE)) {
			controllerName = "DescribeAutomataController";
		}
		controller = (IController) BeanLocatorUtil.locate(controllerName);
		return controller;
	}

}

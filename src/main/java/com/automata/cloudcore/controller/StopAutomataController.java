package com.automata.cloudcore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.automata.cloudcore.bean.BeanLocatorUtil;
@Component
public class StopAutomataController implements IController {
	/** The controller list. */
	private List<String> controllerList; 
	

	public Object execute(Object obj) {
		
		Object response = null;
		
		try {
			if(controllerList != null) {
				for(int loopCounter = 0; loopCounter < controllerList.size(); loopCounter++) {
					response = ((IController)BeanLocatorUtil.locate(controllerList.get(loopCounter))).execute(obj);
					obj = response;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	/**
	 * Sets the controller list.
	 *
	 * @param controllerList the new controller list
	 */
	public void setControllerList(List<String> controllerList) {
		this.controllerList = controllerList;
	}
	
	/** The Constant LOG. */
	private static final Logger logger = LoggerFactory.getLogger(CreateAutomataController.class);

}

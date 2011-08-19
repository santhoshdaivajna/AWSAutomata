package com.automata.cloudcore.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * BeanLocatorImpl builds the application context, taking the context definition files 
 * from the class path and provides methods to returns the bean instance that uniquely
 * matches the given object name, if any.
 * 
 */
public class BeanLocatorImpl implements IBeanLocator {

	/**
	 * Loads the spring xml from the class path
	 * and returns the bean instance that uniquely matches the given object name, if any.
	 * 
	 * @param name - Bean to be located
	 * @return located bean object
	 */	
	public Object locate(String name) throws Exception {
		
		Object obj = null;
		
		try {
			
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"root-context.xml"});
			obj = context.getBean(name);
			
		} catch(Exception e) {
			logger.error("Exception while locating bean ["+name+"]", e);	
			throw new Exception("Exception while locating bean ["+name+"]", e);
		}		
		
		return obj;	
		
	}	
	
	
	/**
	 * The logger.
	 */
	private static final Logger logger = LoggerFactory
	.getLogger(BeanLocatorImpl.class.getName());
}

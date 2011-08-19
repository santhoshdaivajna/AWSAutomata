package com.automata.cloudcore.bean;


/**
 * Looks up and locates a specific bean 
 * 
 * @author Raghu
 */
public class BeanLocatorUtil {
	
	private static IBeanLocator  _beanLocator;
	
	/**
	 * Locates the specified bean name and returns the bean object
	 * 
	 * @param name - Bean to be located
	 * @return located bean object
	 */
	public static Object locate(String name) throws Exception {
		
		
		if(_beanLocator == null) {
			_beanLocator = new BeanLocatorImpl();
		}
		
		return _beanLocator.locate(name);
		
	}

}

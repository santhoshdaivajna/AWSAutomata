package com.automata.cloudcore.bean;


public interface IBeanLocator {
	
	/** Locates the specified bean name and returns the bean object
	 * 
	 * @param name - Bean to be located
	 * @return located bean object
	 */
	public Object locate(String name) throws Exception;

}

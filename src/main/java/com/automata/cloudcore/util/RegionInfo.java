package com.automata.cloudcore.util;

import com.automata.cloudcore.constants.Constants;

public class RegionInfo {

    private String name;
    private String region;
    
    public RegionInfo(String name, String region) {
            this.name = name;
            this.region = region;
    }

    public String getEndPoint(){
    	
    	String endPoint ="";
    	if (region.trim().equalsIgnoreCase(Constants.US_EAST_1)) {
			endPoint = name +"."+ Constants.URL_US_EAST;
		} else if (region.equalsIgnoreCase(Constants.US_WEST_1)) {
			endPoint = name +"."+ Constants.URL_US_WEST;
		} else if (region.trim().equalsIgnoreCase(Constants.EU_WEST_1)) {
			endPoint = name +"."+ Constants.URL_EU_WEST;
		} else if (region.trim().equalsIgnoreCase(Constants.AP_SOUTHEAST_1)) {
			endPoint = name +"."+ Constants.URL_AP_SOUTHEAST;
		} else if (region.trim().equalsIgnoreCase(Constants.AP_NORTHEAST_1)) {
			endPoint = name +"."+ Constants.URL_AP_NORTHEAST;
		}
    	return endPoint;
    }

}

package com.randstand.cal;
import java.util.HashMap;

/**
 * The CONSTANTS class is a helper class to store all constants.
 * 
 * @author Akshay_Hegde
 *
 */

public class CONSTANTS {
	
	static HashMap<Integer, Integer> monthsMap=new HashMap<Integer, Integer>();
	static {
		monthsMap.put(0, 31);
		monthsMap.put(1, 28);
		monthsMap.put(2, 31);
		monthsMap.put(3, 30);
		monthsMap.put(4, 31);
		monthsMap.put(5, 30);
		monthsMap.put(6, 31);
		monthsMap.put(7, 31);
		monthsMap.put(8, 30);
		monthsMap.put(9, 31);
		monthsMap.put(10, 30);
		monthsMap.put(11, 31);
	}
	
	static HashMap<String,String> zones = new HashMap<String, String>();
	static {
		zones.put("LINT","+14");
		zones.put("CHADT","+13:45");
		zones.put("NZDT","+13");
		zones.put("ANAT","+12");
		zones.put("AEDT","+11");
		zones.put("ACDT","+10:30");
		zones.put("AEST","+10");
		zones.put("ACST","+9:30");
		zones.put("JST","+9");
		zones.put("ACWST","+8:45");
		zones.put("CST","+8");
		zones.put("WIB","+7");
		zones.put("MMT","+6:30");
		zones.put("BST","+6");
		zones.put("NPT","+5:45");
		zones.put("IST","+5:30");
		zones.put("UZT","+5");
		zones.put("AFT","+4:30");
		zones.put("GST","+4");
		zones.put("IRST","+3:30");
		zones.put("MSK","+3");
		zones.put("EET","+2");
		zones.put("CET","+1");
		zones.put("GMT","+0");
		zones.put("CVT","-1");
		zones.put("BRST","-2");
		zones.put("ART","-3");
		zones.put("NST","-3:30");
		zones.put("VET","-4");
		zones.put("EST","-5");
		zones.put("CST","-6");
		zones.put("MST","-7");
		zones.put("PST","-8");
		zones.put("AKST","-9");
		zones.put("MART","-9:30");
		zones.put("HST","-10");
		zones.put("NUT","-11");
		zones.put("AoE","-12");
	}

}

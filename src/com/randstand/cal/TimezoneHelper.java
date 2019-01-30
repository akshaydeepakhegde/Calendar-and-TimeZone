package com.randstand.cal;
import java.util.ArrayList;

/**
 * The TimezoneHelper class represents the entire operations regarding timezones. 
 * 
 * @author Akshay_Hegde
 *
 */

public class TimezoneHelper{

	/**
	 * returns an instance of the timezone
	 * 
	 * @param name name of the timezone given
	 * @throws TimezoneException when there is no timezone with the given name.
	 */
	public static Timezone getInstance(String name) throws TimezoneException {
		Timezone zone = new Timezone();
		if(timezoneExists(name.toUpperCase())) {
			zone.setUtcOffset(TimezoneHelper.getUTCOffset(name.toUpperCase()));
			zone.setTimeZoneName(name.toUpperCase());
		}else {
			throw new TimezoneException("No Timezone with name "+name);
		}
		return zone;
	}
	
	/**
	 * returns the offset of the timezone from UTC.
	 * 
	 * @param name name of the timezone given
	 */
	public static int getUTCOffset(String name) {
		String[] val = CONSTANTS.zones.get(name).trim().split(":");
		int off = Integer.parseInt(val[0])*60;
		if(val.length > 1) {
			if(val[0].charAt(0)=='+') {
				off += Integer.parseInt(val[1]);
			}else {
				off -= Integer.parseInt(val[1]);
			}
		}
		return off;
	}
	
	/**
	 * returns true if the timezone entered is valid.
	 * 
	 * @param name name of the timezone given
	 */
	private static boolean timezoneExists(String name) {
		if(CONSTANTS.zones.containsKey(name)) {
			return true;
		}
		return false;
	}

	/**
	 * returns the timezones between two timezones
	 * 
	 * @param zone1 timezone 1
	 * @param zone2 timezone 2
	 */
	public static ArrayList<String> getTimeZonesBetween(Timezone zone1, Timezone zone2) {
		if(zone1.getUtcOffset() < zone2.getUtcOffset()) {
			return TimezoneHelper.getTimeZonesBetween(zone2, zone1);
		}
		ArrayList<String> list = new ArrayList<String>();
		for(String key: CONSTANTS.zones.keySet()) {
			int off = TimezoneHelper.getUTCOffset(key);
			if(zone2.getUtcOffset()<off && zone1.getUtcOffset()>off) {
				list.add(key);
			}
		}
		return list;
	}
	
	/**
	 * returns the number of timezones between two timezones
	 * 
	 * @param zone1 timezone 1
	 * @param zone2 timezone 2
	 */
	public static int numberOfTimezones(Timezone zone1, Timezone zone2) {
		return TimezoneHelper.getTimeZonesBetween(zone1, zone2).size();
		
	}

}

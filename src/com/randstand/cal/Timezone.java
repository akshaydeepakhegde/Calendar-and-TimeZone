package com.randstand.cal;
import java.util.Set;

/**
 * The class TimeZone is a Data Structure(data model) to hold the timezone data.
 * It has getters and setters for various fields.
 * 
 * @author Akshay_Hegde
 *
 */

public class Timezone {
	
	private int utcOffset = 0;
	private String timeZoneName = "";
	
	public int getUtcOffset() {
		return utcOffset;
	}
	public void setUtcOffset(int utcOffset) {
		this.utcOffset = utcOffset;
	}
	public String getTimeZoneName() {
		return timeZoneName;
	}
	public void setTimeZoneName(String timeZoneName) {
		this.timeZoneName = timeZoneName;
	}
	public static Set<String> getAllZones() {
		return CONSTANTS.zones.keySet();
	}
	
}

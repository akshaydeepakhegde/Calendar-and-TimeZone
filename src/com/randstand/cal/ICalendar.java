package com.randstand.cal;
/**
 * The ICalendar interface is a bluebrint which specifies a set of methods that the class has to implement. 
 * 
 * @author Akshay_Hegde
 *
 */
public interface ICalendar {
	Date date = null;
	public long getEpochDifference(Date date);
	public void computeEpoch();
	public boolean isLeapYear(int yyyy);
	public long getNumberOfDays(Calendar obj);
}

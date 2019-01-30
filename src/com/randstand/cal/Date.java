package com.randstand.cal;
/**
 * The Date class is a Data Structure(data model) to store the Date parameters.
 * It has getters and setters for various fields. 
 * 
 * @author Akshay_Hegde
 *
 */
public class Date {
	private int date;
	private int month;
	private int year;
	public long epochTime;
	private boolean normalized;
	public boolean isNormalized() {
		return normalized;
	}
	public void setNormalized(boolean normalized) {
		this.normalized = normalized;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public long getEpochTime() {
		return epochTime;
	}
	public void setEpochTime(long epochTime) {
		this.epochTime = epochTime;
	}
}

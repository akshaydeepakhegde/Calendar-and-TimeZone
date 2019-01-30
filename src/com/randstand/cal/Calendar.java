package com.randstand.cal;
/**
 * The Calendar class implements the Calendar interface.
 * 
 * @author Akshay_Hegde
 *
 */
public class Calendar implements ICalendar{
	
	private Date date;
	
	/**
	 * Constructor
	 */
	public Calendar() {
		
	}
	
	/**
	 * Parameterized Constructor.
	 * @param date the date given of type Date 
	 */
	public Calendar(Date date) {
		this.date = date;
	}
	
	/**
	 * Parameterized Constructor.
	 * @param date the date given of type string
	 * @throws InvalidDateFormatException when invalid format is entered for date
	 */
	public Calendar(String date) throws InvalidDateFormatException {
		this.date = new Date();
		this.dateParser(date,"mm/dd/yyyy");
	}
	
	/**
	 * Parameterized Constructor.
	 * @param date the date given of type string
	 * @param format format to parse the date
	 * @throws InvalidDateFormatException
	 */
	public Calendar(String date, String format) throws InvalidDateFormatException {
		this.date = new Date();
		this.dateParser(date, format);
	}
	
	/**
	 * parses the date from string type to Date type
	 * 
	 * @param date_ the date given of type string
	 * @param format format to parse the date
	 * @throws InvalidDateFormatException
	 */
	private void dateParser(String date_, String format) throws InvalidDateFormatException {
		String con[] = format.trim().split("/");
		String val[] = date_.trim().split("/");
		if(con.length==1) {
			con = format.split("-");
			val = date_.split("-");
		}
		try {
		for(int i=0;i<con.length;i++) {
			switch(con[i].toLowerCase()) {
				case "mm": this.date.setMonth(Integer.parseInt(val[i])-1);
					break;
				case "dd": this.date.setDate(Integer.parseInt(val[i]));
					break;
				case "yyyy": this.date.setYear(Integer.parseInt(val[i]));
					break;
				default: break;
			}
		}
		}catch(Exception e) {
			throw new InvalidDateFormatException("Invalid format. Please check the date.");
		}
		if(this.date.getMonth()<0 || this.date.getMonth()>11) {
			throw new InvalidDateFormatException("Invalid Month Entered.");
		}
		if(this.date.getDate()>0) {
			if(this.date.getDate()>CONSTANTS.monthsMap.get(this.date.getMonth())) {
				if(!(this.date.getMonth()==1 && this.isLeapYear(this.date.getYear()) && this.date.getDate()==29))
					throw new InvalidDateFormatException("Invalid Date Entered.");
			}
		}else {
			throw new InvalidDateFormatException("Invalid Date Entered.");
		}
		if(this.date.getYear()<1970) {
			throw new InvalidDateFormatException("Invalid Year Entered. Must be greater than 1970.");
		}
	}
	
	/**
	 * returns the difference between two dates in seconds
	 * 
	 * @param date Date structure
	 */
	public long getEpochDifference(Date date) {
		return this.date.getEpochTime()-date.getEpochTime();
	}
	
	/**
	 * computes the time in seconds since epoch
	 */
	public void computeEpoch() {
		this.date.setEpochTime(0);
		for(int i=1970;i<this.date.getYear();i++) {
			if(this.isLeapYear(i)) {
				this.date.epochTime += 366*86400;
			}else {
				this.date.epochTime += 365*86400;
			}
		}
		for(int i=0;i<this.date.getMonth();i++) {
			if(i==1 && isLeapYear(this.date.getYear())) {
				this.date.epochTime+=86400;
			}
			this.date.epochTime+=CONSTANTS.monthsMap.get(i)*86400;
		}
		this.date.epochTime+=(this.date.getDate())*86400;
	}
	
	/** 
	 * returns if the year is Leapyear
	 * @param yyyy year entered
	 */
	public boolean isLeapYear(int yyyy) {
		if(yyyy%400==0 || (yyyy%4==0 && yyyy%100!=0)) {
			return true;
		}
		return false;
	}
	
	/**
	 * returns the number of days between two dates
	 * @param obj a Calendar object
	 */
	public long getNumberOfDays(Calendar obj) {
		if(!obj.date.isNormalized()) {
			obj.computeEpoch();
		}
		if(!this.date.isNormalized()) {
			this.computeEpoch();
		}
		return (long) getEpochDifference(obj.date)/86400;
		
	}
	
}

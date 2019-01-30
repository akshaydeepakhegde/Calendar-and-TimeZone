package com.randstand.cal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Demo class is user-interactive test class which represents the entire application.
 * 
 * @author Akshay_Hegde
 *
 */

public class Demo {
	
	static Scanner scanner;
	
	/**
	 * Main function to launch the application.
	 * 
	 */
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int cmd = 0;
		while(true) {
			System.out.println("Press 1 to find the number of days between any two date.");
			System.out.println("Press 2 to calculate the timezones between any two zones.");
			System.out.println("Press 3 to exit.");
			if(scanner.hasNext())
				cmd = scanner.nextInt();
			if(cmd == 3)
				break;
			switch(cmd) {
			case 1: CalendarMethod();break;
			case 2: TimeZoneMethod();break;
			default: System.out.println("Error in input.");
			}
		}
		scanner.close();
		
	}
	
	/**
	 *  Helper function to compute number of timezones between any two timezones.
	 */
	
	public static void TimeZoneMethod() {
		System.out.println(Timezone.getAllZones().toString());
		System.out.println("Please enter the zone1 from the list above.");
		boolean incorrectInput = true;
		Timezone h1=null,h2=null;
		while(incorrectInput) {
			try {
				h1 = TimezoneHelper.getInstance(scanner.next());
				incorrectInput = false;
			} catch (TimezoneException e) {
				System.out.println(e.getMessage());
			}
		}
		incorrectInput = true;
		System.out.println("Please enter the zone2 from the list above.");
		while(incorrectInput) {
			try {
				h2 = TimezoneHelper.getInstance(scanner.next());
				incorrectInput = false;
			} catch (TimezoneException e) {
				System.out.println(e.getMessage());
			}
		}
		ArrayList<String> list = TimezoneHelper.getTimeZonesBetween(h1, h2);
		System.out.println("There are "+list.size()+" timezones.");
		System.out.println("And the timezones are "+list);
	}
	
	/**
	 * Helper function to compute the number of days between any 2 dates 
	 * without using the Java Date/Calendar classes for computation
	 */
	
	public static void CalendarMethod() {
		System.out.println("Please enter the date-1 in mm/dd/yyyy format.");
		Calendar d1 = null;
		try {
			d1 = new Calendar(scanner.next());
		} catch (InvalidDateFormatException e) {
			e.printStackTrace();
		}
		System.out.println("Please enter the date-2 in mm/dd/yyyy format.");
		Calendar d2 = null;
		try {
			d2 = new Calendar(scanner.next());
		} catch (InvalidDateFormatException e) {
			e.printStackTrace();
		}
		System.out.println("Number of Days = "+d2.getNumberOfDays(d1));
	}

}

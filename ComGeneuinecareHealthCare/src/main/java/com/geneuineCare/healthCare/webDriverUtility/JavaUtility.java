package com.geneuineCare.healthCare.webDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random randomInt = new Random();
		int randomNum = randomInt.nextInt(1000);
		return randomNum;

	}

	public String getSystemDateYYMMDD() {
		Date dateObj = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String currentData = simple.format(dateObj);
		return currentData;
	}

	public String getRequiredDateYYMMDD(int days) {
		Date dateObj = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String date = simple.format(dateObj);
		Calendar cal = simple.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate = simple.format(cal.getTime());
		return reqDate;

	}
}

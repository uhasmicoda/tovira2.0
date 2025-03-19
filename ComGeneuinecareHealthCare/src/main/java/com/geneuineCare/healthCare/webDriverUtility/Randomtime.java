package com.geneuineCare.healthCare.webDriverUtility;

import java.util.Random;

public class Randomtime {

	public static String getRandomTime12HourFormat() {
        Random random = new Random();
        int hour = random.nextInt(12) + 1;  // Generate random hour (1-12)
        int minute = random.nextInt(60);    // Generate random minute (0-59)
        String period = random.nextBoolean() ? "AM" : "PM";  // Randomly choose AM or PM

        // Format as HH:MM AM/PM
        return String.format("%02d:%02d %s", hour, minute, period);
    }

    public static void main(String[] args) {
        System.out.println("Random Time: " + getRandomTime12HourFormat());
    }
}

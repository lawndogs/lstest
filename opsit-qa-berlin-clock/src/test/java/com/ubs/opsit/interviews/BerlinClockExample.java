package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.clock.BerlinClock;

public class BerlinClockExample {

	public static void main(String[] args) {
		BerlinClock clock = new BerlinClock("21:21:21");
		clock.printTime();
		clock.setMinutes(0).setSeconds(0);
		clock.printTime();
	}
}

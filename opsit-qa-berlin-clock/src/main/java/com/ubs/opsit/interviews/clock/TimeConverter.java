package com.ubs.opsit.interviews.clock;

class TimeConverter {

	/*
	 * Parses a string object, e.g. time = "13:17:01" and extracts Hours=13,
	 * Minutes=17 and Seconds=1
	 */

	private int hours;
	private int minutes;
	private int seconds;

	public TimeConverter(String time) {
		try {
			hours = Integer.valueOf(time.split(":")[0]);
			minutes = Integer.valueOf(time.split(":")[1]);
			seconds = Integer.valueOf(time.split(":")[2]);
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(e + ". Time should be in format hh:mm:ss.");
		}
	}

	public int getHour() {
		return hours;
	}

	public int getMinute() {
		return minutes;
	}

	public int getSecond() {
		return seconds;
	}
}

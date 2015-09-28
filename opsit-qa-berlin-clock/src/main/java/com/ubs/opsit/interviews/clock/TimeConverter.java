package com.ubs.opsit.interviews.clock;

class TimeConverter {
	
	/*
	 * Parses a string object, e.g. time = "13:17:01" and extracts Hours=13, Minutes=17 and Seconds=1 
	 */
	
	private String time;
	public TimeConverter(String time) {
		this.time = time;
	}
	public int getHour() {
		return Integer.valueOf(time.split(":")[0]);
	}
	public int getMinute() {
		return Integer.valueOf(time.split(":")[1]);	
	}
	public int getSecond() {
		return Integer.valueOf(time.split(":")[2]);	
	}
}

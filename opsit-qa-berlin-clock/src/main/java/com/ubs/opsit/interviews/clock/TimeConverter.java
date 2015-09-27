package com.ubs.opsit.interviews.clock;

class TimeConverter {
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

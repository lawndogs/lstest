package com.ubs.opsit.interviews.clock;

public class BerlinClock {

	private char[][] dial = { { 'O' }, // seconds
			{ 'O', 'O', 'O', 'O' }, // hours
			{ 'O', 'O', 'O', 'O' }, // hours
			{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, // minutes
			{ 'O', 'O', 'O', 'O' } // minutes
	};

	public BerlinClock() {}
	
	public BerlinClock(String time) {
		TimeConverter tc = new TimeConverter(time);
		setHours(tc.getHour());
		setMinutes(tc.getMinute());
		setSeconds(tc.getSecond());
	}
	
	public BerlinClock(int hours, int minutes, int seconds) {
		setHours(hours);
		setMinutes(minutes);
		setSeconds(seconds);
	}

	
	/**
	 * Sets number of hours to be displayed in Berlin Clock dial/clock face
	 * 
	 * @param   number of hours to be displayed
	 * @return  reference to the current Berlin Clock object
	 */
	public BerlinClock setHours(int hours) {
        if (hours < 0 || hours > 24) {
        	throw new IllegalArgumentException("Invalid hours number. The value should be within the range 0 - 24");
        }

		for (int i = 0; i < 4; i++) {
			if (hours / ((i + 1) * 5) > 0) {
				dial[1][i] = LampColor.RED;
			} else {
				dial[1][i] = LampColor.BLACK;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (hours % 5 > i) {
				dial[2][i] = LampColor.RED;
			} else {
				dial[2][i] = LampColor.BLACK;
			}
		}
		return this;
	}

	
	/**
	 * Sets minutes of hours to be displayed in Berlin Clock dial/clock face
	 * 
	 * @param   number of minutes to be displayed
	 * @return  reference to the current Berlin Clock object
	 */
	public BerlinClock setMinutes(int minutes) {
		if (minutes < 0 || minutes > 59) {
        	throw new IllegalArgumentException("Invalid minutes number. The value should be within the range 0 - 59");
        }
		
		for (int i = 0; i < 11; i++) {
			if (minutes / ((i + 1) * 5) > 0) {
				if (i == 2 || i == 5 || i == 8) { // Quarters
					dial[3][i] = LampColor.RED;
				} else {
					dial[3][i] = LampColor.YELLOW;
				}
			} else {
				dial[3][i] = LampColor.BLACK;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (minutes % 5 > i) {
				dial[4][i] = LampColor.YELLOW;
			} else {
				dial[4][i] = LampColor.BLACK;
			}
		}
		return this;
	}
	
	
	/**
	 * Sets seconds status to be displayed in Berlin Clock dial/clock face
	 * 
	 * @param   number of seconds
	 * @return  reference to the current Berlin Clock object
	 */
	public BerlinClock setSeconds(int seconds) {
		if (seconds < 0 || seconds > 60) {
        	throw new IllegalArgumentException("Invalid seconds number. The value should be within the range 0 - 60");
        }

		if (seconds % 2 > 0) { 
			dial[0][0] = LampColor.BLACK;
		} else { 
			dial[0][0] = LampColor.YELLOW;
        }
		return this;
	}
	
	
	/**
	 * @return  set of elements (chars array) which represents current state of  Berlin Clock object
	 */
	public char[][] getLampsColor() {
		return dial;
	}
	
	
	/**
	 * Prints time in the format of Berlin Clock
	 * 
	 * Example:
     *  Y
     *  OOOO
     *  OOOO
     *  OOOOOOOOOOO
     *  OOOO
	 */
	public void printTime() {
		System.out.println(toString());
	}
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n" + new String(dial[0]));
		sb.append("\n" + new String(dial[1]));
		sb.append("\n" + new String(dial[2]));
		sb.append("\n" + new String(dial[3]));
		sb.append("\n" + new String(dial[4]));
		return sb.toString();
	}
}

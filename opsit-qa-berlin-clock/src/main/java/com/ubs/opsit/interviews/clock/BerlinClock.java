package com.ubs.opsit.interviews.clock;

public class BerlinClock {
	
	private char[][] dial = { { 'O' }, // seconds
			{ 'O', 'O', 'O', 'O' }, // hours
			{ 'O', 'O', 'O', 'O' }, // hours
			{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, // minutes
			{ 'O', 'O', 'O', 'O' } // minutes
	};

	public BerlinClock() {}

	
	public BerlinClock setHours(int hours) {
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

	public BerlinClock setMinutes(int minutes) {
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

	public BerlinClock setSeconds(int seconds) {
		if (seconds % 2 > 0) { 
			dial[0][0] = LampColor.BLACK;
		} else { 
			dial[0][0] = LampColor.YELLOW;
        }
		return this;
	}

	public char[][] getLampsColor() {
		return dial;
	}

	interface LampColor {
		public char RED = 'R';
		public char YELLOW = 'Y';
		public char BLACK = 'O';
	}
}

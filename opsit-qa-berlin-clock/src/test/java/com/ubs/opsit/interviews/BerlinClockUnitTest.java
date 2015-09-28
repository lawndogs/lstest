package com.ubs.opsit.interviews;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import com.ubs.opsit.interviews.clock.BerlinClock;
import static org.junit.Assert.*;

public class BerlinClockUnitTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	
	/*
	 * Set clock at 00:00:00
	 */
	@Test
	public void setTimeMidnight00() {
		char[][] expected = { { 'Y' }, // seconds
				{ 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O' }, // hours
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O' } }; // minutes

		BerlinClock clock = new BerlinClock().setHours(0).setMinutes(0).setSeconds(0);
		assertArrayEquals(expected, clock.getLampsColor());
	}

	
	/*
	 * Set clock at 24:00:00
	 */
	@Test
	public void setTimeMidnight24() {
		char[][] expected = { { 'Y' }, { 'R', 'R', 'R', 'R' }, { 'R', 'R', 'R', 'R' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O' } };

		BerlinClock clock = new BerlinClock("24:00:00");
		assertArrayEquals(expected, clock.getLampsColor());
	}

	
	/*
	 * Set clock at 13:17:01
	 */
	@Test
	public void setTimeAfterNoon() {
		char[][] expected = { { 'O' }, { 'R', 'R', 'O', 'O' }, { 'R', 'R', 'R', 'O' },
				{ 'Y', 'Y', 'R', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'Y', 'Y', 'O', 'O' } };
		
		BerlinClock clock = new BerlinClock("13:17:01");
		assertArrayEquals(expected, clock.getLampsColor());
	}

	
	/*
	 * Set clock at 23:59:59
	 */
	@Test
	public void setTimeBeforeMidnight() {
		char[][] expected = { { 'O' }, { 'R', 'R', 'R', 'R' }, { 'R', 'R', 'R', 'O' },
				{ 'Y', 'Y', 'R', 'Y', 'Y', 'R', 'Y', 'Y', 'R', 'Y', 'Y' }, { 'Y', 'Y', 'Y', 'Y' } };

		BerlinClock clock = new BerlinClock().setHours(23).setMinutes(59).setSeconds(59);
		assertArrayEquals(expected, clock.getLampsColor());
	}

	
	/*
	 * Invalid time - negative hours
	 */
	@Test 
	public void setTimeInvalidHours() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid hours number. The value should be within the range 0 - 24");
		new BerlinClock().setHours(-1);
	}

	
	/*
	 *  Invalid time - number of minutes exceed allowed number
	 */
	@Test
	public void setTimeInvalidMinutes() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid minutes number. The value should be within the range 0 - 59");
		new BerlinClock().setMinutes(60);
	}

	
	/*
	 *  Invalid time - negative hours 
	 */
	@Test
	public void setTimeNegativeSeconds() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid seconds number. The value should be within the range 0 - 60");
		new BerlinClock().setSeconds(-1);
	}
}

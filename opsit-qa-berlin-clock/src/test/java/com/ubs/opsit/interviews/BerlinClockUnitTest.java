package com.ubs.opsit.interviews;

import org.junit.Test;

import com.ubs.opsit.interviews.clock.BerlinClock;
import static org.junit.Assert.*;

public class BerlinClockUnitTest {

	/*
	 * set clock at 00:00:00
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
	 * set clock at 24:00:00
	 */
	@Test
	public void setTimeMidnight24() {
		char[][] expected = { { 'Y' }, { 'R', 'R', 'R', 'R' }, { 'R', 'R', 'R', 'R' },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O' } };

		BerlinClock clock = new BerlinClock().setHours(24).setMinutes(0).setSeconds(0);
		assertArrayEquals(expected, clock.getLampsColor());

	}

	/*
	 * set clock at 13:17:01
	 */
	@Test
	public void setTimeAfterNoon() {
		char[][] expected = { { 'O' }, { 'R', 'R', 'O', 'O' }, { 'R', 'R', 'R', 'O' },
				{ 'Y', 'Y', 'R', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'Y', 'Y', 'O', 'O' } };
		
		BerlinClock clock = new BerlinClock().setHours(13).setMinutes(17).setSeconds(1);
		assertArrayEquals(expected, clock.getLampsColor());
	}

	/*
	 * set clock at 23:59:59
	 */
	@Test
	public void setTimeBeforeMidnight() {
		char[][] expected = { { 'O' }, { 'R', 'R', 'R', 'R' }, { 'R', 'R', 'R', 'O' },
				{ 'Y', 'Y', 'R', 'Y', 'Y', 'R', 'Y', 'Y', 'R', 'Y', 'Y' }, { 'Y', 'Y', 'Y', 'Y' } };

		BerlinClock clock = new BerlinClock().setHours(23).setMinutes(59).setSeconds(59);
		assertArrayEquals(expected, clock.getLampsColor());
	}

}

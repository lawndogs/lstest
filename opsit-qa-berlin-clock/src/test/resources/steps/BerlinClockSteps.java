package steps;

import static org.junit.Assert.assertArrayEquals;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;

import com.ubs.opsit.interviews.clock.BerlinClock;

public class BerlinClockSteps {

	private BerlinClock clock;

	@Given("it's $time o'clock now")
	public void givenTime(String time) {
		clock = new BerlinClock(time);
	}

	@Then("the Berlin Uhr looks like: $example")
	public void thenTheBerlinUhrLooks(ExamplesTable example) {
        assertArrayEquals(getLampsColorExample(example, 0), clock.getLampsColor()[0]); // seconds
        assertArrayEquals(getLampsColorExample(example, 1), clock.getLampsColor()[1]); // hours
        assertArrayEquals(getLampsColorExample(example, 2), clock.getLampsColor()[2]); // hours
        assertArrayEquals(getLampsColorExample(example, 3), clock.getLampsColor()[3]); // minutes
        assertArrayEquals(getLampsColorExample(example, 4), clock.getLampsColor()[4]); // minutes
	}
	
	private char[] getLampsColorExample(ExamplesTable example, int index) {
		return example.getRow(index).get("Berlin Uhr").toCharArray();
	}
}

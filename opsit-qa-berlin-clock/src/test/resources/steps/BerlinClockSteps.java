package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;

public class BerlinClockSteps {

	@Given("it's $time o'clock now")
	public void givenTime(String time) {
	}
	
	@Then("the Berlin Uhr looks like: $example")
	public void thenTheBerlinUhrLooks(ExamplesTable example) {
	}
}

package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StepsGet {
	private static final String HTTPS_MY_JSON_SERVER = "https://my-json-server.typicode.com/franramos95/serveJson/users/{user}";
	JsonPath test;
	String name = null;
	String username = null;
	String email = null;
	String catchPhrase = null;
	Integer user;

	@Given("^I want to see user (\\d+)$")
	public void i_want_to_see_user(int userId) throws Throwable {
		user = userId;
	}

	@When("^I call the api get with the ID of the user$")
	public void i_call_the_api_get_with_the_ID_of_the_user() throws Throwable {
		test = RestAssured.given().when().log().all().get(HTTPS_MY_JSON_SERVER, user).andReturn().jsonPath();
	}

	@Then("^the Api return the information$")
	public void the_Api_return_the_information() throws Throwable {
		// System.out.println(test.getJsonObject());

		name = test.getJsonObject("name");
		username = test.getJsonObject("username");
		email = test.getJsonObject("email");

	}

	@Then("^we verify if has name, username and email$")
	public void we_verify_if_has_name_username_and_email() throws Throwable {
		assertNotNull(name);
		assertNotNull(username);
		assertNotNull(email);
	}

	@Then("^we verify the email if is valid$")
	public void we_verify_the_email_if_is_valid() throws Throwable {
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailIdValid = true;
			}
		}

		assertEquals(true, isEmailIdValid);
	}

	@Then("^we verify if catchphrase must have less than (\\d+) characters$")
	public void we_verify_if_catchphrase_must_have_less_than_characters(int arg1) throws Throwable {
		catchPhrase = test.getJsonObject("company.catchPhrase");
		assertTrue(catchPhrase.length() < 50);
	}

}

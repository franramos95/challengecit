package steps;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepsPost {
	private static final String HTTPS_SERVE_JSON_POSTS = "https://my-json-server.typicode.com/franramos95/serveJson/posts";
	Response test;
	Integer userId;

	@Given("^I want to write post using user (\\d+)$")
	public void i_want_to_write_post_using_user(int user) throws Throwable {
		userId = user;
	}

	@When("^I call the Api put the title (.*)$")
	public void i_call_the_Api_put_the_title(String title) throws Throwable {
		test = RestAssured.given().when().log().all().body("{\"userId\":"+userId+",\"id\": 1,\"body\": \"bodyTest\",\"title\": "+title+"}")
				.post(HTTPS_SERVE_JSON_POSTS);
	}

	@Then("^I verify the (201|400) of the post$")
	public void i_verify_the_status_of_the_post(int status) throws Throwable {
		status = test.getStatusCode();
		
		assertEquals((201|400), status);
	}

}

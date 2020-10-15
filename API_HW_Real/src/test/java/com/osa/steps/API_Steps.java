package com.osa.steps;
import java.util.List;
import org.openqa.selenium.WebDriver;
import com.osa.Utilities.Utility;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class API_Steps {
	public static WebDriver dr;
	public static Response res;

	@Given("^I am authenticating the user$")
	public void I_am_authenticating_the_user() throws Throwable {
		System.out.println("---------------------------------------------------------");

		System.out.println("Authenticated");
	}

	@When("^I send a \"([^\"]*)\" call by using \"([^\"]*)\" I get the information for that user$")
	public void i_send_a_call_by_using_I_get_the_information_for_that_user(String arg1, String arg2) throws Throwable {
		res = Utility.myGET(arg1, arg2);
		res.prettyPrint();
		System.out.println("--------------------------------------------------------------");
	}

	@Then("^I verify the Response Code$")
	public void i_verify_the_Response_Code(DataTable d) throws Throwable {
		List<List<String>> data = d.raw();
		Utility.verifyCode(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2));
	}

	@Then("^I verify if the information is correct or not$")
	public void i_verify_if_the_information_is_correct_or_not(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		Utility.verifyInfo(data.get(0).get(0), data.get(0).get(1));

	}

}


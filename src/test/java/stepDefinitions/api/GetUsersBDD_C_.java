package stepDefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apiguardian.api.API;
import org.junit.Assert;
import utils.ApiUtils;
import utils.ConfigReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUsersBDD_C_ {

    static {
        RestAssured.baseURI = ConfigReader.getProperty("api_base_uri");
    }

    RequestSpecification requestSpecification = given().
            queryParam("api_key", ConfigReader.getProperty("api_key"));

    @Given("the request is authenticated with a valid API key")
    public void the_request_is_authenticated_with_a_valid_api_key() {

        ApiUtils.setRequestQueryParameter("api_key", ConfigReader.getProperty("api_key"));
//        requestSpecification = given().
//                queryParam("api_key", ConfigReader.getProperty("api_key"));

    }


    @Given("the {string} header is set to {string}")
    public void the_header_is_set_to(String key, String value) {

        ApiUtils.setRequestHeader(key, value);
    }

    @When("I send a {string} request to the endpoint {string}")
    public void i_send_a_request_to_the_endpoint(String rmethod, String endPoint) {

        ApiUtils.sendRequest(rmethod, endPoint);
    }

    @Then("the response log should be displayed")
    public void the_response_log_should_be_displayed() {

        ApiUtils.displayResponseLog();

    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {

        ApiUtils.verifyResponseStatusCode(statusCode);

    }

    @Then("the response {string} header should be {string}")
    public void the_response_header_should_be(String key, String value) {

        ApiUtils.verifyResponseHeader(key, value);
    }

    @Then("the response should contain a list of all users with the following fields")
    public void the_response_should_contain_a_list_of_all_users_with_the_following_fields(List<String> expectedKeys) {


        Response response = ApiUtils.getResponse();

//        Response response = (Response) requestSpecification;
        Map<String, Object> map = response.jsonPath().getMap("[0]");

        Set<String> strings = map.keySet();

        List<String> actualKeys = new ArrayList<>(strings);

        Assert.assertEquals(expectedKeys, actualKeys);

    }

    @Then("the response should not contain any sensitive information")
    public void the_response_should_not_contain_any_sensitive_information() {

        Assert.assertTrue(!ApiUtils.getResponse().jsonPath().getMap("[0]").containsKey("password"));
        ApiUtils.getResponse().then().body("[0]", not(hasKey("password")));


    }
    @Then("the response time should be less than {int} ms")
    public void the_response_time_should_be_less_than_ms(Integer ms) {
        ApiUtils.verifyResponseTime(ms);
//
    }


    @Given("the request is not authenticated with a valid API key")
    public void theRequestIsNotAuthenticatedWithAValidAPIKey() {
        requestSpecification = given().
                queryParam("api_key", ConfigReader.getProperty("api_ke"));
    }

    @Then("the response body key {string} should be {string}")
    public void the_response_body_key_should_be(String key, String value) {

        ApiUtils.verifyBasicResponseBody(key, value);

    }

    //get /user endpoint
    @Given("the {string} query parameter is set to {string}")
    public void the_query_parameter_is_set_to(String key, String value) {
        ApiUtils.setRequestQueryParameter(key, value);


    }



}


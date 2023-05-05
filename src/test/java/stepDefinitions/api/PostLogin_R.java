package stepDefinitions.api;

import stepDefinitions.Endpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import utils.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class PostLogin_R {
    Response response;

    @Given("The Base URI is set")
    public void the_base_uri_is_set() {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
    }

    @When("I send a Post request to {string} endpoint with the following information")
    public void i_send_a_post_request_to_endpoint_with_the_following_information(String endpoint, Map<String,String> dataTable) {
        String email= dataTable.get("email");
        String password =  dataTable.get("password");
        response = given().
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                header("Accept", "application/vnd.api+json").
                contentType(ContentType.JSON).
                body("{\n" +
                        "  \"email\" : \""+email+"\",\n" +
                        "  \"password\" : \""+password+"\" ,\n" +
                        "}").
                when().log().all().
                post(endpoint);
    }
    @Then("the response should contain the following data")
    public void the_response_should_contain_the_following_data(Map<String,String> dataTable) {
        response.then(). log().all().
                statusCode(200).
                header("Content-Type", dataTable.get("Content-Type")).
                header("Server", dataTable.get("Server"));
    }


    @When("I send a POST request to the endpoint with existing credentials")
    public void i_send_a_post_request_to_the_endpoint_with_existing_credentials() {

        response = given().
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                header("Accept", "application/vnd.api+json").
                contentType(ContentType.JSON).
                body("{\n" +
                        "    \"email\": \"herc@mail.com\",\n" +
                        "    \"password\":\"Dhsjjfhdsf23*\"\n" +
                        "}").
                when().log().all().
                post(String.valueOf(Endpoints.LOGIN));


    }
    @Then("I verify the status code")
    public void i_verify_the_status_code() {
        response.then().log().all().
                statusCode(200);
    }


    @Then("the return response should be less that 1000ms")
    public void the_return_response_should_be_less_that_1000ms() {
        response.then().log().all().
                time(lessThan(1000L));
    }


    @When("I send a Post request to the endpoint with wrong credentials")
    public void iSendAPostRequestToTheEndpointWithWrongCredentials() {
        response = given().
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                header("Accept", "application/json").
                contentType(ContentType.JSON).
                body("{\n" +
                        "  \"email\": \"Jddty@gmail.com\",\n" +
                        "  \"password\": \"qwerty\",\n" +
                        "}").
                when(). log().all().
                post(String.valueOf(Endpoints.LOGIN));

    }

    @Then("The response should contain an error message")
    public void theResponseShouldContainAnErrorMessage() {

        response.then(). log().all().

                header("Content-Type", "application/json; charset=UTF-8").
                header("connection", "keep-alive").
                body("status", Matchers.equalTo(422)).
                body("message", Matchers.equalTo("Please fill in all required fields!"));

    }

}

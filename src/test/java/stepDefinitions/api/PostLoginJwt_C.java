package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.ApiUtils;
import utils.ConfigReader;

public class PostLoginJwt_C {
    @Given("the body has the existing username and password")
    public void the_body_has_the_existing_username_and_password() {


        String body = "{\n" +
                "  \"email\": \""+ ConfigReader.getProperty("usernamejwt") +"\",\n" +
                "  \"password\": \""+ConfigReader.getProperty("passwordjwt")+"\"\n" +
                "}" ;
        ApiUtils.setRequestBody(body);


    }

    @Then("the JWT is set")
    public void the_jwt_is_set() {
        ApiUtils.setJWTToken();
    }

    @Then("the response body key {string} should be true")
    public void the_response_body_key_should_be_true(String key) {
        ApiUtils.verifyBasicResponseBody(key,true);
    }


}

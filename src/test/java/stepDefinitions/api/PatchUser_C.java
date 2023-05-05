package stepDefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utils.ApiUtils;

import java.util.Map;

public class PatchUser_C {

    @And("the body is set to for Patch")
    public void theBodyIsSetToForPatch() {

        ApiUtils.setRequestBody("{\n" +
                "  \"first_name\": \"Cool\",\n" +
                "  \"last_name\": \"Herc\",\n" +
                "  \"email\": \"herc@mail.com\",\n" +
                "}");
    }

    @And("the body is set to SUCCES Patch")
    public void theBodyIsSetToSUCCESPatch() {

        ApiUtils.setRequestBody("{\n" +
                "  \"first_name\": \"Cool\",\n" +
                "  \"last_name\": \"Herc\",\n" +
                "  \"email\": \"herc@mail.com\",\n" +
                "  \"type\": \"2\",\n" +
                "  \"active\": \"1\"\n" +
                "}");
    }

    @Given("the body is set to SUCCES Patch following map")
    public void the_body_is_set_to_the_following_map( Map<String, String> payload) {

        ApiUtils.setRequestBody(payload);

    }
}


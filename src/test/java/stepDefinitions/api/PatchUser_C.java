package stepDefinitions.api;

import io.cucumber.java.en.And;
import utils.ApiUtils;

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
}


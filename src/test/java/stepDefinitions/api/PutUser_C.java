package stepDefinitions.api;

import io.cucumber.java.en.And;
import utils.ApiUtils;

public class PutUser_C {

    @And("the body is set to")
    public void theBodyIsSetTo() {


        ApiUtils.setRequestBody("{\n" +
                "                                     \"username\": \"coolherc\",\n" +
                "                                     \"first_name\": \"Cool\",\n" +
                "                                     \"last_name\": \"Herc\",\n" +
                "                                     \"email\": \"new_email_address@mail.com\"\n" +
                "                                   }");
    }
}
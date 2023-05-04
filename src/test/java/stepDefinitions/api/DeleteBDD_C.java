package stepDefinitions.api;

import io.cucumber.java.en.Given;
import utils.ApiUtils;

public class DeleteBDD_C {

    Integer userId;
    @Given("the USER is creted and the id")
    public void the_user_is_creted_and_the_id() {

        userId = ApiUtils.getResponse().path("user_id");
    }
    @Given("the {string} query parameter is set to new id")
    public void the_query_parameter_is_set_to_new_id(String key) {

        ApiUtils.setRequestQueryParameter(key, userId );

    }
}

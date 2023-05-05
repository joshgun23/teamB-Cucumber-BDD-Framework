package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.ApiUtils;
import utils.ConfigReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GetApplications_C {
    @Given("the {string} header is set to JWT token obtained through login endpoint")
    public void the_header_is_set_to_jwt_token_obtained_through_post_login_endpoint(String key) {


        String jwtToken = ApiUtils.getJWTToken();

        ApiUtils.setRequestHeader(key, jwtToken );
    }


    @Then("the owner of all application should be correct")
    public void the_owner_of_all_playlists_should_be_correct() {


        Object  application = ApiUtils.getResponse().path("application_details.b_dob");

        System.out.println(application);

        String expectedOwner = ConfigReader.getProperty("username");

        if (application instanceof List) {
            List<String> applicationList = (List<String>) application;
            for (String owner : applicationList) {
                Assert.assertEquals(expectedOwner, owner);
            }
        } else if (application instanceof String) {
            String applicationString = (String) application;}



    }

    @Then("the all playlists should be created_on time")
    public void the_all_playlists_should_be_sorted_in_descending_order() {


        Object response = ApiUtils.getResponse().path("application_details.created_on");

        List<LocalDateTime> actual;
        if (response instanceof String) {
            String dateString = (String) response;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            actual = Collections.singletonList(LocalDateTime.parse(dateString, formatter));
        } else {
            actual = (List<LocalDateTime>) response;
        }

        System.out.println(actual);
        List<LocalDateTime> expected = new ArrayList<>(actual);
        expected.sort(Comparator.reverseOrder());
        System.out.println(expected);
        Assert.assertEquals(expected, actual);


    }
}

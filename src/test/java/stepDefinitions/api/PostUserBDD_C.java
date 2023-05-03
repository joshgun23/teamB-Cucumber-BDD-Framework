package stepDefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import utils.ApiUtils;

public class PostUserBDD_C {

    String username = new Faker().name().username();
    String email = new Faker().internet().emailAddress();
    String firstName = new Faker().name().firstName();
    @Given("the body is added")
    public void the_body_is_added() {


//       requestSpecification.body("{\n" +
//                "  \"username\": \""+username+" \", \n" +
//                "  \"first_name\": \""+firstName+"\",\n" +
//                "  \"last_name\": \"Herc\",\n" +
//                "  \"email\": \""+email+"\",\n" +
//                "  \"password\": \"Dhsjjfhdsf23*\"\n" +
//                "}");


        ApiUtils.setRequestBody("{\n" +
                "  \"username\": \"" + username + " \", \n" +
                "  \"first_name\": \"" + firstName + "\",\n" +
                "  \"last_name\": \"Herc\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"Dhsjjfhdsf23*\"\n" +
                "}");

    }
}

package stepDefinitions.api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.junit.Test;
import stepDefinitions.pojos.TeamB_User;
import utils.ConfigReader;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SerializationAndDesirialization {

    static {
        RestAssured.baseURI = ConfigReader.getProperty("api_base_uri");
    }

    @Test
    public void serializeUsingString(){


        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();

        String firstName = new Faker().name().firstName();

        given().

                queryParam("api_key", ConfigReader.getProperty("api_key")).
                body("{\n" +
                        "  \"username\": \"" + username + " \", \n" +
                        "  \"first_name\": \"" + firstName + "\",\n" +
                        "  \"last_name\": \"Herc\",\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"password\": \"Dhsjjfhdsf23*\"\n" +
                        "}").
                when().log().all().
                post("/user").
                then().log().all().
                assertThat().
                statusCode(201);

    }
    @Test
    public void serializeUsingMap(){

        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();

        Map<String, String > payload =  new LinkedHashMap<>();
        payload.put("username",username);
        payload.put("first_name",firstName);
        payload.put("last_name",lastName);
        payload.put("email",email);
        payload.put("password","Dhsjjfhdsf23*");

        given().
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                body(payload).
                when().
                log().all().
                post("/user").
                then().
                log().all().
                assertThat().
                statusCode(201);

    }

    public void serializeUsingList(){


        List<String> body = List.of("Onur23", "Kevin", "josh", "ishdjsahj@gmail.com", "a*");

        given().
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                body(body).
                when().
                log().all().
                post("/user").
                then().
                log().all().
                assertThat().
                statusCode(201);

    }

    @Test
    public void serializeUsingPojo(){

        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();

        TeamB_User teamB_user = new TeamB_User(username,firstName,lastName,email,"Dhsjjfhdsf23*");


        given().
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                body(teamB_user).
                when().
                log().all().
                post("/user").
                then().
                log().all().
                assertThat().
                statusCode(201);

    }
    @Test
    public void serializeUsingPojoPut(){

        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();


        TeamB_User teamB_user = new TeamB_User();

        teamB_user.setUsername(username);
        teamB_user.setFirst_name(firstName);
        teamB_user.setLast_name(lastName);
        teamB_user.setEmail(email);

        given().
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                queryParam("id", 392).
                body(teamB_user).
                when().
                log().all().
                put("/user").
                then().
                log().all().
                assertThat().
                statusCode(200);

    }
    @Test
    public void serializeUsingPayloadFile(){

        given().
                queryParam("api_key", ConfigReader.getProperty("api_key")).
                queryParam("id", 392).
                body(new File("src/test/java/stepDefinitions/pojos/patchUserPayload_C.json")).
                when().
                log().all().
                put("/user").
                then().
                log().all().
                assertThat().
                statusCode(200);

    }

}

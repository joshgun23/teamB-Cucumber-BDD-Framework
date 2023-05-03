package stepDefinitions.api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;
import utils.ConfigReader;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetUser_C {


    static {
        RestAssured.baseURI = ConfigReader.getProperty("api_base_uri");
    }
    RequestSpecification requestSpecification = given().
            header("Content-Type", "application/json").queryParam("api_key", ConfigReader.getProperty("api_key"));
    @Test
    public void getTestNg(){

//          given().log().all().
//                  header("Content-Type","application/json").queryParam("api_key","c8a912d7d1c5a5a99c508f865b5eaae14a5b484f5bfe2d8f48c40e46289b47f3").
//                  //queryParam("id","45").
//          when().log().all().
//                 get("/users").
//
//          then().log().all().
//               //statusCode(200);
//                 statusCode(equalTo(200));



        Response response = requestSpecification.when().log().all().
                get("/users");

         response.then().log().all().
                //statusCode(200);
                        statusCode(equalTo(200)).
                 time(lessThan(1000l));

    }
    String username = new Faker().name().username();
    String email = new Faker().internet().emailAddress();

    String firstName = new Faker().name().firstName();

    @Test
    public void postTestNg(){



        Response response1 = requestSpecification.body("{\n" +
                "  \"username\": \""+username+" \", \n" +
                "  \"first_name\": \""+firstName+"\",\n" +
                "  \"last_name\": \"Herc\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"password\": \"Dhsjjfhdsf23*\"\n" +
                "}").
                when().
                       post("/user");



        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(201)).
                body("status",is(1)).
                body("message",is("The user has been created.")).extract().response();

        Object user_id = response1.path("user_id");


        //verify user creation

         requestSpecification.queryParam("id",user_id).
                 when().log().all().
                 get("/user").
                 then().log().all().
                 assertThat().
                 statusCode(200).
                 body("first_name",equalTo(firstName)).
                 body("email",equalTo(email));


    }
    @Test
    public void putTestNgNeqativ(){

        Response response1 = requestSpecification.
                queryParam("id","390").
                body(
                        "first_name\": \"Cool28.5\"," +
                        "  \"last_name\": \"Herc\",\n" +
                        "  \"email\": \"herc66@mail.com\"").when().
                put("/user");

        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(422));

    }
    @Test
    public void putTestNg(){

        Response response1 = requestSpecification.queryParam("id","390").body(
                        "  {\n" +
                                "  \"username\": \""+username+" \", \n" +
                                "  \"first_name\": \""+firstName+"\",\n" +
                                "  \"last_name\": \"Herc\",\n" +
                                "  \"email\": \""+email+"\",\n" +
                                "  \"password\": \"Dhsjjfhdsf23*\"\n" +
                                "}").when().
                put("/user");


        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(200));

        requestSpecification.queryParam("id","390").
                when().log().all().
                get("/user").
                then().log().all().
                assertThat().
                statusCode(200).
                body("first_name",equalTo(firstName)).
                body("email",equalTo(email));

    }

    @Test
    public void patchInvalidormissingdata(){

        Response response1 = requestSpecification.queryParam("id","390").body(
                        "  {\n" +
                                "  \"username\": \""+username+" \", \n" +
                                "}").when().
                patch("/user");

        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(400)).
                body("message",is("Invalid or missing data"));;

    }
    @Test
    public void patchTestNg(){

        Response response1 = requestSpecification.queryParam("id","390").body(
                        "  {\n" +
                                "  \"first_name\": \"Cool\",\n" +
                                "  \"last_name\": \"Herc\",\n" +
                                "  \"email\": \""+email+"\",\n"  +
                                "  \"type\": \"2\",\n" +
                                "  \"active\": \"1\"\n" +
                                "}").when().
                patch("/user");

        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(200)).
                body("message", is("User updated successfully"));

    }
    @Test
    public void deleteUsers(){
        Response response1 = requestSpecification.body("{\n" +
                        "  \"username\": \""+username+" \", \n" +
                        "  \"first_name\": \""+firstName+"\",\n" +
                        "  \"last_name\": \"Herc\",\n" +
                        "  \"email\": \""+email+"\",\n" +
                        "  \"password\": \"Dhsjjfhdsf23*\"\n" +
                        "}").
                when().
                post("/user");



        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(201)).body("status",is(1)).
                body("message",is("The user has been created.")).extract().response();

        Object user_id = response1.path("user_id");

        //delete user by id

        requestSpecification.queryParam("id",user_id).
                when().log().all().
                delete("/user").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message",is("User deleted successfully")).
                header("content-type","application/json").time(lessThan(1000l));

    }
    @Test
    public void userLoginJwt() {


        Response response1 = requestSpecification.body("{\n" +
                        "  \"email\": \"" + ConfigReader.getProperty("username") + "\",\n" +
                        "  \"password\": \"" + ConfigReader.getProperty("password") + "\"\n" +
                        "}").
                when().
                post("/login");


        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(200)).
                //body("status", is(1)).
                body("message", is("You've successfully logged in!")).extract().response().path("access_token");

        Object access_token = response1.path("access_token");

    }
        @Test
        public void userLoginApplications(){



            Response response1 = requestSpecification.body("{\n" +
                            "  \"email\": \""+ConfigReader.getProperty("username")+"\",\n" +
                            "  \"password\": \""+ConfigReader.getProperty("password")+"\"\n" +
                            "}").
                    when().
                    post("/login");



            response1.then().log().all().
                    assertThat().
                    //statusCode(200);
                            statusCode(equalTo(200)).
                   // body("status",is(1)).
                    body("message",is("You've successfully logged in!")).extract().response().path("access_token");

            Object access_token = response1.path("access_token");

        //verify user creation

        requestSpecification.header("Authorization",access_token).
                when().log().all().
                get("/applications").
                then().log().all().
                assertThat().
                statusCode(200).
                //body("succes",equalTo(1)).
                time(lessThan(1000l));


    }
    @Test
    public void userLoginApplicationsNegativ(){



        Response response1 = requestSpecification.body("{\n" +
                        "  \"email\": \""+ConfigReader.getProperty("username")+"\",\n" +
                        "  \"password\": \""+ConfigReader.getProperty("password")+"\"\n" +
                        "}").
                when().
                post("/login");



        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(200)).
                // body("status",is(1)).
                        body("message",is("You've successfully logged in!")).extract().response().path("access_token");

        Object access_token = response1.path("access_token");

        //verify user creation

        requestSpecification.header("Authorization",access_token).
                when().log().all().
                get("/application").
                then().log().all().
                assertThat().
                statusCode(400).
                //body("succes",equalTo(1)).
                        time(lessThan(1000l));


    }
}

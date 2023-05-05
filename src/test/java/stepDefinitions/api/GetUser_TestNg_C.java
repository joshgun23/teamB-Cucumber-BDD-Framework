package stepDefinitions.api;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import utils.ConfigReader;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUser_TestNg_C {


    static {
        RestAssured.baseURI = ConfigReader.getProperty("api_base_uri");
    }

    RequestSpecification requestSpecification = given().
            header("Content-Type", "application/json").queryParam("api_key", ConfigReader.getProperty("api_key"));

    @Test
    public void getTestNg() {

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
    public void postTestNg() {


        Response response1 = requestSpecification.body("{\n" +
                        "  \"username\": \"" + username + " \", \n" +
                        "  \"first_name\": \"" + firstName + "\",\n" +
                        "  \"last_name\": \"Herc\",\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"password\": \"Dhsjjfhdsf23*\"\n" +
                        "}").
                when().
                post("/user");


        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(201)).
                body("status", is(1)).
                body("message", is("The user has been created.")).extract().response();

        Object user_id = response1.path("user_id");


        //verify user creation

        requestSpecification.queryParam("id", user_id).
                when().log().all().
                get("/user").
                then().log().all().
                assertThat().
                statusCode(200).
                body("first_name", equalTo(firstName)).
                body("email", equalTo(email));


    }

    @Test
    public void putTestNgNeqativ() {

        Response response1 = requestSpecification.
                queryParam("id", "390").
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
    public void putTestNg() {

        Response response1 = requestSpecification.queryParam("id", "390").body(
                        "  {\n" +
                                "  \"username\": \"" + username + " \", \n" +
                                "  \"first_name\": \"" + firstName + "\",\n" +
                                "  \"last_name\": \"Herc\",\n" +
                                "  \"email\": \"" + email + "\",\n" +
                                "  \"password\": \"Dhsjjfhdsf23*\"\n" +
                                "}").when().
                put("/user");


        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(200));

        requestSpecification.queryParam("id", "390").
                when().log().all().
                get("/user").
                then().log().all().
                assertThat().
                statusCode(200).
                body("first_name", equalTo(firstName)).
                body("email", equalTo(email));

    }

    @Test
    public void patchInvalidormissingdata() {

        Response response1 = requestSpecification.queryParam("id", "390").body(
                        "  {\n" +
                                "  \"username\": \"" + username + " \", \n" +
                                "}").when().
                patch("/user");

        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(400)).
                body("message", is("Invalid or missing data"));
        ;

    }

    @Test
    public void patchTestNg() {

        Response response1 = requestSpecification.queryParam("id", "390").body(
                        "  {\n" +
                                "  \"first_name\": \"Cool\",\n" +
                                "  \"last_name\": \"Herc\",\n" +
                                "  \"email\": \"" + email + "\",\n" +
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
    public void deleteUsers() {
        Response response1 = requestSpecification.body("{\n" +
                        "  \"username\": \"" + username + " \", \n" +
                        "  \"first_name\": \"" + firstName + "\",\n" +
                        "  \"last_name\": \"Herc\",\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"password\": \"Dhsjjfhdsf23*\"\n" +
                        "}").
                when().
                post("/user");


        response1.then().log().all().
                assertThat().
                //statusCode(200);
                        statusCode(equalTo(201)).body("status", is(1)).
                body("message", is("The user has been created.")).extract().response();

        Object user_id = response1.path("user_id");

        //delete user by id

        requestSpecification.queryParam("id", user_id).
                when().log().all().
                delete("/user").
                then().log().all().
                assertThat().
                statusCode(200).
                body("message", is("User deleted successfully")).
                header("content-type", "application/json").time(lessThan(1000l));

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
    public void userLoginApplications() {


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
                // body("status",is(1)).
                        body("message", is("You've successfully logged in!")).extract().response().path("access_token");

        Object access_token = response1.path("access_token");

        //verify user creation

        requestSpecification.header("Authorization", access_token).
                when().log().all().
                get("/applications").
                then().log().all().
                assertThat().
                statusCode(200).
                //body("succes",equalTo(1)).
                        time(lessThan(1000l));


    }

    @Test
    public void userLoginApplicationsNegativ() {


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
                // body("status",is(1)).
                        body("message", is("You've successfully logged in!")).extract().response().path("access_token");

        Object access_token = response1.path("access_token");

        //verify user creation

        requestSpecification.header("Authorization", access_token).
                when().log().all().
                get("/application").
                then().log().all().
                assertThat().
                statusCode(400).
                //body("succes",equalTo(1)).
                        time(lessThan(1000l));


    }

    @Test
    public void groovyGpath() {

        JsonPath jsonPath = new JsonPath(new File("src/test/java/stepDefinitions/api/store.json"));

        jsonPath.prettyPrint();

        Map<Object, Object> firstName = jsonPath.getMap("mortagage_applications.find { it.b_firstName == 'OnurKevin'}");
        System.out.println(firstName);

        List<Object> allfirstName = jsonPath.getList("mortagage_applications.findAll{ it.b_firstName == 'OnurKevin'}");
        System.out.println(allfirstName);

        List<Object> allb_lastName = jsonPath.getList("mortagage_applications.findAll { it.b_lastName.startsWith('t') }");
        System.out.println(allb_lastName);

        List<Object> allb_firstName = jsonPath.getList("mortagage_applications.findAll { it.b_firstName == 'hj' }");
        System.out.println(allb_firstName);

        List<Object> total_loan_amount = jsonPath.getList("mortagage_applications.findAll { it.total_loan_amount > 1000 }");
        System.out.println(total_loan_amount);

        Integer minPrice = jsonPath.getInt("mortagage_applications.total_loan_amount.min()");
        System.out.println(minPrice);

        Integer maxPrice = jsonPath.getInt("mortagage_applications.total_loan_amount.max()");
        System.out.println(maxPrice);

        Integer sumPrice = jsonPath.getInt("mortagage_applications.total_loan_amount.sum()");
        System.out.println(sumPrice);

        Double averagePrice = jsonPath.getDouble("mortagage_applications.total_loan_amount.average()");
        System.out.println(averagePrice);


        List<Object> collectFirstNameWithTotalLoan = jsonPath.getList("mortagage_applications.collect { \"${it.b_firstName} by ${it.total_loan_amount}\" }");
        System.out.println(collectFirstNameWithTotalLoan);

        List<Object> collectFirstNameWithTotalLoanEntry = jsonPath.getList("mortagage_applications.collect { [it.b_firstName,it.total_loan_amount] }");
        System.out.println(collectFirstNameWithTotalLoanEntry);


    }

    @Test
    public void pracriceHamcrestMatchers() {

//        JsonPath jsonPath = new JsonPath(new File("src/test/java/stepDefinitions/api/hamcrestMatchers.json"));
//
//        jsonPath.prettyPrint();
//
//        given().
//                queryParam("key", jsonPath).
//                when().log().all().
//                get("/forecast.json").
//                then().log().all().
//                assertThat().
//                statusCode(200).
//
//                body("name", equalTo("name"));
////                body("location.region", not(equalTo("New York"))).
////                body("forecast.forecastday", hasSize(7)).
////                body("forecast.forecastday", not(empty())).
////                body("location.country", notNullValue()).
////                body("location", hasKey("localtime")).
////                body("location", anyOf(hasKey("localtime"), hasKey("cdgs"), hasKey("cdbhsvgdv"))).
////                body("location", allOf(hasKey("localtime"), hasKey("lat"), hasKey("lon"))).
////                body("location", not(hasKey("password"))).
////                body("location", hasValue("America/New_York")).
////                body("location", hasEntry("region", "Virginia")).
////                body("location", not(empty())).
////                body("current.last_updated_epoch", greaterThanOrEqualTo(1683072900)).
////                body("current.condition.icon", startsWith("//cdn.weatherapi.com/weather")).
////                body("location.tz_id", matchesRegex("^[A-Za-z_]+/[A-Za-z_]+$")).
////                time(lessThan(1000L));


    }
}
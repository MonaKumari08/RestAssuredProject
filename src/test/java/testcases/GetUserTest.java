package testcases;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetUserTest extends BaseTest {

    @Test
    public void getUsers() {
        given()
            .queryParam("page", 2)                                               // optional query param
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("data.id[0]", equalTo(7))
            .header("Content-Type", equalTo("application/json; charset=utf-8"))
            .time(lessThan(2000L))                                                // response time < 2 sec
            .assertThat()
            .body(matchesJsonSchemaInClasspath("getUserSchema.json"))
            .log().all();
    }
}


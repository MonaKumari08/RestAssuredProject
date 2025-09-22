package testcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteUserTest extends BaseTest {

    @Test
    public void deleteUser() {
    	given()
    	    .queryParam("api_key", BaseTest.apiKey)
        .when()
            .delete("/users/2")
        .then()
            .statusCode(204)
            .log().all();
    }
}


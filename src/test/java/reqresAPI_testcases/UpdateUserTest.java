package reqresAPI_testcases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdateUserTest extends BaseTest {

	@BeforeClass
    public void init() throws Exception {
        setup("bearer");
    }
	
    @Test
    public void updateUser() {
        String requestBody = "{ \"name\": \"Mona\", \"job\": \"Senior QA\" }";

        given()
        	.queryParam("api_key", BaseTest.bearerApiKey)
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .put("/users/2")
        .then()
            .statusCode(200)
            .body("job", equalTo("Senior QA"))
            .log().all();
    }
}


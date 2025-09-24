package reqresAPI_testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserTest extends BaseTest {

	@BeforeClass
    public void init() throws Exception {
        setup("bearer");
    }
	
    @Test
    public void createUser() {
    	
        String requestBody = "{ \"name\": \"Mona\", \"job\": \"QA\" }";

        given()
            .queryParam("api_key", BaseTest.bearerApiKey)
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Mona"))
            .body("job", equalTo("QA"))
            .log().all();
    }
}


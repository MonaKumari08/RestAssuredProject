package reqresAPI_testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteUserTest extends BaseTest {

	@BeforeClass
    public void init() throws Exception {
        setup("bearer");
    }
	
    @Test
    public void deleteUser() {
    	given()
    	    .queryParam("api_key", BaseTest.bearerApiKey)
        .when()
            .delete("/users/2")
        .then()
            .statusCode(204)
            .log().all();
    }
}


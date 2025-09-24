package reqresAPI_testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserDataDrivenTest extends BaseTest {

	@BeforeClass
    public void init() throws Exception {
        setup("bearer");
    }
	
    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][] {
            {"Mona", "QA"},
            {"John", "Developer"},
            {"Alice", "Tester"}
        };
    }

    @Test(dataProvider = "userData")
    public void createUserTest(String name, String job) {
        String requestBody = "{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }";

        given()
            .queryParam("api_key", BaseTest.bearerApiKey)
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("name", equalTo(name))
            .body("job", equalTo(job))
            .log().all();
    }
}


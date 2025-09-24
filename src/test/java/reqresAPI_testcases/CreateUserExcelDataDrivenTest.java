package reqresAPI_testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcases.utils.ExcelUtils;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserExcelDataDrivenTest extends BaseTest {

	@BeforeClass
    public void init() throws Exception {
        setup("bearer");
    }
	
    @DataProvider(name = "excelData")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getExcelData("Sheet1");
    }

    @Test(dataProvider = "excelData")
    public void createUserFromExcel(String name, String job) {
    	
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


package reqresAPI_testcases;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BearerTokenAuthTest extends BaseTest {

	 @BeforeClass
	 public void init() throws Exception {
	    setup("bearer"); // explicitly pass auth type
	 
	 }
	@Test(priority = 1)
    public void getUserDetails() {
    	
        Response response = io.restassured.RestAssured
                .given()
                .header("x-api-key", bearerApiKey)   
                .header("Authorization", "Bearer " + bearerToken)  // token from BaseTest
                .when()
                .get("/users/2");

        Assert.assertEquals(response.getStatusCode(), 200, "Should return user details");
        Assert.assertEquals(response.jsonPath().getInt("data.id"), 2, "User ID should match");
        System.out.println("Response: " + response.asPrettyString());
    }
    
    @Test(priority = 2)
    public void createUser() {
        String requestBody = "{ \"name\": \"John Doe\", \"job\": \"QA Engineer\" }";

        Response response = io.restassured.RestAssured
                .given()
                .header("x-api-key", bearerApiKey)   
                .header("Authorization", "Bearer " + bearerToken)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/users");

        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println("POST User Response: " + response.asPrettyString());
    }

    @Test(priority = 3)
    public void updateUser() {
        String requestBody = "{ \"name\": \"John Doe\", \"job\": \"Senior QA\" }";

        Response response = io.restassured.RestAssured
                .given()
                .header("x-api-key", bearerApiKey)   
                .header("Authorization", "Bearer " + bearerToken)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/users/2");

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("PUT User Response: " + response.asPrettyString());
    }

    @Test(priority = 4)
    public void deleteUser() {
        Response response = io.restassured.RestAssured
                .given()
                .header("x-api-key", bearerApiKey)   
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .delete("/users/2");

        Assert.assertEquals(response.getStatusCode(), 204);
        System.out.println("DELETE User Response: No Content");
    }
}

package testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {

    private final int userId = 1001;

    @BeforeClass
    public void init() throws Exception {
        setup("basic"); // explicitly pass auth type
    }
    
    @Test(priority = 1)
    public void createUser() {
        String requestBody = "{\n" +
                "  \"id\": " + userId + ",\n" +
                "  \"username\": \"" + basicUsername + "\",\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"email\": \"john.doe@example.com\",\n" +
                "  \"password\": \"" + basicPassword + "\",\n" +
                "  \"phone\": \"1234567890\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        Response response = RestAssured
                .given()
                .auth().preemptive().basic(basicUsername, basicPassword)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/user");

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Create User Response:\n" + response.asPrettyString());
    }

    @Test(priority = 2)
    public void getUser() {
        Response response = RestAssured
                .given()
                .auth().preemptive().basic(basicUsername, basicPassword)
                .get("/user/" + basicUsername);

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Get User Response:\n" + response.asPrettyString());
    }

    @Test(priority = 3)
    public void updateUser() {
        String requestBody = "{\n" +
                "  \"id\": " + userId + ",\n" +
                "  \"username\": \"" + basicUsername + "\",\n" +
                "  \"firstName\": \"Jane\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"email\": \"jane.doe@example.com\",\n" +
                "  \"password\": \"" + basicPassword + "\",\n" +
                "  \"phone\": \"9876543210\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        Response response = RestAssured
                .given()
                .auth().preemptive().basic(basicUsername, basicPassword)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .put("/user/" + basicUsername);

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Update User Response:\n" + response.asPrettyString());
    }

    @Test(priority = 4)
    public void deleteUser() {
        Response response = RestAssured
                .given()
                .auth().preemptive().basic(basicUsername, basicPassword)
                .delete("/user/" + basicUsername);

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Delete User Response:\n" + response.asPrettyString());
    }
}

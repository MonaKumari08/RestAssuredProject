package reqresAPI_testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    // General
    public static String baseUrl;

    // Bearer Auth
    public static String bearerEmail;
    public static String bearerPassword;
    public static String bearerToken;
    public static String bearerApiKey;

    // Basic Auth
    public static String basicUsername;
    public static String basicPassword;

    // Auth type for the test class (to be set in test class)
    public static String authType;

   
    public void setup(String authType) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        // Load Bearer Auth
        bearerEmail = prop.getProperty("bearer.email");
        bearerPassword = prop.getProperty("bearer.password");
        bearerApiKey = prop.getProperty("bearer.api.key");

        // Load Basic Auth
        basicUsername = prop.getProperty("basic.username");
        basicPassword = prop.getProperty("basic.password");

        // Set Base URL based on auth type
        if (authType.equalsIgnoreCase("bearer")) {
            baseUrl = prop.getProperty("base.url.reqres");
            RestAssured.baseURI = baseUrl;

            // Generate Bearer token
            String requestBody = "{\n" +
                    "  \"email\": \"" + bearerEmail + "\",\n" +
                    "  \"password\": \"" + bearerPassword + "\"\n" +
                    "}";

            Response response = RestAssured
                    .given()
                    .header("Content-Type", "application/json")
                    .header("x-api-key", bearerApiKey)
                    .body(requestBody)
                    .post("/login");

            if (response.getStatusCode() == 200) {
                bearerToken = response.jsonPath().getString("token");
                System.out.println("Bearer Token generated: " + bearerToken);
            } else {
                throw new RuntimeException("Failed to generate token: " + response.asPrettyString());
            }

        } else if (authType.equalsIgnoreCase("basic")) {
            baseUrl = prop.getProperty("base.url.petstore");
            RestAssured.baseURI = baseUrl;
            System.out.println("Basic Auth credentials loaded.");
        } else {
            throw new RuntimeException("Invalid auth type. Must be 'bearer' or 'basic'");
        }
    }
}

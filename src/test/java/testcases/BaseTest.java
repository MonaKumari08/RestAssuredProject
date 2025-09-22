package testcases;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static String apiKey;
    public static String baseUrl;

    @BeforeClass
    public void setup() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        apiKey = prop.getProperty("api.key");
        baseUrl = prop.getProperty("base.url");

        RestAssured.baseURI = baseUrl;
    }
}




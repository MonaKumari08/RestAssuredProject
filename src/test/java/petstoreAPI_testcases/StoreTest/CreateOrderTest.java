package petstoreAPI_testcases.StoreTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import petstoreAPI_testcases.UserTest.PetStoreData;
import reqresAPI_testcases.BaseTest;

public class CreateOrderTest extends BaseTest {

	@BeforeClass
    public void init() throws Exception {
        setup("basic");
      //PetStoreData.orderId = System.currentTimeMillis();               // dynamic ID
	    PetStoreData.orderId = 1000 + (int)(Math.random() * 9000);
    }

    @Test()
    public void placeOrder() {
        String requestBody = "{\n" +
                "  \"id\": " + PetStoreData.orderId + ",\n" +
                "  \"petId\": 2001,\n" +     // reuse created pet
                "  \"quantity\": 1,\n" +
                "  \"shipDate\": \"2025-09-23T10:30:00.000Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/store/order");

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Place Order Response:\n" + response.asPrettyString());
    }

}

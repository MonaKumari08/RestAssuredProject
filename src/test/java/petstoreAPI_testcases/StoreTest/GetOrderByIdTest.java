package petstoreAPI_testcases.StoreTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import petstoreAPI_testcases.PetStoreData;

public class GetOrderByIdTest {

	  @Test
	    public void getOrderById() {
	        Response response = RestAssured
	                .given()
	                .get("/store/order/" + PetStoreData.orderId);

	        Assert.assertEquals(response.getStatusCode(), 200);
	        System.out.println("Get Order Response:\n" + response.asPrettyString());
	    }
}

package petstoreAPI_testcases.StoreTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetInventoryTest {

	   @Test
	    public void getInventory() {
	        Response response = RestAssured
	                .given()
	                .get("/store/inventory");

	        Assert.assertEquals(response.getStatusCode(), 200);
	        System.out.println("Inventory Response:\n" + response.asPrettyString());
	    }

}

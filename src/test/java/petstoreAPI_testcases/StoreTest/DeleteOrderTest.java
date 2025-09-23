package petstoreAPI_testcases.StoreTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import petstoreAPI_testcases.PetStoreData;

public class DeleteOrderTest {

    @Test
    public void deleteOrder() {
        Response response = RestAssured
                .given()
                .delete("/store/order/" + PetStoreData.orderId);

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Delete Order Response:\n" + response.asPrettyString());
    }
}


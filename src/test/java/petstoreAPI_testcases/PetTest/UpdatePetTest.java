package petstoreAPI_testcases.PetTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import petstoreAPI_testcases.PetStoreData;
import reqresAPI_testcases.BaseTest;

public class UpdatePetTest extends BaseTest {

	@Test
	public void updatePet() {
        String requestBody = "{\n" +
                "  \"id\": " + PetStoreData.petId + ",\n" +
                "  \"name\": \"doggie-updated\",\n" +
                "  \"status\": \"sold\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .put("/pet");

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Update Pet Response:\n" + response.asPrettyString());
    }
}

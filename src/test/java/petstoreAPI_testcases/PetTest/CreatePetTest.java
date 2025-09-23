package petstoreAPI_testcases.PetTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import petstoreAPI_testcases.PetStoreData;
import reqresAPI_testcases.BaseTest;

public class CreatePetTest extends BaseTest{

	@BeforeClass
	public void init() throws Exception {
		
	    setup("basic");
	    //PetStoreData.petId = System.currentTimeMillis();               // dynamic ID
	    PetStoreData.petId = 1000 + (int)(Math.random() * 9000);
	}

	@Test(priority = 1)
	public void addPet() {
	    String requestBody = "{\n" +
	            "  \"id\": " + PetStoreData.petId + ",\n" +
	            "  \"name\": \"doggie\",\n" +
	            "  \"status\": \"available\"\n" +
	            "}";

	    Response response = RestAssured
	            .given()
	            .header("Content-Type", "application/json")
	            .body(requestBody)
	            .post("/pet");

	    Assert.assertEquals(response.getStatusCode(), 200);
	    System.out.println("Add Pet Response:\n" + response.asPrettyString());
	}
}

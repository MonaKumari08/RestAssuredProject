package petstoreAPI_testcases.PetTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import petstoreAPI_testcases.UserTest.PetStoreData;
import reqresAPI_testcases.BaseTest;

public class DeletePetTest extends BaseTest {

	 @Test(priority = 6)
	    public void deletePet() {
	        Response response = RestAssured
	                .given()
	                .delete("/pet/" + PetStoreData.petId);

	        Assert.assertEquals(response.getStatusCode(), 200);
	        System.out.println("Delete Pet Response:\n" + response.asPrettyString());
	    }
}

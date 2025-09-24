package petstoreAPI_testcases.PetTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import petstoreAPI_testcases.UserTest.PetStoreData;
import reqresAPI_testcases.BaseTest;

public class GetPetByIDTest extends BaseTest{

	@Test
	public void getPetById() {
        Response response = RestAssured
                .given()
                .get("/pet/" + PetStoreData.petId);

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Get Pet Response:\n" + response.asPrettyString());
    }
}

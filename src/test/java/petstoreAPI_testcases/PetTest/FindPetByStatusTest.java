package petstoreAPI_testcases.PetTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import reqresAPI_testcases.BaseTest;

public class FindPetByStatusTest extends BaseTest{

	@Test
	 public void findPetByStatus() {
	        Response response = RestAssured
	                .given()
	                .queryParam("status", "available")
	                .get("/pet/findByStatus");

	        Assert.assertEquals(response.getStatusCode(), 200);
	        System.out.println("Find Pet By Status Response:\n" + response.asPrettyString());
	    }
}

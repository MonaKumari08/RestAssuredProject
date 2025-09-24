package petstoreAPI_testcases.PetTest;

import java.io.File;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import petstoreAPI_testcases.UserTest.PetStoreData;
import reqresAPI_testcases.BaseTest;

public class UploadImageTest extends BaseTest{
	
	   @Test
	    public void uploadImage() {
	        File file = new File("src/test/resources/dog.jpg");

	        Response response = RestAssured
	                .given()
	                .multiPart("file", file)
	                .post("/pet/" + PetStoreData.petId + "/uploadImage");

	        Assert.assertEquals(response.getStatusCode(), 200);
	        System.out.println("Upload Image Response:\n" + response.asPrettyString());
	    }
}

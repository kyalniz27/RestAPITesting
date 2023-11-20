import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import data.Payload;
import data.ReusableMethods;

public class DemoTest {
	
	public static void main(String[] args) {
				
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//Add place
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.addPlacePayload()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
		.body("scope", equalTo("APP"))
		.header("Connection", "Keep-Alive").extract().response().asString();
		
		System.out.println(response);
		JsonPath jsonPath = new JsonPath(response); //For parsing Json
		String placeId = jsonPath.get("place_id");
		
		System.out.println("Place Id =====>" + placeId);
		
		
		//Update place
		String newAddress = "Tokyo, Japan";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get updated place
		 String getPlaceResponse =  given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeId).when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		 
		 //JsonPath jsonPath2 = new JsonPath(getPlaceResponse);
		 JsonPath jsonPath2 = ReusableMethods.rawToJson(getPlaceResponse);
		 String actualAddress = jsonPath2.getString("address");
		 System.out.println("Get updated address ====> " + actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);
		
		
	}

}

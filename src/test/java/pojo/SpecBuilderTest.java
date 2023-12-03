package pojo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SpecBuilderTest {
	
	public static void main(String[] args) {
		
		AddPlace addPlace = new AddPlace();
		addPlace.setAccuracy(50);
		addPlace.setAddress("123 Main St.");
		addPlace.setLanguage("English");
		addPlace.setPhone_number("+1 574 234 9034");
		addPlace.setWebsite("https://rahulshettyacademy.com");
		addPlace.setName("Danyal");
		
		List<String> list = new ArrayList<String>();
		list.add("shop");
		list.add("shoes");
		
		addPlace.setTypes(list);
		
		Location location = new Location();
		location.setLat(12.345);
		location.setLng(123.987);
		addPlace.setLocation(location);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = given().log().all().queryParam("key", "qaclick123").body(addPlace)
		.when().post("maps/api/place/add/json")
		.then().assertThat()
		.statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
	}

}

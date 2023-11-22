package files;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.Payload;
import data.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	
	@Test(dataProvider = "BooksData")
	public void addBookTest(String isbn, String aisle) {
		
		 RestAssured.baseURI = "http://216.10.245.166";
		 String resp = given().log().all().header("Content-Type", "application/json")
		.body(Payload.addBook(isbn,aisle)).when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReusableMethods.rawToJson(resp);
		String idString = js.get("ID");
		System.out.println("Book ID ==> " + idString);
	}
	
	
	@DataProvider (name = "BooksData")
	public Object[][] getData() {
		return new Object[][] {{"as","12"},{"qw","34"},{"zx","56"}};
	}
	

}

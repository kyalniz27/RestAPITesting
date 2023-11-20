import org.testng.Assert;
import org.testng.annotations.Test;

import data.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumOfCourses() {
		JsonPath js = new JsonPath(Payload.CoursePrice());
		
		int count = js.getInt("courses.size()");
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		
		System.out.println("Verify if the sum of all course prices matches with purchase amount");
		
		int sum = 0;
		for(int i = 0; i < count; i++) {
			sum += js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");
		}
		
		Assert.assertEquals(totalAmount, sum);
	}

}

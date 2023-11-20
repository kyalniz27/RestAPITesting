import org.testng.Assert;

import data.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	public static void main(String[] args) throws Exception {
		
		JsonPath js = new JsonPath(Payload.CoursePrice());
		
		int count = js.getInt("courses.size()");
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		String firstCourseTitleString = js.getString("courses[0].title");
		String lastCourseTitleString = js.getString("courses[2].title");
		
		System.out.println("Array count ==> " + count);
		System.out.println("Total amount ==> " + totalAmount);
		System.out.println("First course title ==> " + firstCourseTitleString);
		System.out.println("Last course title ==> " + lastCourseTitleString);
		System.out.println("=".repeat(30));
		
		for(int i = 0; i < count; i++) {
			System.out.println(js.get("courses["+i+"].title") 
					+" ==> "+
					js.get("courses["+i+"].price"));
		}
		
		//Print number of copies sold by RPA
		System.out.println("=".repeat(40));
		System.out.println("Number of copies sold by RPA");
		for(int i = 0; i < count; i++) {
			String courseTitle = js.get("courses["+i+"].title");
			if(courseTitle.equalsIgnoreCase("RPA")) {
				System.out.println(js.get("courses["+i+"].copies"));
				break;
			}
		}
		
		
		System.out.println("Verify if the sum of all course prices matches with purchase amount");
		
		int sum = 0;
		for(int i = 0; i < count; i++) {
			sum += js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");
		}
		
		Assert.assertEquals(totalAmount, sum);
	}
	
	

}

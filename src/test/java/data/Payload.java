package data;

public class Payload {
	
	public static String addPlacePayload() {
		return "{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -37.383494,\r\n"
				+ "        \"lng\": 32.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"Book & Coffee\",\r\n"
				+ "    \"phone_number\": \"(+1) 123 456 7890\",\r\n"
				+ "    \"address\": \"123 Main St.\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"book\",\r\n"
				+ "        \"coffee\",\r\n"
				+ "        \"school supply\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://google.com\",\r\n"
				+ "    \"language\": \"English-IN\"\r\n"
				+ "}";
	}
	
	public static String CoursePrice() {
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 1162,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\" : [\r\n"
				+ "    {\r\n"
				+ "      \"title\" : \"Selenium Pyhton\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Appium\",\r\n"
				+ "      \"price\": 36,\r\n"
				+ "      \"copies\": 7\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}

}

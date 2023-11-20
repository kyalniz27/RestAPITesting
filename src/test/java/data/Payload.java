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

}

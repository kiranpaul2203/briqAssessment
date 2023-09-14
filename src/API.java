import java.net.http.HttpRequest;

import java.text.SimpleDateFormat;

import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class API {

	public static void main(String[] args) throws ParseException {
		// API 1 (a)
		SimpleDateFormat dtf = new SimpleDateFormat("MM-DD-YY-HH-MM-SS");
		Date date = new Date();
		System.out.println(dtf.format(date));
		// API 2 (c)
		Response resp = RestAssured.get("https://data.sfgov.org/resource/p4e4-a5a7.json");
		//String respBody = resp.getBody().asString();
		//ResponseBody<ResponseBody<String>> body = resp.getBody();
		//ResponseBody body = resp.getBody();
		
	//	System.out.println(resp.asPrettyString());
	
		/*
		 * String s = "\",\""; String arr[] = respBody.split("s"); int count = 0; String
		 * roof = "roof"; for (int i = 0; i < arr.length; i++) { if
		 * (arr[i].contains(roof)) { count++; } } System.out.println(count);
		 */

		 JSONParser jsonParser = new JSONParser();
		 Object obj1 = jsonParser.parse(resp.asPrettyString());
		 JSONArray jsonArray = (JSONArray) obj1;
		 
		 for (int i=0; i<jsonArray.size()-1 ;i++) {
			 
			 JSONObject obj =  (JSONObject) jsonArray.get(i);
			 
			// if((JSONObject) jsonArray.get(i).equals("roof"))
				 
				 
			 System.out.println("-----------------------------------");
				System.out.println("proposed_use   " +  obj.get("proposed_use"));
				System.out.println("existing_construction_type   "+obj.get("existing_construction_type"));
				System.out.println("status_date  " +obj.get("status_date"));
				
			 
		 }
		
		 
		 
		 
	}

}

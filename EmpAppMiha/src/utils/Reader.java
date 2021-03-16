package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reader {
	public static JSONObject json(String name) {
		//read the file from the specified location
		FileReader reader = null;
		try {
			reader = new FileReader(System.getProperty("user.dir")+"\\src\\tstdata\\"+name+".json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//create object of type JSONParser
		JSONParser jsonParser = new JSONParser();
				
		//transform the file content in JSONObject
		JSONObject obj = null;
		try {
			obj = (JSONObject) jsonParser.parse(reader);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
}

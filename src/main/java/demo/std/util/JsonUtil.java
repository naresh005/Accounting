package demo.std.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtil {
	
	public static void print(JSONObject jsonObject){
		String[] elementNames = JSONObject.getNames(jsonObject);		
		for (String string : elementNames) {
			System.out.println(string);
		}		
	}
	
	public static Map<String, Object> getKeyValueMap(String keyName, JSONObject jsonObj){
		
		HashMap<String, Object> map = new HashMap<>();
		try{
			JSONArray jsonArray = jsonObj.getJSONArray(keyName);
			for(int i=0; i<jsonArray.length();i++){
				JSONObject objectInArray = jsonArray.getJSONObject(i);
				String[] elementNames = JSONObject.getNames(objectInArray);
				for (String elementName : elementNames) {
					System.out.println(elementName);
					Object value = objectInArray.get(elementName);
					map.put(elementName, value);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

}

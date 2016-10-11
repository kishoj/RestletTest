package com.rest.test.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.data.CharacterSet;
import org.restlet.ext.json.JsonRepresentation;

public class JsonUtils {
	public static <T> JsonRepresentation getJsonRepresentation(final T obj) {
		JsonRepresentation result = null;
		if (obj != null) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				result = new JsonRepresentation(mapper.writeValueAsString(obj));
				result.setCharacterSet(CharacterSet.UTF_8);
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static <T> T getObjectFromJSON(final String jsonString, Class<T> typeClass) {
		ObjectMapper jsonParser = new ObjectMapper();
		T t = null;
		try {
			t = jsonParser.readValue(jsonString, typeClass);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return t;
	}
}

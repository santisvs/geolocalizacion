package com.santivallejo.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.santivallejo.pojo.Mensaje;
import com.santivallejo.pojo.PostalC;
import com.santivallejo.pojo.PostalCodes;

public class ConvertJson {

	public static PostalCodes convertJsonToPostalCodes(String json) {

		PostalCodes lista = new PostalCodes();
		PostalC pc = null;
		// ArrayList<PostalCode> lista = new ArrayList<PostalCode>();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		JsonNode rootNode;
		try {
			rootNode = mapper.readTree(json);
			JsonNode postalCodes = rootNode.get("postalcodes");

			if (postalCodes.isArray()) {

				for (final JsonNode objNode : postalCodes) {
					System.out.println(objNode);
					pc = mapper.readValue(objNode, PostalC.class);
					lista.add(pc);

				}
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;

	}

	public static String convertMensajeToJson(Mensaje msj) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(msj);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
}

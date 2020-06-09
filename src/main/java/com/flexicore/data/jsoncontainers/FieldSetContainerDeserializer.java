package com.flexicore.data.jsoncontainers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.io.Serializable;

public  class FieldSetContainerDeserializer<T extends Serializable> extends JsonDeserializer<FieldSetContainer<T>> {
	
	ObjectMapper mapper;
	public FieldSetContainerDeserializer() {
		super();
		mapper= new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@Override
	public FieldSetContainer<T> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException {
		JsonNode node = jp.getCodec().readTree(jp);
		String clazzName=node.get("clazz").textValue();
		String name=node.get("name").asText();
		String value=node.get("value").toString();
		boolean byId=node.get("byId").asBoolean(false);
		try {
			Class<T> c=(Class<T>) Class.forName(clazzName);
		T s=mapper.readValue(value, c);
            return new FieldSetContainer<>(name, c, s, byId);
			
		} catch (ClassNotFoundException e) {
			throw  new IOException(e);
		}

	}
	

}

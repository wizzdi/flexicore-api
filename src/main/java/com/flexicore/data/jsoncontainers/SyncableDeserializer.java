package com.flexicore.data.jsoncontainers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.flexicore.interfaces.Syncable;
import com.flexicore.model.Baseclass;
import com.flexicore.model.nosql.BaseclassNoSQL;

import java.io.IOException;

public class SyncableDeserializer extends JsonDeserializer<Syncable> {

    @Override
    public Syncable deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = mapper.readTree(jp);

        boolean noSQL = root.has("noSQL") && root.get("noSQL").asBoolean();
        return noSQL ? mapper.readValue(jp, BaseclassNoSQL.class) :mapper.readValue(jp, Baseclass.class);

    }
}

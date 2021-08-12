package com.dsfa.nc.pd.serializer;

import com.dsfa.nc.pd.types.PK;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class PKDeserializer extends JsonDeserializer<PK> {

    @Override
    public PK deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String text = jsonParser.getText();
        if (text == null) {
            throw new RuntimeException();
        }
        return new PK(text);
    }
}

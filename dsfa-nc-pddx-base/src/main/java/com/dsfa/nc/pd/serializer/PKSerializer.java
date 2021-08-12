package com.dsfa.nc.pd.serializer;

import com.dsfa.nc.pd.types.PK;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PKSerializer extends JsonSerializer<PK> {
    @Override
    public void serialize(PK pk, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

    }
}

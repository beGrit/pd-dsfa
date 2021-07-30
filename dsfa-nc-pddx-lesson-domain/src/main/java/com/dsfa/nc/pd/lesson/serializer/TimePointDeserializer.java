package com.dsfa.nc.pd.lesson.serializer;

import com.dsfa.nc.pd.lesson.types.TimePoint;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * @ClassName TimePointSerializer
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
public class TimePointDeserializer extends JsonDeserializer<TimePoint> {

    @Override
    public TimePoint deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String text = jsonParser.getText();
        if (text == null) {
            throw new RuntimeException();
        }
        return new TimePoint(text);
    }
}

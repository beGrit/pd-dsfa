package com.dsfa.nc.pd.lesson.serializer;

import com.dsfa.nc.pd.lesson.types.TimePoint;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @ClassName TimePointSerializer
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
public class TimePointSerializer extends JsonSerializer<TimePoint> {
    @Override
    public void serialize(TimePoint timePoint, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(timePoint.toString());
    }
}

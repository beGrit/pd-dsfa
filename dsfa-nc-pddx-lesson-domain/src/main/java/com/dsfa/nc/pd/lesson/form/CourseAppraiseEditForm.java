package com.dsfa.nc.pd.lesson.form;

import com.dsfa.nc.pd.util.PersistDataProcessUtil;
import com.dsfa.platform.starter.meta.core.model.persist.PersistData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName CourseAppraisePersistData
 * @Description TODO
 * @Author pocky
 * @Date 2021/8/4
 **/
@Data
public class CourseAppraiseEditForm {
    @JsonProperty("csml_lsf_access_id")
    private String id;

    private String courseId;

    private String accountId;

    private String type;

    public static CourseAppraiseEditForm loadFromPersistData(PersistData persistData) {
        Map<String, Object> data = PersistDataProcessUtil.trimPrefixNamespace(persistData.getNamespace(), persistData.getData());
        CourseAppraiseEditForm res = null;
        try {
            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(data);
            om.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            res = om.readValue(json, CourseAppraiseEditForm.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return res;
    }
}

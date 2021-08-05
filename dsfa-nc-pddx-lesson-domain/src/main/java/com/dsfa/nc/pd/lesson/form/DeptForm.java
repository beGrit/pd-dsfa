package com.dsfa.nc.pd.lesson.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName DeptForm
 * @Description TODO
 * @Author pocky
 * @Date 2021/8/4
 **/
@Data
public class DeptForm {
    @JsonProperty(value = "name")
    private String name;
}

package com.dsfa.nc.pd.lesson.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName TestForm
 * @Description TODO
 * @Author pocky
 * @Date 2021/8/4
 **/
@Data
public class TestForm {
    private String name;

    @JsonProperty("csml_lsf_testa_dept")
    private List<DeptForm> dept;
}

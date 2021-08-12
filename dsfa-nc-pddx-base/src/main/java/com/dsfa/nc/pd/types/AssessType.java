package com.dsfa.nc.pd.types;

import com.dsfa.platform.sdk.common.kit.StrKit;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName AppraiseItemType 评价类型
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
public class AssessType implements Serializable {
    private final String name;
    private Double score;

    public AssessType(@NotNull String name) {
        if (StrKit.equals(name, "点个赞")) {
            this.score = 10.0;
        } else if (StrKit.equals(name, "送朵花")) {
            this.score = 9.5;
        } else if (StrKit.equals(name, "吐个槽")) {
            this.score = 9.0;
        } else {
            throw new ValidationException("类型错误");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

    public AssessType map(String value) {
        return new AssessType(value);
    }
}

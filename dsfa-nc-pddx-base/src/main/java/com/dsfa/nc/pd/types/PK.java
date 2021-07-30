package com.dsfa.nc.pd.types;

import com.dsfa.nc.pd.domain.Identifier;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * @ClassName PK
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/29
 **/
@Getter
public class PK implements Identifier {
    private final String val;

    public PK(@NotNull String id) {
        this.val = id;
    }
}

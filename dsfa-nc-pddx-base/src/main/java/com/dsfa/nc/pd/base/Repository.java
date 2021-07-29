package com.dsfa.nc.pd.base;

import javax.validation.constraints.NotNull;

public interface Repository<T extends Aggregate<ID>, ID extends Identifier> {
    void attach(@NotNull T aggregate);

    void detach(@NotNull T aggregate);

    T find(@NotNull ID id);

    void remove(@NotNull T aggregate);

    void save(@NotNull T aggregate);
}

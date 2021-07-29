package com.dsfa.nc.pd.domain;

public interface Identifiable<ID extends Identifier> {
    ID getId();
}

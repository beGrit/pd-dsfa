package com.dsfa.nc.pd.learn.model;

import com.dsfa.nc.pd.learn.model.base.BaseNcLearnYear;
import com.dsfa.platform.starter.db.jfinal.tablebind.TableBind;

/**
 * Generated by JFinal.
 */
@TableBind(
    tableName = "nc_learn_year",
    pkName = "nc_learn_year_id"
)
public class NcLearnYear extends BaseNcLearnYear<NcLearnYear> {
	public static final NcLearnYear dao = new NcLearnYear().dao();
}
package com.dsfa.nc.pd.lesson.ext;

import com.dsfa.nc.pd.lesson.form.TestForm;
import com.dsfa.nc.pd.util.PersistDataProcessUtil;
import com.dsfa.platform.starter.meta.core.ext.MetaAspect;
import com.dsfa.platform.starter.meta.core.ext.MetaExt;
import com.dsfa.platform.starter.meta.core.ext.MetaPoint;
import com.dsfa.platform.starter.meta.core.model.persist.PersistData;

/**
 * @ClassName TestaEditExt
 * @Description TODO
 * @Author pocky
 * @Date 2021/8/4
 **/
@MetaAspect(value = "csml.lsf.testa.edit")
public class TestaEditExt extends MetaExt {
    @Override
    public void beforePersistData(MetaPoint metaPoint, PersistData persistData) {
        TestForm data = PersistDataProcessUtil.loadAsForm(persistData, TestForm.class);
        System.out.println(data);
    }
}

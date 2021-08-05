package com.dsfa.nc.pd.lesson.ext;

import com.dsfa.nc.pd.lesson.form.CourseAppraiseEditForm;
import com.dsfa.platform.starter.meta.core.ext.MetaAspect;
import com.dsfa.platform.starter.meta.core.ext.MetaExt;
import com.dsfa.platform.starter.meta.core.ext.MetaPoint;
import com.dsfa.platform.starter.meta.core.model.persist.PersistData;

/**
 * @ClassName AppraiseEditExt
 * @Description TODO
 * @Author pocky
 * @Date 2021/8/4
 **/
@MetaAspect(value = "csml.lsf.access.edit")
public class AppraiseEditExt extends MetaExt {
    @Override
    public void beforePersistData(MetaPoint metaPoint, PersistData persistData) {
        CourseAppraiseEditForm form = CourseAppraiseEditForm.loadFromPersistData(persistData);
    }
}

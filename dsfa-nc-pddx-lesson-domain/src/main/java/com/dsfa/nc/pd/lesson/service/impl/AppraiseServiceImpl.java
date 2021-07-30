package com.dsfa.nc.pd.lesson.service.impl;

import com.dsfa.nc.pd.lesson.entity.appraise.CourseAppraiseItem;
import com.dsfa.nc.pd.lesson.service.IAppraiseService;
import com.dsfa.nc.pd.lesson.types.AppraiseItemType;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAppraiseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AppraiseServiceImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Service("lsf_collection_service")
public class AppraiseServiceImpl implements IAppraiseService {
    @Autowired
    ICourseAppraiseItemRepository courseAppraiseRepository;

    @Override
    public boolean appraiseCourse(String courseId, String accountId, String type) {
        CourseAppraiseItem item = courseAppraiseRepository.findByCourseIdAndAccountId(courseId, accountId);
        if (item == null) { // 新评价
            item = new CourseAppraiseItem();
            item.setCourseId(courseId);
            item.setAccountId(accountId);
            item.setType(new AppraiseItemType(type));
        } else {
            item.changeType(new AppraiseItemType(type));
        }
        int rtn = courseAppraiseRepository.save(item);
        return rtn == 1;
    }
}

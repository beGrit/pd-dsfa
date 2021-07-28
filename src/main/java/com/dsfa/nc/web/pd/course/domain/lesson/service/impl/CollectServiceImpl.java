package com.dsfa.nc.web.pd.course.domain.lesson.service.impl;

import com.dsfa.nc.web.pd.course.domain.lesson.entity.appraise.CourseAppraiseItem;
import com.dsfa.nc.web.pd.course.domain.lesson.repository.ICourseAppraiseItemRepository;
import com.dsfa.nc.web.pd.course.domain.lesson.service.ICollectService;
import com.dsfa.nc.web.pd.course.domain.lesson.types.AppraiseItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CollectServiceImpl
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/28
 **/
@Service("lsf_collection_service")
public class CollectServiceImpl implements ICollectService {
    @Autowired
    ICourseAppraiseItemRepository courseAppraiseRepository;

    @Override
    public boolean collectCourse(String courseId, String accountId, String type) {
        CourseAppraiseItem item = courseAppraiseRepository.findByCourseIdAndAccountId(courseId, accountId);
        if (item == null) { // 新增请求
            CourseAppraiseItem newItem = new CourseAppraiseItem();
            newItem.setCourseId(courseId);
            newItem.setAccountId(accountId);
            newItem.setType(new AppraiseItemType(type));
            int rtn = courseAppraiseRepository.save(newItem);
            return rtn == 1;
        } else { // 修改请求
            item.setType(new AppraiseItemType(type));
            courseAppraiseRepository.save(item);
            return true;
        }
    }
}

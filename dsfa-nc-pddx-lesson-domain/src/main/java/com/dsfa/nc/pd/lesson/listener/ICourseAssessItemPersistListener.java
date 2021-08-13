package com.dsfa.nc.pd.lesson.listener;

import com.dsfa.nc.pd.lesson.entity.appraise.CourseAssessItem;
import com.dsfa.nc.pd.lesson.reposiitory.ICourseAssessItemRepository;
import com.dsfa.platform.starter.mq.annotation.MqConsumer;
import com.dsfa.platform.starter.mq.core.ConsumerListener;
import org.springframework.beans.factory.annotation.Autowired;

@MqConsumer(
        topic = "CourseAssessItem",
        tag = "item_save"
)
public class ICourseAssessItemPersistListener implements ConsumerListener<CourseAssessItem> {
    @Autowired
    ICourseAssessItemRepository repository; // 课程评价仓库

    @Override
    public void onMessage(CourseAssessItem courseAssessItem) {
        repository.save(courseAssessItem);
    }
}

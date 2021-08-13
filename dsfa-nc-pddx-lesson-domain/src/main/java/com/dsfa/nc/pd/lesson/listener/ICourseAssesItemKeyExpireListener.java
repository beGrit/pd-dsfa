package com.dsfa.nc.pd.lesson.listener;

import com.dsfa.nc.pd.lesson.reposiitory.ICourseAssessItemRepository;
import com.dsfa.platform.starter.mq.core.IMqTemplate;
import com.dsfa.platform.starter.redis.RedisExecute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class ICourseAssesItemKeyExpireListener implements MessageListener {
    @Autowired
    IMqTemplate mqTemplate;

    @Autowired
    RedisExecute redisExecute;

    @Autowired
    ICourseAssessItemRepository repository;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String expireKey = new String(message.getBody());
        if (expireKey.startsWith("expire:course:assess:")) {
            // 需要发送消息给保存业务
            String[] prefData = expireKey.split(":");
            String[] keyData = prefData[prefData.length - 1].split("\\|");
            if (keyData.length == 2) { // 复合型主键(courseId + accountId)
                String courseId = keyData[0];
                String accountId = keyData[1];
            }
        }
    }
}

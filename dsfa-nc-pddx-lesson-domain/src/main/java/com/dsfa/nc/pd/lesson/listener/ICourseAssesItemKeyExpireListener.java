package com.dsfa.nc.pd.lesson.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class ICourseAssesItemKeyExpireListener extends KeyExpirationEventMessageListener {
    public ICourseAssesItemKeyExpireListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String s = message.toString();

    }
}

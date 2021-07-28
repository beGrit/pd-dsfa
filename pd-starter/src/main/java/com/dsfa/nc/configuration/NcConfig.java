package com.dsfa.nc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * rm
 **/
@Configuration
public class NcConfig {
    @Value("${api.ding.publics.task:}")
    Boolean  task;

    public Boolean getTask() {
        return task;
    }

    public void setTask(Boolean task) {
        this.task = task;
    }
}

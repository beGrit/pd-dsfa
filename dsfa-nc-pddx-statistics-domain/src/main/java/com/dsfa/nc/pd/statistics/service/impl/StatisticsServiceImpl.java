package com.dsfa.nc.pd.statistics.service.impl;

import com.dsfa.nc.pd.statistics.dto.CountDto;
import com.dsfa.nc.pd.statistics.service.IStatisticsService;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.Db;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.Record;
import com.dsfa.platform.starter.db.jfinal.plugin.activerecord.SqlPara;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName IndexCountServiceImplV2
 * @Description TODO
 * @Author pocky
 * @Date 2021/7/27
 **/
@Service
@CacheConfig(cacheNames = "statistics")
public class StatisticsServiceImpl implements IStatisticsService {
    private static final String SQL_KEY = "statistics.sql.";

    private static final String redisKey = "statistics";

    public long countClass() {
        SqlPara sqlPara = Db.getSqlPara(SQL_KEY + "countClasses");
        Record record = Db.findFirst(sqlPara);
        long res = record.get("count(*)");
        return res;
    }

    public long countStudent() {
        SqlPara sqlPara = Db.getSqlPara(SQL_KEY + "countStudents");
        Record record = Db.findFirst(sqlPara);
        long res = record.get("count(*)");
        return res;
    }

    public long countTeacher() {
        SqlPara sqlPara = Db.getSqlPara(SQL_KEY + "countTeachers");
        Record record = Db.findFirst(sqlPara);
        long res = record.get("count(*)");
        return res;
    }

    @Override
    @Cacheable(key = "'pd.index'")
    public CountDto getCounts() {
        long c1 = this.countClass();
        long c2 = this.countStudent();
        long c3 = this.countTeacher();
        CountDto countDto = new CountDto();
        countDto.setClassCount(c1);
        countDto.setStudentCount(c2);
        countDto.setTeacherCount(c3);
        return countDto;
    }
}

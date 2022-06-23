package com.xasmall.lab12.service.impl;

import com.sun.org.apache.xpath.internal.operations.String;
import com.xasmall.lab12.entity.SysLog;
import com.xasmall.lab12.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void saveSysLog(SysLog sysLog) {
        StringBuffer sql = new StringBuffer();
        sql.append("insert into syslog (username,operation,time,method,params,ip,createtime)");
        sql.append(" values(:username,:operation,:time,:method,:params,:ip,:createtime)");
        System.out.println(sql);
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        npjt.update(sql.toString(),new BeanPropertySqlParameterSource(sysLog));
    }
}

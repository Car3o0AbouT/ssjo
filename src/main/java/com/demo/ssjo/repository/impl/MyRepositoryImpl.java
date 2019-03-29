package com.demo.ssjo.repository.impl;

import com.demo.ssjo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author lec
 * @Title: MyRepositoryImpl
 * @ProjectName ssjo
 * @Description: 自定义执行器实现类
 * @date 2019/3/28 11:30
 */
public class MyRepositoryImpl implements MyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Map<String, Object>> mySelect(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public int myUpdate(String sql) {
        return jdbcTemplate.update(sql);
    }

    @Override
    public int myCount(String sql) {
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}

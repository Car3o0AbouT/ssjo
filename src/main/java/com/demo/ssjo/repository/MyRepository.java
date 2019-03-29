package com.demo.ssjo.repository;

import java.util.List;
import java.util.Map;

/**
 * @author lec
 * @Title: MyRepository
 * @ProjectName ssjo
 * @Description: 通用自定义sql执行器
 * @date 2019/3/28 11:23
 */
public interface MyRepository {

    /**
     * 查询
     * @param sql
     * @return
     */
    List<Map<String, Object>> mySelect(String sql);

    /**
     * 更新
     * @param sql
     * @return
     */
    int myUpdate(String sql);

    /**
     * 计数
     * @param sql
     * @return
     */
    int myCount(String sql);
}

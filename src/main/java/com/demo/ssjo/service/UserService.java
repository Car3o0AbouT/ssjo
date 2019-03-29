package com.demo.ssjo.service;

import com.demo.ssjo.entity.User;
import com.demo.ssjo.util.PageVo;

import java.util.Map;

/**
 * @author lec
 * @Title: UserService
 * @ProjectName ssjo
 * @Description: user 服务接口
 * @date 2019/3/27 17:31
 */
public interface UserService {
    boolean save(User e);

    PageVo<Map<String,Object>> list(User e, Integer page, Integer limit);

    boolean update(User e);
}

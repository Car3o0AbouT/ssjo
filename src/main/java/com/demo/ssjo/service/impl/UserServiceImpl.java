package com.demo.ssjo.service.impl;

import com.demo.ssjo.entity.User;
import com.demo.ssjo.repository.UserRps;
import com.demo.ssjo.service.UserService;
import com.demo.ssjo.util.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author lec
 * @Title: UserServiceImpl
 * @ProjectName ssjo
 * @Description: user 服务实现类
 * @date 2019/3/27 17:31
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRps userRps;

    @Override
    public boolean save(User e) {
        userRps.save(e);
        return true;
    }

    @Override
    public PageVo<Map<String,Object>> list(User e, Integer page, Integer limit) {
        PageVo<Map<String,Object>> vo = new PageVo<>();
        String count = "select count(1) from user where 1=1";
        String data = "select * from user where 1=1";
        if (!StringUtils.isEmpty(e.getId())) {
            count += " and id='" + e.getId() + "' ";
            data += " and id='" + e.getId() + "' ";
        }
        if (!StringUtils.isEmpty(e.getName())) {
            count += " and name like '%" + e.getName() + "%' ";
            data += " and name like '%" + e.getName() + "%' ";
        }
        if (page != null && limit != null) {
            data += " limit " + (page - 1) * limit + "," + limit + " ";
        }
        vo.setSucMsg("查询成功");
        vo.setCount(userRps.myCount(count));
        vo.setData(userRps.mySelect(data));
        return vo;
    }

    @Override
    public boolean update(User e) {
        User user = userRps.findById(e.getId()).get();
        user.setName(e.getName());
        userRps.save(user);
        return true;
    }
}

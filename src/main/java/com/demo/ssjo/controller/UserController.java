package com.demo.ssjo.controller;

import com.demo.ssjo.entity.User;
import com.demo.ssjo.service.UserService;
import com.demo.ssjo.util.PageVo;
import com.demo.ssjo.util.RspVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author lec
 * @Title: UserController
 * @ProjectName ssjo
 * @Description: user 控制器
 * @date 2019/3/27 17:29
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表查询
     * @param e
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageVo<Map<String,Object>> list(User e, Integer page, Integer limit) {
        return userService.list(e, page, limit);
    }

    /**
     * 保存
     * @param e
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public RspVo save(User e) {
        RspVo vo = new RspVo();
        if (userService.save(e)) {
            vo.setSucMsg("保存成功");
        } else {
            vo.setErrorMsg("保存失败");
        }
        return vo;
    }

    /**
     * 查询
     * @param e
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public RspVo update(User e) {
        RspVo vo = new RspVo();
        if (userService.update(e)) {
            vo.setSucMsg("查询成功");
        } else {
            vo.setErrorMsg("查询失败");
        }
        return vo;
    }

}

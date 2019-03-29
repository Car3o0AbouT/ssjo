package com.demo.ssjo.repository;

import com.demo.ssjo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lec
 * @Title: UserRps
 * @ProjectName ssjo
 * @Description: user 数据访问层
 * @date 2019/3/27 17:34
 */
public interface UserRps extends JpaRepository<User,Long>,MyRepository {

}

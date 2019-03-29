package com.demo.ssjo.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author lec
 * @Title: User
 * @ProjectName ssjo
 * @Description: user 实体类
 * @date 2019/3/27 17:02
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @CreatedDate
    private Timestamp time;

    @Column
    private String name;
}

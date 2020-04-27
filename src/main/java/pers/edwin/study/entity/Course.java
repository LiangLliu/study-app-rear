package pers.edwin.study.entity;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 559656748334914427L;
    /**
    * 课程主键
    */
    private Integer id;
    /**
    * 课程名称
    */
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
package pers.edwin.study.entity;

import java.io.Serializable;

/**
 * (SelectTopic)实体类
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
public class SelectTopic implements Serializable {
    private static final long serialVersionUID = -18875471388112108L;
    /**
    * 选择题主键
    */
    private Integer id;
    /**
    * 题目
    */
    private String title;
    /**
    * 选项A
    */
    private String optionsA;
    /**
    * 选项B
    */
    private String optionsB;
    /**
    * 选项C
    */
    private String optionsC;
    /**
    * 选项D
    */
    private String optionsD;
    /**
    * 正确选项
    */
    private String right;
    /**
    * 课程ID
    */
    private Integer course;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionsA() {
        return optionsA;
    }

    public void setOptionsA(String optionsA) {
        this.optionsA = optionsA;
    }

    public String getOptionsB() {
        return optionsB;
    }

    public void setOptionsB(String optionsB) {
        this.optionsB = optionsB;
    }

    public String getOptionsC() {
        return optionsC;
    }

    public void setOptionsC(String optionsC) {
        this.optionsC = optionsC;
    }

    public String getOptionsD() {
        return optionsD;
    }

    public void setOptionsD(String optionsD) {
        this.optionsD = optionsD;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

}
package pers.edwin.study.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Nnowledge)实体类
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
public class Nnowledge implements Serializable {
    private static final long serialVersionUID = 213552998388101906L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 标题
    */
    private String titile;
    /**
    * 内容
    */
    private String content;
    /**
    * 课程分类
    */
    private Integer course;
    /**
    * 创建人
    */
    private Integer createBy;
    /**
    * 创建时间
    */
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
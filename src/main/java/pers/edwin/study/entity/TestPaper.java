package pers.edwin.study.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TestPaper)实体类
 *
 * @author makejava
 * @since 2020-04-28 00:24:35
 */
public class TestPaper implements Serializable {
    private static final long serialVersionUID = 465086785201282092L;
    /**
    * 试卷主键
    */
    private Integer id;
    /**
    * 提交的表单
    */
    private String submit;
    /**
    * 学生ID
    */
    private Integer studentId;
    /**
    * 课程
    */
    private Integer courseId;
    /**
    * 分数
    */
    private Integer score;
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

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
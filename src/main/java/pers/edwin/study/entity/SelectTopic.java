package pers.edwin.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (SelectTopic)实体类
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
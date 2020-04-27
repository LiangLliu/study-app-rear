package pers.edwin.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Nnowledge)实体类
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
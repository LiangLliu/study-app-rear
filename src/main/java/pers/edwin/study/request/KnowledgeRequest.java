package pers.edwin.study.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author edwin-plus
 * Create Data: 2020/4/29 0:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeRequest {

    /**
     * 标题
     */
    @NotNull
    private String titile;
    /**
     * 内容
     */
    @NotNull
    private String content;
    /**
     * 课程分类
     */
    @NotNull
    private Integer course;
    /**
     * 创建人
     */
    @NotNull
    private Integer createBy;
}

package pers.edwin.study.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author edwin-plus
 * Create Data: 2020/4/30 0:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectTopicRequest {

    /**
     * 题目
     */
    @NotNull
    private String title;
    /**
     * 选项A
     */
    @NotNull
    private String optionsA;
    /**
     * 选项B
     */
    @NotNull
    private String optionsB;
    /**
     * 选项C
     */
    @NotNull
    private String optionsC;
    /**
     * 选项D
     */
    @NotNull
    private String optionsD;
    /**
     * 正确选项
     */
    @NotNull
    private String answer;
    /**
     * 课程ID
     */
    @NotNull
    private Integer courseId;

    /**
     * 创建者
     */
    @NotNull
    private Integer createBy;
}

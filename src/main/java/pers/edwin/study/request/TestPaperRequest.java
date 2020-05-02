package pers.edwin.study.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

/**
 * @Author edwin-plus
 * Create Data: 2020/5/1 21:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestPaperRequest {

    /**
     * 提交的表单
     */
    @NotNull
    private List<AnswerRequest> submit;
    /**
     * 学生ID
     */
    @NotNull
    private Integer studentId;
    /**
     * 课程
     */
    @NotNull
    private Integer courseId;

    /**
     * 分数
     */
    @NotNull
    private Integer score;
    /**
     * 总体数
     */
    @NotNull
    private Integer totalQuestion;
    /**
     * 正确试题总数
     */
    @NotNull
    private Integer correct;
}

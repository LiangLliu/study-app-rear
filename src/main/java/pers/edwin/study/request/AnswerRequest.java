package pers.edwin.study.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author edwin-plus
 * Create Data: 2020/5/1 21:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequest {

    /**
     * 选择题id
     */
    @NotNull
    private Integer id;

    /**
     * 答案
     */
    @NotNull
    private String solution;

}

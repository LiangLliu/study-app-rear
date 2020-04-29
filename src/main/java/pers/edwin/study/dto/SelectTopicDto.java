package pers.edwin.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.edwin.study.entity.SelectTopic;
import pers.edwin.study.enums.CourseEnum;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author edwin-plus
 * Create Data: 2020/4/29 23:57
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SelectTopicDto {

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
    private String answer;
    /**
     * 课程ID
     */
    private Integer courseId;

    private String course;

    public static SelectTopicDto from(SelectTopic selectTopic) {
        return SelectTopicDto.builder()
                .id(selectTopic.getId())
                .title(selectTopic.getTitle())
                .answer(selectTopic.getAnswer())
                .optionsA(selectTopic.getOptionsA())
                .optionsB(selectTopic.getOptionsB())
                .optionsC(selectTopic.getOptionsC())
                .optionsD(selectTopic.getOptionsD())
                .course(CourseEnum.from(selectTopic.getCourse()))
                .courseId(selectTopic.getCourse())
                .build();
    }

    public static List<SelectTopicDto> from(List<SelectTopic> selectTopicList) {
        return selectTopicList.stream().map(SelectTopicDto::from).collect(Collectors.toList());
    }
}

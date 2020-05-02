package pers.edwin.study.dto;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.edwin.study.entity.TestPaper;
import pers.edwin.study.enums.CourseEnum;
import pers.edwin.study.request.AnswerRequest;
import pers.edwin.study.service.StudentService;
import pers.edwin.study.util.serialization.CompressUtil;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author edwin-plus
 * Create Data: 2020/5/1 21:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestPaperDto {
    /**
     * 试卷主键
     */
    private Integer id;
    /**
     * 提交的表单
     */
    private List<AnswerRequest> submit;
    /**
     * 学生ID
     */
    private Integer studentId;
    /**
     * 课程
     */
    private Integer courseId;

    private String course;
    /**
     * 分数
     */
    private Integer score;
    /**
     * 创建时间
     */
    private Instant createTime;
    /**
     * 总体数
     */
    private Integer totalQuestion;
    /**
     * 正确试题总数
     */
    private Integer correct;

    public static List<TestPaperDto> from(List<TestPaper> testPaperList) {
        return testPaperList.stream().map(TestPaperDto::from).collect(Collectors.toList());
    }


    public static TestPaperDto from(TestPaper testPaper) {
        return TestPaperDto.builder()
                .id(testPaper.getId())
                .submit(getSubmit(testPaper.getSubmit()))
                .correct(testPaper.getCorrect())
                .courseId(testPaper.getCourseId())
                .course(CourseEnum.from(testPaper.getCourseId()))
                .createTime(testPaper.getCreateTime())
                .studentId(testPaper.getStudentId())
                .score(testPaper.getScore())
                .totalQuestion(testPaper.getTotalQuestion())
                .build();
    }

    private static List<AnswerRequest> getSubmit(String submit) {
        return new Gson()
                .fromJson(submit, new TypeToken<List<AnswerRequest>>() {
                }.getType());
    }


}

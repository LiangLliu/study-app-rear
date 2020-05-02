package pers.edwin.study.converter;

import com.google.gson.Gson;
import pers.edwin.study.dto.TestPaperDto;
import pers.edwin.study.entity.TestPaper;
import pers.edwin.study.request.AnswerRequest;
import pers.edwin.study.request.TestPaperRequest;
import pers.edwin.study.util.serialization.CompressUtil;
import pers.edwin.study.util.serialization.SerializeUtil;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

/**
 * @Author edwin-plus
 * Create Data: 2020/5/1 22:01
 */
public class TestPaperConverter {
    public static TestPaper converte(TestPaperRequest request) {

        System.out.println(new Gson().toJson(request.getSubmit()).length());

        return TestPaper.builder()
                .submit(new Gson().toJson(request.getSubmit()))
                .score(request.getScore())
                .courseId(request.getCourseId())
                .studentId(request.getStudentId())
                .totalQuestion(request.getTotalQuestion())
                .correct(request.getCorrect())
                .createTime(Instant.now())
                .build();
    }

}

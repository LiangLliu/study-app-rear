package pers.edwin.study.dto;


import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.edwin.study.entity.TestPaper;
import pers.edwin.study.enums.CourseEnum;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


/**
 * @Author edwin-plus
 * Create Data: 2020/5/2 15:35
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisDto {
    private Integer total;

    private Integer correct;

    private Integer chinese;

    private Integer mathematics;

    private Integer english;

    private Integer physical;

    private Integer chemistry;

    private Integer biological;

    private Integer political;
    private Integer geography;
    private Integer history;

    public static AnalysisDto from(List<TestPaper> testPaperList) {

        Tuple2<Integer, Integer> chinese = getCourseAnalysis(testPaperList, CourseEnum.CHINESE);
        Tuple2<Integer, Integer> mathematics = getCourseAnalysis(testPaperList, CourseEnum.MATHEMATICS);
        Tuple2<Integer, Integer> english = getCourseAnalysis(testPaperList, CourseEnum.ENGLISH);
        Tuple2<Integer, Integer> chemistry = getCourseAnalysis(testPaperList, CourseEnum.CHEMISTRY);
        Tuple2<Integer, Integer> biological = getCourseAnalysis(testPaperList, CourseEnum.BIOLOGICAL);
        Tuple2<Integer, Integer> physical = getCourseAnalysis(testPaperList, CourseEnum.PHYSICAL);
        Tuple2<Integer, Integer> political = getCourseAnalysis(testPaperList, CourseEnum.POLITICAL);
        Tuple2<Integer, Integer> geography = getCourseAnalysis(testPaperList, CourseEnum.GEOGRAPHY);
        Tuple2<Integer, Integer> history = getCourseAnalysis(testPaperList, CourseEnum.HISTORY);

        int totle = chinese._1() +
                mathematics._1() +
                english._1() +
                chemistry._1() +
                biological._1() +
                physical._1() +
                political._1() +
                geography._1() +
                history._1();
        int correct = chinese._2() +
                mathematics._2() +
                english._2() +
                chemistry._2() +
                biological._2() +
                physical._2() +
                political._2() +
                geography._2() +
                history._2();

        return AnalysisDto.builder()
                .total(totle)
                .correct(correct)
                .chinese(chinese._1())
                .mathematics(mathematics._1())
                .english(english._1())
                .chemistry(chemistry._1())
                .biological(biological._1())
                .physical(physical._1())
                .political(political._1())
                .geography(geography._1())
                .history(history._1())
                .build();
    }

    private static Tuple2<Integer, Integer> getCourseAnalysis(List<TestPaper> testPaperList, CourseEnum courseEnum) {
        List<TestPaper> collect = testPaperList.stream()
                .filter(it -> it.getCourseId().equals(courseEnum.getCode()))
                .collect(Collectors.toList());

        AtomicInteger total = new AtomicInteger();
        AtomicInteger correct = new AtomicInteger();
        collect.forEach(it -> {
            total.addAndGet(it.getTotalQuestion());
            correct.addAndGet(it.getCorrect());
        });
        return Tuple.of(total.get(), correct.get());
    }

}

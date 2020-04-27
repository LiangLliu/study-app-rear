package pers.edwin.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.edwin.study.entity.Course;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Jinzi Yuan
 * Create Data: 2020/4/10 0:08
 * @Description :
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NameListDto {
    private Integer id;

    private String name;

    public static List<NameListDto> fromCourseList(List<Course> courseList) {

        return courseList.stream()
                .map(it -> NameListDto.builder()
                        .id(it.getId())
                        .name(it.getName())
                        .build())
                .collect(Collectors.toList());
    }


}

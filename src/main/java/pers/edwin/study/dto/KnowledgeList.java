package pers.edwin.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.edwin.study.entity.Nnowledge;
import pers.edwin.study.enums.CourseEnum;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author edwin-plus
 * Create Data: 2020/4/29 23:15
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgeList {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 课程分类
     */
    private String course;


    private Integer courseId;

    public static KnowledgeList from(Nnowledge nnowledge) {
        return KnowledgeList.builder()
                .id(nnowledge.getId())
                .title(nnowledge.getTitile())
                .courseId(nnowledge.getCourse())
                .course(CourseEnum.from(nnowledge.getCourse()))
                .build();
    }

    public static List<KnowledgeList> from(List<Nnowledge> nnowledgeList) {
        return nnowledgeList.stream().map(KnowledgeList::from).collect(Collectors.toList());
    }
}

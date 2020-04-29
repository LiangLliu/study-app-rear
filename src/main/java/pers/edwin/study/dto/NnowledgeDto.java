package pers.edwin.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.edwin.study.entity.Nnowledge;
import pers.edwin.study.enums.CourseEnum;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author edwin-plus
 * Create Data: 2020/4/29 23:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NnowledgeDto {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 标题
     */
    private String titile;
    /**
     * 内容
     */
    private String content;
    /**
     * 课程分类
     */
    private String course;

    /**
     * 创建时间
     */
    private Instant createTime;

    private Integer courseId;

    public static NnowledgeDto from(Nnowledge nnowledge) {
        return NnowledgeDto.builder()
                .id(nnowledge.getId())
                .titile(nnowledge.getTitile())
                .content(nnowledge.getContent())
                .courseId(nnowledge.getCourse())
                .course(CourseEnum.from(nnowledge.getCourse()))
                .createTime(nnowledge.getCreateTime())
                .build();
    }

    public static List<NnowledgeDto> from(List<Nnowledge> nnowledgeList) {
        return nnowledgeList.stream().map(NnowledgeDto::from).collect(Collectors.toList());
    }

}

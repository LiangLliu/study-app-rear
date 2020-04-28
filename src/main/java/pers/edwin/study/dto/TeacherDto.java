package pers.edwin.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.edwin.study.entity.Teacher;
import pers.edwin.study.enums.CourseEnum;

/**
 * @Author edwin-plus
 * Create Data: 2020/4/28 23:28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 教师用户名
     */
    private String username;
    /**
     * 电话号码
     */
    private String telephone;
    /**
     * 授课方向
     */
    private String teachDirection;
    /**
     * 头像
     */
    private String avatarUrl;

    private Integer coureseId;


    public static TeacherDto fromTeacherEntity(Teacher teacher) {
        return TeacherDto.builder()
                .id(teacher.getId())
                .username(teacher.getUsername())
                .avatarUrl(teacher.getAvatarUrl())
                .teachDirection(CourseEnum.from(teacher.getTeachDirection()))
                .coureseId(teacher.getTeachDirection())
                .telephone(teacher.getTelephone())
                .build();
    }
}

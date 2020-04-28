package pers.edwin.study.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author edwin-plus
 * Create Data: 2020/4/28 23:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequest {
    /**
     * 主键ID
     */
    @NotNull
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
    private Integer courseId;
    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 密码
     */
    private String password;
}

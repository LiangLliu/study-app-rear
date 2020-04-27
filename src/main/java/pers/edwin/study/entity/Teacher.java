package pers.edwin.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2020-04-28 00:24:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {
    private static final long serialVersionUID = -40512125622730918L;
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
     * 密码
     */
    private String password;
    /**
     * 授课方向
     */
    private Integer teachDirection;
    /**
     * 头像
     */
    private String avatarUrl;

}
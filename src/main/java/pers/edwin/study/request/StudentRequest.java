package pers.edwin.study.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * @Author edwin-plus
 * Create Data: 2020/4/25 23:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    /**
     * ID
     */
    @NotNull
    private Integer id;
    /**
     * 用户名
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
     * 用户头像
     */
    private String avatarUrl;
    /**
     * 积分
     */
    private Integer integral;
}
package pers.edwin.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

/**
 * @Author edwin-plus
 * Create Data: 2020/4/26 22:19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    /**
     * ID
     */
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
     * 用户头像
     */
    private String avatarUrl;
    /**
     * 积分
     */
    private Integer integral;

}

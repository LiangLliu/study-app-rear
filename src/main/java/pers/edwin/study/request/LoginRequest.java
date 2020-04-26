package pers.edwin.study.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author edwin-plus
 * Create Data: 2020/4/26 22:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    /**
     * 电话号码
     */
    @NotNull
    private String telephone;
    /**
     * 密码
     */
    @NotNull
    private String password;
}

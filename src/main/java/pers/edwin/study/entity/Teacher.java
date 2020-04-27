package pers.edwin.study.entity;

import java.io.Serializable;

/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2020-04-28 00:24:35
 */
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTeachDirection() {
        return teachDirection;
    }

    public void setTeachDirection(Integer teachDirection) {
        this.teachDirection = teachDirection;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}
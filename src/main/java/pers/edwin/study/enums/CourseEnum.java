package pers.edwin.study.enums;

import lombok.Getter;

import java.util.stream.Stream;

/**
 * @Author edwin-plus
 * Create Data: 2020/4/28 23:31
 */
@Getter
public enum CourseEnum {

    CHINESE(1, "语文"),
    MATHEMATICS(2, "数学"),
    ENGLISH(3, "英语"),
    PHYSICAL(4, "物理"),
    CHEMISTRY(5, "化学"),
    BIOLOGICAL(6, "生物"),
    POLITICAL(7, "政治"),
    GEOGRAPHY(8, "地理"),
    HISTORY(9, "历史"),
    ;

    private Integer code;
    private String name;

    CourseEnum(Integer id, String name) {
        this.code = id;
        this.name = name;
    }

    public static String from(Integer code) {
        for (CourseEnum ele : values()) {
            if (ele.getCode().equals(code)) {
                return ele.getName();
            }
        }
        return null;
    }

    public static Integer from(String name) {
        for (CourseEnum ele : values()) {
            if (ele.getName().equals(name)) {
                return ele.getCode();
            }
        }
        return null;
    }
}

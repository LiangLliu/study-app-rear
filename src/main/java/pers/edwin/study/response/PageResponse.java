package pers.edwin.study.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 工具类
 *
 * @param <V>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<V> {
    private Integer count;
    private Integer page;
    private Integer size;
    private List<V> list;
}

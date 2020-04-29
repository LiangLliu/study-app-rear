package pers.edwin.study.service;

import pers.edwin.study.entity.SelectTopic;
import java.util.List;

/**
 * (SelectTopic)表服务接口
 *
 * @author makejava
 * @since 2020-04-30 01:04:49
 */
public interface SelectTopicService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SelectTopic queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SelectTopic> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param selectTopic 实例对象
     * @return 实例对象
     */
    SelectTopic insert(SelectTopic selectTopic);

    /**
     * 修改数据
     *
     * @param selectTopic 实例对象
     * @return 实例对象
     */
    SelectTopic update(SelectTopic selectTopic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
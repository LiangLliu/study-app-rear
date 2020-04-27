package pers.edwin.study.service;

import pers.edwin.study.entity.Nnowledge;
import java.util.List;

/**
 * (Nnowledge)表服务接口
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
public interface NnowledgeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Nnowledge queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Nnowledge> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param nnowledge 实例对象
     * @return 实例对象
     */
    Nnowledge insert(Nnowledge nnowledge);

    /**
     * 修改数据
     *
     * @param nnowledge 实例对象
     * @return 实例对象
     */
    Nnowledge update(Nnowledge nnowledge);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
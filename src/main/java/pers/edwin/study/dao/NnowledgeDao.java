package pers.edwin.study.dao;

import pers.edwin.study.entity.Nnowledge;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Nnowledge)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
public interface NnowledgeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Nnowledge queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Nnowledge> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param nnowledge 实例对象
     * @return 对象列表
     */
    List<Nnowledge> queryAll(Nnowledge nnowledge);

    /**
     * 新增数据
     *
     * @param nnowledge 实例对象
     * @return 影响行数
     */
    int insert(Nnowledge nnowledge);

    /**
     * 修改数据
     *
     * @param nnowledge 实例对象
     * @return 影响行数
     */
    int update(Nnowledge nnowledge);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
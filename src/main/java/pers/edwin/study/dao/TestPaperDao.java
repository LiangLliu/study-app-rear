package pers.edwin.study.dao;

import pers.edwin.study.entity.TestPaper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TestPaper)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-01 21:24:07
 */
public interface TestPaperDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestPaper queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TestPaper> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param testPaper 实例对象
     * @return 对象列表
     */
    List<TestPaper> queryAll(TestPaper testPaper);

    /**
     * 新增数据
     *
     * @param testPaper 实例对象
     * @return 影响行数
     */
    int insert(TestPaper testPaper);

    /**
     * 修改数据
     *
     * @param testPaper 实例对象
     * @return 影响行数
     */
    int update(TestPaper testPaper);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
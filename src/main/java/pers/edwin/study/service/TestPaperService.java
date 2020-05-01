package pers.edwin.study.service;

import pers.edwin.study.entity.TestPaper;
import java.util.List;

/**
 * (TestPaper)表服务接口
 *
 * @author makejava
 * @since 2020-05-01 21:24:07
 */
public interface TestPaperService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestPaper queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TestPaper> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param testPaper 实例对象
     * @return 实例对象
     */
    TestPaper insert(TestPaper testPaper);

    /**
     * 修改数据
     *
     * @param testPaper 实例对象
     * @return 实例对象
     */
    TestPaper update(TestPaper testPaper);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
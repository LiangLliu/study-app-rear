package pers.edwin.study.service.impl;

import pers.edwin.study.entity.TestPaper;
import pers.edwin.study.dao.TestPaperDao;
import pers.edwin.study.service.TestPaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TestPaper)表服务实现类
 *
 * @author makejava
 * @since 2020-05-01 21:24:08
 */
@Service("testPaperService")
public class TestPaperServiceImpl implements TestPaperService {
    @Resource
    private TestPaperDao testPaperDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TestPaper queryById(Integer id) {
        return this.testPaperDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TestPaper> queryAllByLimit(int offset, int limit) {
        return this.testPaperDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param testPaper 实例对象
     * @return 实例对象
     */
    @Override
    public TestPaper insert(TestPaper testPaper) {
        this.testPaperDao.insert(testPaper);
        return testPaper;
    }

    /**
     * 修改数据
     *
     * @param testPaper 实例对象
     * @return 实例对象
     */
    @Override
    public TestPaper update(TestPaper testPaper) {
        this.testPaperDao.update(testPaper);
        return this.queryById(testPaper.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.testPaperDao.deleteById(id) > 0;
    }

    @Override
    public List<TestPaper> queryAll(TestPaper testPaper) {
        return this.testPaperDao.queryAll(testPaper);
    }
}
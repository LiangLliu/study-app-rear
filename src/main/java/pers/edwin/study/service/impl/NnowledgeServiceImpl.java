package pers.edwin.study.service.impl;

import pers.edwin.study.entity.Nnowledge;
import pers.edwin.study.dao.NnowledgeDao;
import pers.edwin.study.service.NnowledgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Nnowledge)表服务实现类
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
@Service("nnowledgeService")
public class NnowledgeServiceImpl implements NnowledgeService {
    @Resource
    private NnowledgeDao nnowledgeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Nnowledge queryById(Integer id) {
        return this.nnowledgeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Nnowledge> queryAllByLimit(int offset, int limit) {
        return this.nnowledgeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param nnowledge 实例对象
     * @return 实例对象
     */
    @Override
    public Nnowledge insert(Nnowledge nnowledge) {
        this.nnowledgeDao.insert(nnowledge);
        return nnowledge;
    }

    /**
     * 修改数据
     *
     * @param nnowledge 实例对象
     * @return 实例对象
     */
    @Override
    public Nnowledge update(Nnowledge nnowledge) {
        this.nnowledgeDao.update(nnowledge);
        return this.queryById(nnowledge.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.nnowledgeDao.deleteById(id) > 0;
    }

    @Override
    public List<Nnowledge> queryAll(Nnowledge query) {
        return this.nnowledgeDao.queryAll(query);
    }

    @Override
    public List<Nnowledge> searchByTitle(String title) {
        return this.nnowledgeDao.searchByTitle(title);
    }
}
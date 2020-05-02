package pers.edwin.study.service.impl;

import pers.edwin.study.entity.SelectTopic;
import pers.edwin.study.dao.SelectTopicDao;
import pers.edwin.study.service.SelectTopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SelectTopic)表服务实现类
 *
 * @author makejava
 * @since 2020-04-30 01:04:49
 */
@Service("selectTopicService")
public class SelectTopicServiceImpl implements SelectTopicService {
    @Resource
    private SelectTopicDao selectTopicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SelectTopic queryById(Integer id) {
        return this.selectTopicDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SelectTopic> queryAllByLimit(int offset, int limit) {
        return this.selectTopicDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param selectTopic 实例对象
     * @return 实例对象
     */
    @Override
    public SelectTopic insert(SelectTopic selectTopic) {
        this.selectTopicDao.insert(selectTopic);
        return selectTopic;
    }

    /**
     * 修改数据
     *
     * @param selectTopic 实例对象
     * @return 实例对象
     */
    @Override
    public SelectTopic update(SelectTopic selectTopic) {
        this.selectTopicDao.update(selectTopic);
        return this.queryById(selectTopic.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.selectTopicDao.deleteById(id) > 0;
    }

    @Override
    public List<SelectTopic> queryAll(SelectTopic selectTopic) {
        return this.selectTopicDao.queryAll(selectTopic);
    }
}
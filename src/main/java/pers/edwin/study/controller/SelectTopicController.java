package pers.edwin.study.controller;

import pers.edwin.study.entity.SelectTopic;
import pers.edwin.study.service.SelectTopicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SelectTopic)表控制层
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
@RestController
@RequestMapping("selectTopic")
public class SelectTopicController {
    /**
     * 服务对象
     */
    @Resource
    private SelectTopicService selectTopicService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SelectTopic selectOne(Integer id) {
        return this.selectTopicService.queryById(id);
    }

}
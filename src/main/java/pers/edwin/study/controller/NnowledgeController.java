package pers.edwin.study.controller;

import pers.edwin.study.entity.Nnowledge;
import pers.edwin.study.service.NnowledgeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Nnowledge)表控制层
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
@RestController
@RequestMapping("nnowledge")
public class NnowledgeController {
    /**
     * 服务对象
     */
    @Resource
    private NnowledgeService nnowledgeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Nnowledge selectOne(Integer id) {
        return this.nnowledgeService.queryById(id);
    }

}
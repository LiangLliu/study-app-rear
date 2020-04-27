package pers.edwin.study.controller;

import pers.edwin.study.entity.TestPaper;
import pers.edwin.study.service.TestPaperService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TestPaper)表控制层
 *
 * @author makejava
 * @since 2020-04-28 00:24:35
 */
@RestController
@RequestMapping("testPaper")
public class TestPaperController {
    /**
     * 服务对象
     */
    @Resource
    private TestPaperService testPaperService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TestPaper selectOne(Integer id) {
        return this.testPaperService.queryById(id);
    }

}
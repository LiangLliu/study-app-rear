package pers.edwin.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pers.edwin.study.dto.NnowledgeDto;
import pers.edwin.study.dto.TestPaperDto;
import pers.edwin.study.entity.TestPaper;
import pers.edwin.study.service.TestPaperService;
import org.springframework.web.bind.annotation.*;
import pers.edwin.study.util.ResultUtil;

import javax.annotation.Resource;

/**
 * (TestPaper)表控制层
 *
 * @author makejava
 * @since 2020-05-01 21:24:08
 */
@Slf4j
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
    @GetMapping("/selectOne")
    public ResponseEntity selectOne(Integer id) {
        return ResultUtil.success(HttpStatus.OK, TestPaperDto.from(this.testPaperService.queryById(id)));
    }


}
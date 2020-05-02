package pers.edwin.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import pers.edwin.study.converter.TestPaperConverter;
import pers.edwin.study.dto.*;
import pers.edwin.study.entity.Nnowledge;
import pers.edwin.study.entity.SelectTopic;
import pers.edwin.study.entity.TestPaper;
import pers.edwin.study.request.KnowledgeRequest;
import pers.edwin.study.request.TestPaperRequest;
import pers.edwin.study.service.TestPaperService;
import org.springframework.web.bind.annotation.*;
import pers.edwin.study.util.ResultUtil;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (TestPaper)表控制层
 *
 * @author makejava
 * @since 2020-05-01 21:24:08
 */
@Slf4j
@RestController
@RequestMapping("/testPaper")
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
    @GetMapping("/selectOne/{id}")
    public ResponseEntity selectOne(@PathVariable Integer id) {
        TestPaper testPaper = this.testPaperService.queryById(id);
        if (testPaper == null) {
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "没有找到该题目");
        }
        return ResultUtil.success(HttpStatus.OK, TestPaperDto.from(testPaper));
    }


    @PostMapping("/answer")
    public ResponseEntity answer(@RequestBody @Valid TestPaperRequest request,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【用户作答结果】参数不正确，request = {}", request);
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "用户作答时必须填写完整 ");
        }

        if (!(request.getSubmit().size() > 0)) {
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "没有提交答案列表");
        }
        TestPaper testPaper = TestPaperConverter.converte(request);
        testPaperService.insert(testPaper);
        return ResultUtil.success(HttpStatus.CREATED);
    }

    @GetMapping("/selectByUserList/{id}")
    public ResponseEntity selectList(@PathVariable Integer id) {
        List<TestPaper> testPaperList = this.testPaperService.queryAll(TestPaper.builder()
                .studentId(id).build());
        return ResultUtil.success(HttpStatus.OK, TestPaperDto.from(testPaperList));
    }


    @GetMapping("/analysis/{studentId}")
    public ResponseEntity analysis(@PathVariable Integer studentId) {

        TestPaper build = TestPaper.builder().studentId(studentId).build();
        List<TestPaper> testPaperList = testPaperService.queryAll(build);
        return ResultUtil.success(HttpStatus.CREATED, AnalysisDto.from(testPaperList));
    }
}
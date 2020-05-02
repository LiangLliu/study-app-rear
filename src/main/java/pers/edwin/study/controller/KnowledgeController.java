package pers.edwin.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import pers.edwin.study.dto.KnowledgeList;
import pers.edwin.study.dto.NnowledgeDto;
import pers.edwin.study.entity.Nnowledge;
import pers.edwin.study.request.KnowledgeRequest;
import pers.edwin.study.service.NnowledgeService;
import org.springframework.web.bind.annotation.*;
import pers.edwin.study.util.ResultUtil;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Nnowledge)表控制层
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
@Slf4j
@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {
    /**
     * 服务对象
     */
    @Resource
    private NnowledgeService nnowledgeService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid KnowledgeRequest request,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【添加知识点】参数不正确，request = {}", request);
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "添加知识点时必须填写完整 ");
        }
        nnowledgeService.insert(Nnowledge.builder()
                .titile(request.getTitle())
                .content(request.getContent())
                .course(request.getCourse())
                .createBy(request.getCreateBy())
                .createTime(Instant.now())
                .build());
        return ResultUtil.success(HttpStatus.CREATED);
    }

    @GetMapping("/selectOne/{id}")
    public ResponseEntity selectOne(@PathVariable Integer id) {
        return ResultUtil.success(HttpStatus.CREATED, NnowledgeDto.from(nnowledgeService.queryById(id)));
    }

    @GetMapping("/selectList/{courseId}")
    public ResponseEntity selectList(@PathVariable Integer courseId) {
        Nnowledge query = Nnowledge.builder().course(courseId).build();
        List<Nnowledge> nnowledgeList = nnowledgeService.queryAll(query);
        return ResultUtil.success(HttpStatus.CREATED, KnowledgeList.from(nnowledgeList));
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(value = "courseId") Integer courseId,
                                 @RequestParam(value = "name") String titleName) {
        List<Nnowledge> nnowledgeList = nnowledgeService.searchByTitle("%" + titleName + "%");
        List<Nnowledge> collect = nnowledgeList.stream().filter(it -> it.getCourse().equals(courseId)).collect(Collectors.toList());
        return ResultUtil.success(HttpStatus.CREATED, NnowledgeDto.from(collect));
    }
}
package pers.edwin.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import pers.edwin.study.entity.Nnowledge;
import pers.edwin.study.entity.Student;
import pers.edwin.study.request.KnowledgeRequest;
import pers.edwin.study.request.RegisterRequest;
import pers.edwin.study.service.NnowledgeService;
import org.springframework.web.bind.annotation.*;
import pers.edwin.study.util.ResultUtil;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.Instant;

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
                .titile(request.getTitile())
                .content(request.getContent())
                .course(request.getCourse())
                .createBy(request.getCreateBy())
                .createTime(Instant.now())
                .build());
        return ResultUtil.success(HttpStatus.CREATED);
    }

}
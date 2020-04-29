package pers.edwin.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import pers.edwin.study.dto.SelectTopicDto;
import pers.edwin.study.entity.SelectTopic;
import pers.edwin.study.request.SelectTopicRequest;
import pers.edwin.study.service.SelectTopicService;
import org.springframework.web.bind.annotation.*;
import pers.edwin.study.util.ResultUtil;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.Instant;

/**
 * (SelectTopic)表控制层
 *
 * @author makejava
 * @since 2020-04-28 23:17:22
 */
@Slf4j
@RestController
@RequestMapping("/selectTopic")
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
    @GetMapping("/selectOne")
    public ResponseEntity selectOne(Integer id) {
        return ResultUtil.success(HttpStatus.CREATED, SelectTopicDto.from(selectTopicService.queryById(id)));
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid SelectTopicRequest request,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建试题】参数不正确，request = {}", request);
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "创建试题时必须填写完整 ");
        }
        selectTopicService.insert(SelectTopic.builder()
                .title(request.getTitle())
                .optionsA(request.getOptionsA())
                .optionsB(request.getOptionsB())
                .optionsC(request.getOptionsC())
                .optionsD(request.getOptionsD())
                .course(request.getCourseId())
                .createBy(request.getCreateBy())
                .answer(request.getAnswer())
                .createTime(Instant.now())
                .build());
        return ResultUtil.success(HttpStatus.CREATED);
    }
}
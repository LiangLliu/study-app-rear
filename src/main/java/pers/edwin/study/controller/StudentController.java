package pers.edwin.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import pers.edwin.study.entity.Student;
import pers.edwin.study.request.RegisterRequest;
import pers.edwin.study.request.StudentRequest;
import pers.edwin.study.service.StudentService;
import org.springframework.web.bind.annotation.*;
import pers.edwin.study.util.ResultUtil;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-04-25 23:41:35
 */
@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRequest registerRequest,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【学生注册】参数不正确，registerRequest = {}", registerRequest);
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "注册信息必须填写完整 ");
        }

        if (!studentService.check(registerRequest.getTelephone())) {
            log.error("【学生注册】该学生已经存在，registerRequest = {}", registerRequest);
            return ResultUtil.error(HttpStatus.NOT_FOUND, "该学生已经存在，不要重复注册");
        }

        studentService.insert(Student.builder()
                .telephone(registerRequest.getTelephone())
                .password(registerRequest.getPassword())
                .build());

        return ResultUtil.success(HttpStatus.CREATED);
    }

}
package pers.edwin.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import pers.edwin.study.dto.StudentDto;
import pers.edwin.study.dto.TeacherDto;
import pers.edwin.study.entity.Student;
import pers.edwin.study.entity.Teacher;
import pers.edwin.study.enums.CourseEnum;
import pers.edwin.study.request.LoginRequest;
import pers.edwin.study.request.RegisterRequest;
import pers.edwin.study.request.StudentRequest;
import pers.edwin.study.request.TeacherRequest;
import pers.edwin.study.service.TeacherService;
import org.springframework.web.bind.annotation.*;
import pers.edwin.study.util.ResultUtil;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.Instant;
import java.time.ZoneId;

/**
 * (Teacher)表控制层
 *
 * @author makejava
 * @since 2020-04-28 00:24:35
 */
@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRequest registerRequest,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【老师注册】参数不正确，registerRequest = {}", registerRequest);
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "注册信息必须填写完整 ");
        }

        if (!teacherService.check(registerRequest.getTelephone())) {
            log.error("【老师注册】该学生已经存在，registerRequest = {}", registerRequest);
            return ResultUtil.error(HttpStatus.NOT_FOUND, "该手机号已经存在，不要重复注册");
        }

        teacherService.insert(Teacher.builder()
                .telephone(registerRequest.getTelephone())
                .password(registerRequest.getPassword())
                .build());
        return ResultUtil.success(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequest loginRequest,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【老师登录】参数不正确，loginRequest = {}", loginRequest);
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "登陆信息必须填写完整 ");
        }

        // 登录
        Teacher teacher = teacherService.login(loginRequest.getTelephone(), loginRequest.getPassword());
        if (teacher == null) {
            log.error("【老师登录】用户名或密码错误，loginRequest = {}", loginRequest);
            return ResultUtil.error(HttpStatus.NOT_FOUND, "用户名或密码错误");
        }
        TeacherDto teacherDto = TeacherDto.fromTeacherEntity(teacher);
        return ResultUtil.success(HttpStatus.CREATED, teacherDto);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid TeacherRequest teacherRequest,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【老师更新】参数不正确，teacherRequest = {}", teacherRequest);
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "注册信息必须填写完整 ");
        }

        Teacher teacher = new Teacher();

        teacher.setId(teacherRequest.getId());
        if (teacherRequest.getAvatarUrl() != null) {
            teacher.setAvatarUrl(teacherRequest.getAvatarUrl());
        }

        if (teacherRequest.getPassword() != null) {
            teacher.setPassword(teacherRequest.getPassword());
        }

        if (teacherRequest.getTelephone() != null) {
            teacher.setTelephone(teacherRequest.getTelephone());
        }

        if (teacherRequest.getCourseId() != null) {
            teacher.setTeachDirection(teacherRequest.getCourseId());
        }

        if (teacherRequest.getUsername() != null) {
            teacher.setUsername(teacherRequest.getUsername());
        }

        return ResultUtil.success(HttpStatus.CREATED, TeacherDto.fromTeacherEntity(teacherService.update(teacher)));
    }

}
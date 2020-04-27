package pers.edwin.study.controller;

import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import pers.edwin.study.dao.StudentDao;
import pers.edwin.study.dto.StudentDto;
import pers.edwin.study.entity.Student;
import pers.edwin.study.request.LoginRequest;
import pers.edwin.study.request.RegisterRequest;
import pers.edwin.study.request.StudentRequest;
import pers.edwin.study.service.StudentService;
import org.springframework.web.bind.annotation.*;
import pers.edwin.study.util.ResultUtil;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

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

    private final int INTEGRAL = 10;

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
            return ResultUtil.error(HttpStatus.NOT_FOUND, "该手机号已经存在，不要重复注册");
        }

        studentService.insert(Student.builder()
                .telephone(registerRequest.getTelephone())
                .password(registerRequest.getPassword())
                .integral(0)
                .createTime(Instant.now())
                .updateTime(Instant.ofEpochSecond((Instant.now().getEpochSecond() - 25 * 60 * 60)))
                .build());

        return ResultUtil.success(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequest loginRequest,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【学生登录】参数不正确，loginRequest = {}", loginRequest);
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "注册信息必须填写完整 ");
        }

        // 登录
        Student student = studentService.login(loginRequest.getTelephone(), loginRequest.getPassword());
        if (student == null) {
            log.error("【学生登录】用户名或密码错误，loginRequest = {}", loginRequest);
            return ResultUtil.error(HttpStatus.NOT_FOUND, "用户名或密码错误");
        }

        StudentDto studentDto = StudentDto.builder()
                .id(student.getId())
                .username(student.getUsername())
                .telephone(student.getTelephone())
                .avatarUrl(student.getAvatarUrl())
                .integral(student.getIntegral())
                .build();

        return ResultUtil.success(HttpStatus.CREATED, studentDto);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid StudentRequest studentRequest,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【学生更新】参数不正确，studentRequest = {}", studentRequest);
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "注册信息必须填写完整 ");
        }

        Student student = new Student();
        student.setId(studentRequest.getId());
        if (studentRequest.getAvatarUrl() != null) {
            student.setAvatarUrl(studentRequest.getAvatarUrl());
        }

        if (studentRequest.getPassword() != null) {
            student.setPassword(studentRequest.getPassword());
        }

        if (studentRequest.getTelephone() != null) {
            student.setTelephone(studentRequest.getTelephone());
        }

        if (studentRequest.getUsername() != null) {
            student.setUsername(studentRequest.getUsername());
        }

        Student update = studentService.update(student);
        StudentDto studentDto = StudentDto.builder()
                .id(update.getId())
                .username(update.getUsername())
                .telephone(update.getTelephone())
                .avatarUrl(update.getAvatarUrl())
                .integral(update.getIntegral())
                .build();
        return ResultUtil.success(HttpStatus.CREATED, studentDto);
    }

    @PutMapping("/signIn")
    public ResponseEntity signIn(@RequestParam("id") Integer id) {
        if (id == null) {
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "学生ID不能为空");
        }

        Student student = studentService.queryById(id);
        if (student == null) {
            return ResultUtil.error(HttpStatus.NOT_ACCEPTABLE, "该学生不存在");
        }
        ZoneId zoneId = ZoneId.systemDefault();

        Instant now = Instant.now();
        int dayOfYearNow = now.atZone(zoneId).toLocalDate().getDayOfYear();

        Instant updateTime = student.getUpdateTime();
        int dayOfYearUpdateTime = updateTime.atZone(zoneId).toLocalDate().getDayOfYear();

        if (updateTime.isBefore(now) && dayOfYearUpdateTime < dayOfYearNow) {
            student.setIntegral(student.getIntegral() + INTEGRAL);
            student.setUpdateTime(now);
            Student update = studentService.update(student);
            StudentDto studentDto = StudentDto.builder()
                    .id(update.getId())
                    .username(update.getUsername())
                    .telephone(update.getTelephone())
                    .avatarUrl(update.getAvatarUrl())
                    .integral(update.getIntegral())
                    .build();
            return ResultUtil.success(HttpStatus.CREATED, studentDto);
        }
        return ResultUtil.error(HttpStatus.OK, "今天已经签过到了，请不要重复");
    }

}
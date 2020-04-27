package pers.edwin.study.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pers.edwin.study.dto.NameListDto;
import pers.edwin.study.entity.Course;
import pers.edwin.study.service.CourseService;
import org.springframework.web.bind.annotation.*;
import pers.edwin.study.util.ResultUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Course)表控制层
 *
 * @author makejava
 * @since 2020-04-28 00:24:36
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;

    /**
     * 查询所有的类型
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity queryList() {
        List<Course> courseList = courseService.queryAll();
        List<NameListDto> nameListDtoList = NameListDto.fromCourseList(courseList);
        return ResultUtil.success(HttpStatus.OK, nameListDtoList);
    }

}
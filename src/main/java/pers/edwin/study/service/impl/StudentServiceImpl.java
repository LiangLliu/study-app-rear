package pers.edwin.study.service.impl;

import pers.edwin.study.entity.Student;
import pers.edwin.study.dao.StudentDao;
import pers.edwin.study.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2020-04-25 23:41:35
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer id) {
        return this.studentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return this.studentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student update(Student student) {
        this.studentDao.update(student);
        return this.queryById(student.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.studentDao.deleteById(id) > 0;
    }

    /**
     * 检查电话号码是否已经存在
     *
     * @param telephone 注册的电话号码
     * @return 如果存在就返回false
     */
    @Override
    public boolean check(String telephone) {
        List<Student> students = studentDao.queryAll(Student.builder().telephone(telephone).build());
        return students.size() == 0;
    }

    @Override
    public Student login(String telephone, String password) {
        List<Student> students = studentDao.queryAll(Student.builder()
                .telephone(telephone)
                .password(password)
                .build());
        if (students.size() > 0) {
            return students.get(0);
        }
        return null;
    }
}
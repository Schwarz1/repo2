package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * @author liu
 * @description CourseService实现类
 * @date 2021/7/11 22:34
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    /*
        多条件查询课程信息
     */
    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {
        return courseMapper.findCourseByCondition(courseVO);
    }

    /*
        保存课程和讲师信息
     */
    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        // 封装课程信息
        Course course = new Course();
        BeanUtils.copyProperties(course, courseVO);
        // 补全课程信息
        Date now = new Date();
        course.setCreateTime(now);
        course.setUpdateTime(now);
        // 保存课程信息
        courseMapper.saveCourse(course);

        // 封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVO);
        teacher.setCreateTime(now);
        teacher.setUpdateTime(now);
        teacher.setCourseId(course.getId());
        // 保存讲师信息
        courseMapper.saveTeacher(teacher);
    }

    /*
        根据课程Id查询课程信息及讲师信息
     */
    @Override
    public CourseVO findCourseById(Integer id) {
        return courseMapper.findCourseById(id);
    }

    /*
        更新课程及讲师信息
     */
    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        // 封装Course信息
        Course course = new Course();
        BeanUtils.copyProperties(course, courseVO);
        // 补全信息
        Date now = new Date();
        course.setUpdateTime(now);
        // 更新Course信息
        courseMapper.updateCourse(course);

        // 封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVO);
        // 补全信息
        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(now);
        // 更新Teacher信息
        courseMapper.updateTeacher(teacher);
    }

    /*
        课程状态变更
     */
    @Override
    public void updateCourseStatus(Integer id, Integer status) {
        // 补全参数
        Course course = new Course();
        Date now = new Date();
        course.setUpdateTime(now);
        course.setId(id);
        course.setStatus(status);

        // 更新状态
        courseMapper.updateCourseStatus(course);
    }
}

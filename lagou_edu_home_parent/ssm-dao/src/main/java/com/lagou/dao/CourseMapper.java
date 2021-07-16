package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.util.List;

/**
 * @author liu
 * @description 课程信息Dao层
 * @date 2021/7/11 22:23
 */
public interface CourseMapper {
    /*
        多条件查询课程信息
    */
    List<Course> findCourseByCondition(CourseVO courseVO);

    /*
        保存课程信息
     */
    void saveCourse(Course course);

    /*
        保存讲师信息
     */
    void saveTeacher(Teacher teacher);

    /*
        根据课程Id查询课程信息以及讲师信息
     */
    CourseVO findCourseById(Integer courseId);

    /*
        修改课程信息
     */
    void updateCourse(Course course);

    /*
        修改讲师信息
     */
    void updateTeacher(Teacher teacher);

    /*
        状态变更
     */
    void updateCourseStatus(Course course);
}

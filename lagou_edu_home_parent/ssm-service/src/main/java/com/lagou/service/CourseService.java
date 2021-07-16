package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author liu
 * @description 课程信息Service层接口
 * @date 2021/7/11 22:33
 */
public interface CourseService {
    /*
        多条件查询课程信息
     */
    List<Course> findCourseByCondition(CourseVO courseVO);

    /*
        保存课程和讲师信息
     */
    void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /*
        根据课程Id查询课程信息及讲师信息
     */
    CourseVO findCourseById(Integer id);

    /*
        更新课程和讲师信息
     */
    void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /*
        课程状态变更
     */
    void updateCourseStatus(Integer id, Integer status);
}

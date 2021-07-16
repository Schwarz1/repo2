package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

/**
 * @author liu
 * @description
 * @date 2021/7/12 19:40
 */
public interface CourseContentService {
    /*
        根据课程id查询章节信息及关联的课时信息
     */
    List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);
    /*
        根据课程id查询课程名字
     */
    Course findCourseByCourseId(Integer courseId);

    /*
        保存章节信息
     */
    void saveSection(CourseSection courseSection);

    /*
        更新章节信息
     */
    void updateSection(CourseSection courseSection);

    /*
        修改章节状态
     */
    void updateSectionStatus(Integer status, Integer id);

    /*
        保存课时信息
     */
    void saveLesson(CourseLesson courseLesson);

    /*
        更新课时信息
     */
    void updateLesson(CourseLesson courseLesson);
}

package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

/**
 * @author liu
 * @description 章节信息以及课时信息Dao层
 * @date 2021/7/12 19:35
 */
public interface CourseContentMapper {
    /*
        通过课程id，查询该课程的章节与课时信息
     */
    List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);
    /*
        通过课程id查询课程名字
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
    void updateSectionStatus(CourseSection courseSection);

    /*
        保存课时信息
     */
    void saveLesson(CourseLesson courseLesson);

    /*
        修改课时信息
     */
    void updateLesson(CourseLesson courseLesson);
}

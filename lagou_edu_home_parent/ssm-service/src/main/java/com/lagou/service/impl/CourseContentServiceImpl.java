package com.lagou.service.impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author liu
 * @description
 * @date 2021/7/12 19:40
 */
@Service
public class CourseContentServiceImpl implements CourseContentService {
    @Autowired
    private CourseContentMapper courseContentMapper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId) {
        return courseContentMapper.findSectionAndLessonByCourseId(courseId);
    }

    /*
        根据课程id查询章节信息及关联的课时信息
     */
    @Override
    public Course findCourseByCourseId(Integer courseId) {
        return courseContentMapper.findCourseByCourseId(courseId);
    }

    /*
        保存章节信息
     */
    @Override
    public void saveSection(CourseSection courseSection) {
        // 补全参数
        Date date = new Date();
        courseSection.setUpdateTime(date);
        courseSection.setCreateTime(date);

        // 调用dao
        courseContentMapper.saveSection(courseSection);
    }

    /*
        更新章节信息
    */
    @Override
    public void updateSection(CourseSection courseSection) {
        // 补全参数
        Date date = new Date();
        courseSection.setUpdateTime(date);

        // 调用dao
        courseContentMapper.updateSection(courseSection);

    }

    @Override
    public void updateSectionStatus(Integer status, Integer id) {
        // 封装CourseSection数据
        CourseSection courseSection = new CourseSection();
        courseSection.setStatus(status);
        courseSection.setId(id);
        courseSection.setUpdateTime(new Date());

        // 调用接口
        courseContentMapper.updateSectionStatus(courseSection);
    }

    /*
        保存课时信息
     */
    @Override
    public void saveLesson(CourseLesson courseLesson) {
        // 补全参数
        Date date = new Date();
        courseLesson.setCreateTime(date);
        courseLesson.setUpdateTime(date);

        // 调用dao
        courseContentMapper.saveLesson(courseLesson);
    }

    /*
        更新课时信息
     */
    @Override
    public void updateLesson(CourseLesson courseLesson) {
        // 补全参数
        courseLesson.setUpdateTime(new Date());

        // 调用dao接口
        courseContentMapper.updateLesson(courseLesson);
    }
}

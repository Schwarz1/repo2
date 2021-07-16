package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liu
 * @description
 * @date 2021/7/12 19:42
 */
@RestController
@RequestMapping("/courseContent")
public class CourseContentController {
    @Autowired
    private CourseContentService courseContentService;

    /*
        回显章节及课时信息
     */
    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLesson(@RequestParam("courseId") Integer courseId){
        List<CourseSection> list = courseContentService.findSectionAndLessonByCourseId(courseId);
        return new ResponseResult(true, 200, "查询章节与课时信息成功", list);
    }

    /*
        回显课程信息，id及名字
     */
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(@RequestParam("courseId") Integer courseId){
        Course course = courseContentService.findCourseByCourseId(courseId);
        return new ResponseResult(true, 200, "回显课程信息成功", course);
    }

    /*
        保存或修改章节信息
     */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){
        if(courseSection.getId() != null){
            // 修改
            courseContentService.updateSection(courseSection);
            return new ResponseResult(true, 200, "修改章节信息成功", null);
        }else{
            // 新增
            courseContentService.saveSection(courseSection);
            return new ResponseResult(true, 200, "新增章节信息成功", null);
        }
    }

    /*
        更新章节状态
     */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(@RequestParam("id") Integer id,
                                              @RequestParam("status") Integer status){
        courseContentService.updateSectionStatus(status, id);
        Map<String, Integer> map = new HashMap<>();
        map.put("status", status);

        return new ResponseResult(true, 200, "章节状态修改成功", map);
    }

    /*
        更新或修改课时信息
     */
    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResult saveOrUpdateLesson(@RequestBody CourseLesson courseLesson){
        if(courseLesson.getId() != null){
            // 修改
            courseContentService.updateLesson(courseLesson);
            return new ResponseResult(true, 200, "修改课时信息成功", null);
        }else{
            // 保存
            courseContentService.saveLesson(courseLesson);
            return new ResponseResult(true, 200, "保存课时信息成功", null);
        }

    }
}

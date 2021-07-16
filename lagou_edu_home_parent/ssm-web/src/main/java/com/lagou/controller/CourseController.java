package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liu
 * @description 课程模块
 * @date 2021/7/11 22:34
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /*
        多条件查询课程信息
     */
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO){
        List<Course> courseList = courseService.findCourseByCondition(courseVO);
        return new ResponseResult(true, 200, "响应成功", courseList);
    }

    /*
        文件上传及回显
     */
    @RequestMapping("/courseUpload")
    public ResponseResult courseUpload(@RequestParam("file")MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        // 获取资源路径
        String realPath = request.getServletContext().getRealPath("/");
        String substring = realPath.substring(0, realPath.lastIndexOf("ssm-web"));
        String uploadPath = substring + "//upload";

        // 获取文件原始名字
        String originalFilename = multipartFile.getOriginalFilename();
        // 生成新的文件名字：时间+后缀名
        String newFilename = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        // 创建文件目录
        File file = new File(uploadPath, newFilename);
        // 判断文件是否存在
        if(!file.getParentFile().exists()){
            // 如果文件不存在，则创建
            file.getParentFile().mkdirs();
        }

        // 进行文件的上传
        multipartFile.transferTo(file);

        // 响应数据
        // 使用Map封装数据
        Map<String, String> map = new HashMap<>();
        map.put("fileName", newFilename);
        map.put("filePath", "http://localhost:8080/upload/" + newFilename);

        return new ResponseResult(true, 200, "上传成功", map);
    }

    /*
        保存或修改课程信息
     */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        // 通过判断CourseVO中的id是否为null来判断是更新还是新增操作
        if(courseVO.getId() != null){
            // 更新
            courseService.updateCourseOrTeacher(courseVO);
            return new ResponseResult(true, 200, "更新成功", null);
        }else {
            // 新增
            courseService.saveCourseOrTeacher(courseVO);
            return new ResponseResult(true, 200, "添加成功", null);
        }
    }

    /*
        根据课程id查询课程信息及讲师信息
        课程信息回显
     */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id){
        CourseVO course = courseService.findCourseById(id);
        return new ResponseResult(true, 200, "课程信息回显成功", course);
    }

    /*
        课程状态变更
     */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(@RequestParam("id") Integer id,
                                             @RequestParam("status") Integer status){
        courseService.updateCourseStatus(id, status);
        Map<String, Integer> map = new HashMap<>();
        map.put("status", status);
        return new ResponseResult(true, 200, "状态变更成功", map);
    }
}

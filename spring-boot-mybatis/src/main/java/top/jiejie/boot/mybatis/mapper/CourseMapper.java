package top.jiejie.boot.mybatis.mapper;

import top.jiejie.boot.mybatis.entity.Course;

import java.util.List;

public interface CourseMapper {

    /**
     * 查询所有课程（关联查询出每门课程的选课学生）
     * @return List<Course>
     */
    List<Course> selectAll();
}
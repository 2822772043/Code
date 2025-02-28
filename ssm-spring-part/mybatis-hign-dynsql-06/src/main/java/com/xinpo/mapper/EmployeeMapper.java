package com.xinpo.mapper;

import com.xinpo.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

//    根据员工的姓名和工资查询员工的信息
    List<Employee> query(@Param("employeeName") String employeeName,@Param("salary") Double salary);


    List<Employee> queryTrim(@Param("employeeName") String employeeName,@Param("salary") Double salary);

//    根据员工的ID更新员工的数据，要求：传入的name和salary不为空才能更新
    int update(Employee employee);

//  根据两个条件查询，如果姓名不为null 使用姓名查询，如果姓名为null 薪水不为空就使用薪水查询，如果都为空，则查所有
    List<Employee> queryChoose(@Param("employeeName") String employeeName,@Param("salary") Double salary);


//根据id 批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);

//根据id 批量删除
    int deleteBatch(@Param("ids") List<Integer> ids);


    int insertBatch(@Param("list")List<Employee> list);

    int updateBatch(@Param("list")List<Employee> list);


}

package com.xinpo.mapper;


import com.xinpo.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //如果是 增删改 语句直接用int就行当做数字处理

    //指定输出类型 查询语句
    //根据员工ID来查询员工姓名
    String queryNameById(Integer id);

    //根据员工id 查询员工的工资
    String querySalaryById(Integer id);

    Employee selectEmployee (int id);

    Map<String,Object> selectEmpNameAndMaxSalary();

    List<Employee> selectAll();

    List<String> queryNameBySalary(Double salary);

    int insertEmp(Employee employee);


}

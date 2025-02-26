package com.xinpo.mapper;


import com.xinpo.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    Employee selectEmployee(Integer empId);

    int deleteById(Integer id);

    List<Employee> queryBySalary(Double salary);

    int insertEmp(Employee employee);

    List<Employee> queryByNameAndSalary(@Param("name") String name ,@Param("salary") Double salary);

    int insertEmpMap(Map data);

}

package com.xinpo.test;


import com.xinpo.mapper.EmployeeMapper;
import com.xinpo.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MybatisTst {

    @Test
    public void test01() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        String name = mapper.queryNameById(1);

        System.out.println("name = " + name);

        sqlSession.close();

    }

    @Test
    public void testQueryEmpNameAndSalary() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Map<String, Object> resultMap = employeeMapper.selectEmpNameAndMaxSalary();

        Set<Map.Entry<String, Object>> entrySet = resultMap.entrySet();

        for (Map.Entry<String, Object> entry : entrySet) {

            String key = entry.getKey();

            Object value = entry.getValue();


        }
    }


    @Test
    public void testSelectAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sessionFactory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.selectAll();
        for (Employee employee : employeeList) {
//            log.info("employee = " + employee);
        }
    }
}

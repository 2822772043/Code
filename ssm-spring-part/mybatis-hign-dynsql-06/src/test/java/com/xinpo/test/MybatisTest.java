package com.xinpo.test;

import com.xinpo.mapper.EmployeeMapper;
import com.xinpo.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private SqlSession sqlSession ;

    @BeforeEach
    public void init() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = sessionFactory.openSession();

    }


    @Test
    public void test01(){

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> employeeList =  mapper.query("张三",0.0);

        System.out.println("employeeList = " + employeeList);

    }

    @AfterEach
    public void end(){

        sqlSession.close();

    }
}

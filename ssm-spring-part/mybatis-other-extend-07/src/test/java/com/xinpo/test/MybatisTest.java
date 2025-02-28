package com.xinpo.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

        PageHelper.startPage(1,2);

        List<Employee> employeeList =  mapper.queryList();

        System.out.println("employeeList = " + employeeList);

        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);

        List<Employee> list = pageInfo.getList();

        int pages = pageInfo.getPages();

        long total = pageInfo.getTotal();

    }

    @AfterEach
    public void end(){

        sqlSession.close();
    }
}

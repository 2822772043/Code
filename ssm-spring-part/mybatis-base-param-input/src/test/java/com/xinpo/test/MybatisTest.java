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

public class MybatisTest {

    @Test
    public void test01() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.selectEmployee(1);

        System.out.println("employee = " + employee);

        sqlSession.close();


    }


    @Test
    public void test02() throws IOException{

        /*
        * 数据输出
        *
        *   如果执行的是 增删改 默认返回值为int 用 int或者long直接截止
        *
        *
        * */



    }


}

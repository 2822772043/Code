package com.xinpo.test;

import com.xinpo.mapper.CustomerMapper;
import com.xinpo.mapper.OrderMapper;
import com.xinpo.pojo.Customer;
import com.xinpo.pojo.Order;
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
    public void test01() {


        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        Order order = mapper.queryOrderById(1);

        System.out.println("order = " + order);

    }


    @Test
    public void test02() {


        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

        List<Customer> customers = mapper.queryList();

        System.out.println("customers = " + customers);

    }







    @AfterEach
    public void clean(){

        sqlSession.close();

    }

}

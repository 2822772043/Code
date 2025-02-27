package com.xinpo.test;

import com.xinpo.mapper.UserMapper;
import com.xinpo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MybatisTest {

    private SqlSession sqlSession;

    /*



    * */

    //每次执行测试方法之前先走的初始化方法
    // junit会在每一个@Test方法前执行@BeforeEach方法
    @BeforeEach
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSession = sessionFactory.openSession();
    }


    @Test
    public void test01() throws IOException{

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();

        user.setUsername("张三");
        user.setPassword("123");

        int rows = mapper.insert(user);

        System.out.println("rows = " + rows);

        sqlSession.commit();
        sqlSession.close();

    }


    @Test
    public void test02() throws IOException{
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();

        user.setId(1);
        user.setUsername("李四");
        user.setPassword("555");

        int rows = mapper.update(user);

        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void test03() throws IOException{

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int rows = mapper.delete(2);

        System.out.println("rows = " + rows);

        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void test04() throws IOException{
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectById(1);

        System.out.println("user = " + user);

        sqlSession.close();

    }

    @Test
    public void test05() throws IOException{

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selectAll();

        System.out.println("users = " + users);

        sqlSession.close();

    }

}

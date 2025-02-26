package com.xinpo.test;

import com.xinpo.mapper.EmployeeMapper;
import com.xinpo.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class MybatisTst {


    @Test
    public void test01 ()  throws IOException {

        // 1.创建SqlSessionFactory对象
        // ①声明Mybatis全局配置文件的路径
        //第一步：读取外部配置文件
        String mybatisConfigFilePath = "mybatis-config.xml";

        // ②以输入流的形式加载Mybatis配置文件
        SqlSessionFactory sessionFactory;
        try (InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath)) {

            // ③基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }

        // 2.使用SqlSessionFactory对象开启一个会话
        SqlSession session = sessionFactory.openSession();

        // 3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象(动态代理技术)
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        // 4. 调用代理类方法既可以触发对应的SQL语句
        Employee employee = employeeMapper.selectEmployee(1);

        System.out.println("employee = " + employee);

        // 4.关闭SqlSession
        session.commit(); //提交事务 [DQL不需要,其他需要]
        session.close(); //关闭会话

    }

    @Test
    public void test02()  throws IOException {


//        第一步，读取外部配置文件
        /*
        * 这行代码的作用是通过 Resources 类读取一个名为 mybatis-config.xml 的配置文件，并将其作为输入流返回。
        * •mybatis-config.xml 是 MyBatis 的配置文件，
        * 其中包含了数据库连接信息、事务管理、映射文件路径等配置。•
        * Resources.getResourceAsStream 是 MyBatis 提供的一个工具方法，
        * 用于从类路径下读取资源文件。*/
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

//        创建sqlSessionFactory
        /*
        •SqlSessionFactory 是 MyBatis 的核心接口之一，用于创建 SqlSession 实例。
        •SqlSessionFactoryBuilder 是用来构建 SqlSessionFactory 的工厂类。
        •build(inputStream) 方法会读取 inputStream 中的配置信息（即 mybatis-config.xml），
        并根据这些配置信息构建出一个 SqlSessionFactory 实例。
        */
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        根据SqlSessionFactory 创建一个SqlSession 每个业务创建一个，用完就释放
        /*
        •SqlSession 是 MyBatis 中用于执行数据库操作的接口。
        •openSession() 方法会根据 SqlSessionFactory 的配置创建一个新的 SqlSession 实例。
        •每个 SqlSession 实例都是独立的，用于执行一个具体的业务操作，使用完后应该及时关闭以释放资源。
        */
        SqlSession sqlSession = sessionFactory.openSession();

//        获取接口的代理对象（代理技术），调用代理对象的方法，就会查找mapper接口的方法
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployee(1);
        System.out.println("employee = " + employee);

//        提交事务以及资源释放
        sqlSession.close();


    }
    @Test
    public void test03() throws IOException{

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sessionFactory.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.selectEmployee(1);

        System.out.println("employee = " + employee);

        sqlSession.close();

    }

}

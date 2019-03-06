package test;


import com.test.mapper.UserMapper;
import com.test.mapper.UserMapper1;
import com.test.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 *
 */
public class TestFind {

    @Test
    public void selectUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatisconfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper1 mapper = sqlSession.getMapper(UserMapper1.class);
        User user = mapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void insertUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatisconfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setSex("男");
        user.setAddress("sss2s");
        user.setUsername("sss2w");
        sqlSession.insert("test.insertUser",user);
        int i=user.getId();
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
}

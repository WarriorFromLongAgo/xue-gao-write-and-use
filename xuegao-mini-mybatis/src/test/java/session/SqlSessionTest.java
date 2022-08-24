package session;

import com.alibaba.fastjson2.JSON;
import com.xuegao.minimybatis.io.Resources;
import com.xuegao.minimybatis.session.SqlSession;
import com.xuegao.minimybatis.session.SqlSessionFactory;
import com.xuegao.minimybatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class SqlSessionTest {

    @Test
    public void setup() throws Exception {
        final String resource = "mybatis-config.xml";
        final InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlMapper.openSession();
        List<Object> selectList = sqlSession.selectList("builder.AuthorMapper.selectAuthor");
        System.out.println(JSON.toJSONString(selectList));
    }

}

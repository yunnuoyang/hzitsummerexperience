import com.mybatis.mapper.IStudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.HashMap;
import java.util.Map;

public class TestSqlSession2 {
    static SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
    static SqlSessionFactory build = sfb.build(TestSqlSession2.class.getClass().getResourceAsStream("/mybatis-config.xml"));
    static SqlSession sqlSession = build.openSession();
    public static void main(String[] args) {
//        testSelectObj();

        testFix();
    }
    public static void testSelectObj(){
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        Map map=new HashMap();
        map.put("sno",3);
        map.put("sname","刘老三");
        sqlSession.insert("insert",map);
        sqlSession.commit();

    }
    private static void testFix(){
        Map map=new HashMap();
        map.put("sno",1);
        map.put("sname","刘老三");
        sqlSession.update("fix",map);
        sqlSession.commit();
    }


}

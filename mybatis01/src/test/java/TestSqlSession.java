import com.mybatis.mapper.IStudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestSqlSession {
    static SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
    static SqlSessionFactory build = sfb.build(TestSqlSession.class.getClass().getResourceAsStream("/mybatis-config.xml"));
    static SqlSession sqlSession = build.openSession();
    public static void main(String[] args) {
//        testInitParam();
//        testMap();
        testSelectObj();

    }
    public static void testSelectObj(){
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        Object[] integer = mapper.selectObj();
        System.out.println(Arrays.toString(integer));
    }


    /**
     * 生成的sql:select count(*) from student where sno=2
     */
    public  static void testMap(){
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        Map map=new HashMap();
        map.put("sno",2);
        Integer integer = mapper.count$(map);
        System.out.println(integer);
    }

    /**
     * 生成的sql:select count(*) from student where sno=?
     */
    public  static void testInitParam(){
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        Integer count = mapper.count2(1);
        System.out.println(count);
    }

}

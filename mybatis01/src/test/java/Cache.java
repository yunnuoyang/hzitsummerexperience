import com.mybatis.mapper.IStudentMapper;
import com.mybatis.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class Cache {
    static SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
    static SqlSessionFactory build = sfb.build(TestSqlSession2.class.getClass().getResourceAsStream("/mybatis-config.xml"));
    static SqlSession sqlSession = build.openSession();
// Cache Hit Ratio [com.mybatis.mapper.IStudentMapper]: 0.5
    public static void main(String[] args) {
t1();
        SqlSession sqlSession = build.openSession();
        IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
        List<Student> students = studentMapper.querryQritirea(null);
        students.forEach(s->{
            System.out.println(s.getSname());
        });

    }
    private static void t1(){
        IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);
        List<Student> students = studentMapper.querryQritirea(null);
        students.forEach(s->{
            System.out.println(s.getSname());
        });
        sqlSession.close();
    }
}

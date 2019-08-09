import com.mybatis.mapper.ISchoolMapper;
import com.mybatis.mapper.IStudentMapper;
import com.mybatis.pojo.School;
import com.mybatis.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class TestAssosiation {
    static SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
    static SqlSessionFactory build = sfb.build(TestSqlSession2.class.getClass().getResourceAsStream("/mybatis-config.xml"));
    static SqlSession sqlSession = build.openSession();

    public static void main(String[] args) {
        IStudentMapper student = sqlSession.getMapper(IStudentMapper.class);
        List<Student> list = student.getAssosiation();
        list.forEach(s -> {
            System.out.println(s.getSname()+s.getSchool().getScname());
        });


    }
}

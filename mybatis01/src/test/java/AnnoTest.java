import com.mybatis.mapper.ISchoolAnnoMapper;
import com.mybatis.mapper.IStudentMapper;
import com.mybatis.mapper.IStudentMapperDen;
import com.mybatis.pojo.School;
import com.mybatis.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class AnnoTest {
    static SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
    static SqlSessionFactory build = sfb.build(TestSqlSession2.class.getClass().getResourceAsStream("/mybatis-config.xml"));
    static SqlSession sqlSession = build.openSession();
    public static void main(String[] args) {

        critiera();
    }
    public static void critiera(){
        IStudentMapperDen mapper = sqlSession.getMapper(IStudentMapperDen.class);
        Student student=new Student();
        student.setSname("%张%");
        Student student1 = mapper.getStudent(student);
        System.out.println(student1.getSname()+"==="+student1.getSno());
    }


    private void find(){

        ISchoolAnnoMapper mapper = sqlSession.getMapper(ISchoolAnnoMapper.class);
        List<School> school = mapper.getSchool(1);
        school.forEach(s->{
            System.out.println(s.getScname());
        });
    }
    }


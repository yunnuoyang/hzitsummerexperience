import com.mybatis.mapper.ISchoolMapper;
import com.mybatis.mapper.IStudentMapper;
import com.mybatis.pojo.School;
import com.mybatis.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class OneToOne {
    static SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
    static SqlSessionFactory build = sfb.build(TestSqlSession2.class.getClass().getResourceAsStream("/mybatis-config.xml"));
    static SqlSession sqlSession = build.openSession();

    public static void main(String[] args) {
//        OneToMany();

OneToOne();
OneToOne();
//OneToMany();
//querryQritirea();
    }
    public static void querryQritirea(){
        IStudentMapper student = sqlSession.getMapper(IStudentMapper.class);
        Student stu=new Student();
        stu.setSname("%s%");
        List<Student> list = student.querryQritirea(stu);
        list.forEach(s -> {
            System.out.println(s.getSname());
        });
    }

    public static void OneToOne(){
        IStudentMapper student = sqlSession.getMapper(IStudentMapper.class);
        List<Student> list = student.getLink();
        list.forEach(s -> {
            System.out.println("one="+s.getSname());
        });
        System.out.println("=======从二级缓存中读取数据============");
        sqlSession.clearCache();
//        sqlSession.close();
//        List<Student> lists = student.getLink();
//        lists.forEach(s -> {
//            System.out.println("two="+s.getSname());
//        });

//        list.forEach(s->{
//            System.out.println("============");
//            System.out.println(s.getSname()+s.getSchool().getScname());
//        });
    }
    public static void OneToMany(){
        ISchoolMapper schoolMapper = sqlSession.getMapper(ISchoolMapper.class);
        List<School> ofSchool = schoolMapper.getUnderStudentsOfSchool();
        for (School school:ofSchool) {
            System.out.println(school.getScname()+school.getStudent().size());
        }
    }
}

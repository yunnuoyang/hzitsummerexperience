import com.mybatis.pojo.School;
import com.mybatis.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestSchool {
    static SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
    static SqlSessionFactory build = sfb.build(TestSqlSession2.class.getClass().getResourceAsStream("/mybatis-config.xml"));
    static SqlSession sqlSession = build.openSession();

    public static void main(String[] args) {
        School school=new School();
        school.setScid(1);
        school.setScname("友谊中学");
        sqlSession.insert("addSchool",school);
        Student student=new Student();
        student.setSno(3);
        student.setSname("林秦吉");
        student.setScid(school.getScid());
        sqlSession.insert("insert",student);
        sqlSession.commit();

    }
}

import com.mybatis.mapper.ISchoolMapper;
import com.mybatis.pojo.School;
import com.mybatis.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class AliasTest {
    static SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
    static SqlSessionFactory build = sfb.build(TestSqlSession2.class.getClass().getResourceAsStream("/mybatis-config.xml"));
    static SqlSession sqlSession = build.openSession();

    public static void main(String[] args) {
        ISchoolMapper school = sqlSession.getMapper(ISchoolMapper.class);
        List<School> schoolByOrder = school.getSchoolByOrder();
        List<School> schools = school.find();
        schoolByOrder.forEach((s)->{
            System.out.println(s.getScid()+s.getScname());
        });

    }
}

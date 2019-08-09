import com.mybatis.mapper.IEmpMapper;
import com.mybatis.pojo.Emp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class TypeHandlerTest {
    static SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
    static SqlSessionFactory build = sfb.build(TestSqlSession2.class.getClass().getResourceAsStream("/mybatis-config.xml"));
    static SqlSession sqlSession = build.openSession();
    public static void main(String[] args) {
        IEmpMapper empMapper = sqlSession.getMapper(IEmpMapper.class);
        Emp emp=new Emp();
        emp.setId(4);
        emp.setName("join");
        emp.setSex("女");
        empMapper.addEmp(emp);
        sqlSession.commit();
    }
    public static void test(){
        IEmpMapper empMapper = sqlSession.getMapper(IEmpMapper.class);
        List<Emp> emp = empMapper.getEmp();
        emp.forEach(e->{
            System.out.println(e.getName()+e.getSex());
        });
    }
}

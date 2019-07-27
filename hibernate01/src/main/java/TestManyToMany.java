import com.hibernate.pojo.Employee;
import com.hibernate.pojo.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

public class TestManyToMany {
    @Test
    public void save(){
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Project project=new Project();
        project.setPname("雨霏霏");
        Employee emp=new Employee();
        emp.setEname("赵小六");
        Employee emp2=new Employee();
        emp2.setEname("灵儿");
        Set<Employee> employees = project.getEmployees();
        employees.add(emp);
        employees.add(emp2);
        project.setEmployees(employees);
        session.save(project);
        transaction.commit();
        session.close();
    }
    @Test
    public void get(){
        Session session = HibernateUtils.getSession();
        Transaction tran = session.beginTransaction();
        Employee employee = session.get(Employee.class, 1);
        Set<Project> projects = employee.getProjects();
        for(Project project:projects){
            System.out.println(project.getPname());
        }
        tran.commit();
        session.close();
    }
}

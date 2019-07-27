import com.hibernate.pojo.Account;
import com.hibernate.pojo.Detail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.sql.Date;

public class HibernateTestOne {
    @Test
    public void saveOneToOne(){
        Session session = HibernateUtils.getSession();
        Transaction tran = session.beginTransaction();
        Account account=new Account();
        account.setAccname("90738284848");
        account.setAccpass("中国邮政");
        Detail detail=new Detail();
        detail.setUsername("张三");
        detail.setBirthday(new Date(System.currentTimeMillis()));
        detail.setEmail("1334732898@qq.com");
        detail.setAccountByAccid(account);
        session.save(detail);
        tran.commit();
        session.close();
    }
    @Test
    public void getOneToOne(){
        Session session = HibernateUtils.getSession();
        Account account = session.load(Account.class, 2);
        System.out.println("================");
        System.out.println(account.getDetailByAccid().getUsername());
        session.close();
    }
}

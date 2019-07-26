package com.hibernate.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**恒志实训day7/26
 *
 * **/
public class JdbcTest {
    public static void main(String[]args){
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/demo";
        String userName="root";
        String passWord="root";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,userName,passWord);
            System.out.println(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

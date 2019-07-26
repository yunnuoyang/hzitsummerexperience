package com.wdzl.hibernate.framework;

import com.hibernate.pojo.Goods;
import com.hibernate.pojo.Goods2;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Session {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/demo";
    static String userName = "root";
    static String passWord = "root";
    static Connection connection;

    static {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, passWord);
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
    }

    private String resourcePath = "/goods.hbm.xml";
    private Map<String, String> map;

    public Session() {
        //初始化时加载配置文件资源，进行解析
        try {
            parseXML(resourcePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Session s = new Session();
        Goods2 goods = new Goods2();
        goods.setName("大熊");
        goods.setPrice(22.2);
        s.save(goods);
    }

    public void save(Object obj) {
        if (connection == null) {
            throw new RuntimeException("无法获得数据库连接....");
        }
        String critQuerySql = toInsert(obj);
        try {
            PreparedStatement pstmt = connection.prepareStatement(critQuerySql);
            toPastValue(obj, pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 进行动态的赋值操作
     *
     * @param obj
     * @param pstmt
     */
    private void toPastValue(Object obj, PreparedStatement pstmt) throws Exception {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            //获取属性的名称
            String propName = declaredFields[i].getName();
            //生成getter方法
            String getName = "get" + propName.substring(0, 1).toUpperCase() + propName.substring(1);
            //获取到当前对象的方法
            Method targetMethod = obj.getClass().getDeclaredMethod(getName);
            Object value = targetMethod.invoke(obj);
            System.out.println(value);
            pstmt.setObject(i + 1, value);
        }
    }

    /**
     * 动态的生成sql语句
     *
     * @param obj
     * @return
     */
    public String toInsert(Object obj) {
        //获取所有的属性
        Field[] props = obj.getClass().getDeclaredFields();
        //获取此类的类名用作表名称
//        String tableName = obj.getClass().getSimpleName();
//        System.out.println(obj.getClass().getName());
        String tableName=map.get(obj.getClass().getName());
        System.out.println(tableName);
        //参数的个数绑定
        String params = "";
        //列名称即："?"
        String colsName = "";
        for (Field f : props) {
            colsName += map.get(f.getName()) + ",";
            params += "?,";
        }
        colsName = colsName.substring(0, colsName.length() - 1);
        params = params.substring(0, params.length() - 1);
        StringBuffer sbf = new StringBuffer();
        sbf.append("insert into ")
                .append(tableName)
                .append("(")
                .append(colsName)
                .append(") values (")
                .append(params)
                .append(")");
        System.out.println(sbf.toString());
        return sbf.toString();
    }
    /**
     * 解析映射文件通过dom4j来进行
     */

    public void parseXML(String path) throws Exception {
        map = new HashMap<>();
        SAXReader saxReader = new SAXReader();
        InputStream inputStream = getClass().getResourceAsStream(path);
        Document rootNode = saxReader.read(inputStream);
        Element rootElement = rootNode.getRootElement();
        //获取标签的属性的值
        String className = rootElement.attributeValue("className");
        String tableName = rootElement.attributeValue("tableName");
        map.put(className, tableName);
        //获取跟标签为property的所有子节点
        List<Element> property = rootElement.elements("property");
        for (Element element : property) {
            //获取标签上的name,columnName属性的值
            String filedName = element.attributeValue("name");
            String columnName = element.attributeValue("columnName");
            map.put(filedName,columnName);
        }

    }


}

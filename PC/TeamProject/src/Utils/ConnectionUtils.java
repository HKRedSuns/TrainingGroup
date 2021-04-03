package Utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具包,用于返回数据库连接对象和关闭数据库连接对象
 *
 */
public class ConnectionUtils {
    //定义四个基础变量
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/TeamProject?characterEncoding=utf8&useSSL=false&serverTimezone = GMT";
    //用户名和密码
    private static final String root = "admin";
    private static final String password = "123";

    private static Connection conn;

    /**
     * 定义一个返回数据库连接对象的方法
     * @return 返回的数据库连接对象
     */
    public static Connection getConn(){
        try{
            //反射
            Class.forName(driver);
            //连接数据库
            conn = DriverManager.getConnection(url,root,password);
            System.out.println("数据库连接成功!");
            //返回数据库对象
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("数据库连接失败!");
            return null;
        }
    }

    /**
     * 定义一个关闭数据库连接对象的方法
     */
    public static void CloseConn(){
        try{
            conn.close();
            System.out.println("数据库关闭成功!");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库关闭失败!");
        }
    }
}

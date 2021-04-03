package Controllter;

import Data.User;
import Utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对用户的信息进行逻辑处理
 * 用户注册
 * 用户登录
 * 查询用户信息等
 */
public class UserControllter {
    //编写一个方法,验证用户登录是否成功
    public int userLogin(String name,String pass) {
        //定义一个返回给调用者的结果
        int result = 0;
        //定义一个数据库连接对象
        Connection conn = null;
        //定义一个SQL操作对象
        PreparedStatement ment = null;
        //用户对象
        User user = null;
        //sql语句结果对象
        ResultSet rs = null;
        //初始化SQl语句
        String sql = "select * from user where name=?";
        try {
            //获取数据库连接对象
            conn = ConnectionUtils.getConn();
            //获取ment对象
            ment = conn.prepareStatement(sql);
            ment.setString(1, name);
            //获取sql语句返回值
            rs = ment.executeQuery();
            if (rs.next()) {
                //创建一个用户
                user = new User();
                //获取数据库数据并且赋值给javaBean对象
                user.setUserName(rs.getString("name"));
                user.setUserPassword(rs.getString("password"));
                //验证
                System.out.println(user.getUserName());
                System.out.println(user.getUserPassword());
            }
            //关闭数据库
            ConnectionUtils.CloseConn();
            //判断用户是否为空 空就返回0
            if (user == null) return 0;
                //判断用户密码是否正确,不正确返回-1
            else if (!user.getUserPassword().equals(pass)) return -1;
                //用户名和密码都正确返回1
            else return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //默认返回0 标识用户名错误
        return result;
    }
}

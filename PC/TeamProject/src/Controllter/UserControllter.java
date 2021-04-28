package Controllter;

import Data.User;
import Utils.ConnectionUtils;
import com.mysql.cj.protocol.Resultset;

import javax.xml.stream.FactoryConfigurationError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对用户的信息进行逻辑处理
 * 用户注册
 * 用户登录
 * 查询用户信息等
 */
public class UserControllter {
    //编写一个方法,验证用户登录是否成功
    public User userLogin(String name,String pass) {
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
                user.setHeadImg(rs.getString("headimg"));
                //验证
                //System.out.println(user.getUserName());
                //System.out.println(user.getUserPassword());
                //System.out.println(user.getHeadImg());  //1
            }
            //关闭数据库
            ConnectionUtils.CloseConn();
            /*//判断用户是否为空 空就返回0
            if (user == null) return 0;
                //判断用户密码是否正确,不正确返回-1
            else if (!user.getUserPassword().equals(pass)) return -1;
                //用户名和密码都正确返回1
            else return 1;*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //默认返回0 标识用户名错误
        return user;
    }

    //编写一个方法,验证用户注册时用户名和在数据库中是否存在
    public int UserName_Verification(String name){
        //定义一个数据库连接对象
        Connection conn = null;
        //定义一个SQL操作对象
        PreparedStatement ment = null;
        //数据库查询结果
        String SQL_result = null;
        //sql语句结果对象
        ResultSet rs = null;
        //初始化SQl语句
        String sql = "select 1 as result from user where name=? limit 1";
        try {
            //获取数据库连接对象
            conn = ConnectionUtils.getConn();
            //获取ment对象
            ment = conn.prepareStatement(sql);
            ment.setString(1,name);
            //获取sql语句返回值
            rs = ment.executeQuery();
            if(rs.next()){
                //获取查询结果
                SQL_result = rs.getString("result");
                //判断查询结果
                return 1;
                //System.out.println(SQL_result);
            }else{
                //没有数据则表示失败
                return -1;
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("用户名查询失败!");
        }
        return -1;
    }

    //编写一个方法,将用户注册的数据添加到数据库中
    public boolean InsertUser(String UserName,String PassWord,String UserEmail){
        //连接数据库
        Connection conn = null;
        //定义一个SQL操作对象
        PreparedStatement ment = null;
        //数据库查询结果
        boolean isRegister = false;
        //SQL语句结果对象
        ResultSet rs = null;

        //用户ID
        int userID = 0;

        //查询用户表中的最后一条数据
        String lastData_SQl = "select * from user order by id DESC limit 1";
        //添加用户数据
        String insertData_SQl = "insert into user(ID,name,password,email,regTime) values(?,?,?,?,?)";
        try{
            //获取连接对象
            conn = ConnectionUtils.getConn();
            //获取ment对象
            ment = conn.prepareStatement(lastData_SQl);
            rs = ment.executeQuery();
            if(rs.next()){
                userID = rs.getInt("ID")+1;
                //System.out.println(userID);
            }
            //获取当前时间
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");      //设置日期格式
            String regTime = df.format(new Date());                                         //new Data()为获取当前系统时间
            //System.out.println(regTime);
            //重置ment对象
            ment = conn.prepareStatement(insertData_SQl);
            //添加数据
            ment.setInt(1,userID);
            ment.setString(2,UserName);
            ment.setString(3,PassWord);
            ment.setString(4,UserEmail);
            ment.setString(5,regTime);
            if(ment.executeUpdate()!=0){
                isRegister = true;
            }else{
                isRegister = false;
            }
            //关闭数据库
            ConnectionUtils.CloseConn();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return isRegister;
    }

    //编写一个方法,判断用户表中是否存在相同邮箱
    public int retrieveVerification(String emil){
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
        String sql = "select * from user where email=?";
        try {
            //获取数据库连接对象
            conn = ConnectionUtils.getConn();
            //获取ment对象
            ment = conn.prepareStatement(sql);
            ment.setString(1, emil);
            //获取sql语句返回值
            rs = ment.executeQuery();
            if (rs.next()) {
                //创建一个用户
                user = new User();
                //获取数据库数据并且赋值给javaBean对象
                user.setEmail(rs.getString("email"));
                //验证
                System.out.println(user.getEmail());
            }
            //关闭数据库
            ConnectionUtils.CloseConn();
            //判断邮箱是否为空 空就返回0
            if (user == null) return 0;
            //正确返回1
            else return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //默认返回0 标识用户名错误
        return result;
    }

    //编写一个方法,修改用户密码
    public boolean UpdatePassword(String email,String newPassword){
        //连接数据库
        Connection conn = null;
        //定义一个SQL操作对象
        PreparedStatement ment = null;
        //数据库查询结果
        boolean isRegister = false;
        //SQL语句结果对象
        ResultSet rs = null;
        //更改用户数据
        String sql = "update user set password=? where email=?";
        try{
            //获取连接对象
            conn = ConnectionUtils.getConn();
            //获取ment对象
            ment = conn.prepareStatement(sql);
            //添加数据
            ment.setString(1,newPassword);
            ment.setString(2,email);
            if(ment.executeUpdate()!=0){
                isRegister = true;
            }else{
                isRegister = false;
            }
            //关闭数据库
            ConnectionUtils.CloseConn();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return isRegister;
    }

    //编写一个方法，通过ID获取用户头像路径
    public String getHeadImg(String index){
        if(index.equals("0"))return null;
        //定义一个数据库连接对象
        Connection conn = null;
        //定义一个SQL操作对象
        PreparedStatement ment = null;
        //返回结果
        ResultSet rs = null;
        //sql语句
        String sql = "select * from headimg where img_ID=?";
        try{
            conn = ConnectionUtils.getConn();
            ment = conn.prepareStatement(sql);
            ment.setString(1,index);
            rs = ment.executeQuery();
            if(rs.next()){
                //System.out.println(rs.getString("img_Percorso"));
                return rs.getString("img_Percorso");
            }
            ConnectionUtils.CloseConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  null;
    }
}

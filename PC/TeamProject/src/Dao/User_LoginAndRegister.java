package Dao;

import Bean.User;
import Utils.ConnectionUtil;
import Utils.UseUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * 用户登录注册的逻辑代码类
 */
public class User_LoginAndRegister {

    private JdbcTemplate temp = new JdbcTemplate(ConnectionUtil.getDataSource());
    //用户登录方法
    public User UserLogin(String name, String pass){
        //SQl语句
        String sql = "select t1.*,t2.img_Percorso as img from user t1,headimg t2 where t1.User_Name=? AND t1.User_Pass=? AND t1.User_HeadImg=t2.img_ID";
        //将结果集封装为JavaBean对象
        List<User> list = temp.query(sql,new Object[]{name,pass},new BeanPropertyRowMapper<>(User.class));
        //有数据就返回
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    //用户注册方法
    public boolean UserInsert(String IP,String UserName,String Pass,String UserEmail){
        String sql = "insert into user(User_IP,User_Name,User_Pass,User_Email,User_RegTime,User_Birthday) values(?,?,?,?,?,?)";
        String date = UseUtils.getRunTiem();
        int count = temp.update(sql,IP,UserName,Pass,UserEmail,date,date);
        return count==1;
    }

    //用户忘记密码方法
    public boolean UserUpdatePass(String newPass,String Email){
        String sql = "update user set User_Pass=? where User_Email=?";
        int count = temp.update(sql,newPass,Email);
        return count==1;
    }

    //验证用户名是否相同
    public int UserName_Check(String name){
        //SQL
        String sql = "select count(User_ID) from user where User_Name=?";
        int number = temp.queryForObject(sql,new Object[]{name},Integer.class);
        return number;
    }

    //验证用户表中是否存在相同邮箱
    public boolean UserEmail_Check(String Email){
        String sql = "select count(User_ID) from user where User_Email=?";
        int number = temp.queryForObject(sql,new Object[]{Email},Integer.class);
        return number==1;
    }

}

package Dao;

import Bean.User;
import Utils.ConnectionUtil;
import Utils.UseUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;

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
    public boolean UserInsert(HttpServletRequest request,String IP, String UserName, String Pass, String UserEmail){
        String sql = "insert into user(User_IP,User_Name,User_Pass,User_Email,User_RegTime,User_Birthday,User_Str) values(?,?,?,?,?,?,?)";
        String date = UseUtils.getRunTiem();
        String Str = "大家好，我是"+UserName+"，很高兴和大家认识";
        int count = temp.update(sql,IP,UserName,Pass,UserEmail,date,date,Str);
        //判断是否注册成功，用户注册成功就给用户新建一个文件夹
        if(count==1){
            String sql3 = "select User_ID from user where User_Name=?";
            Map<String, Object> map = temp.queryForMap(sql3, UserName);
            String userid = map.get("User_ID").toString();
            File file = new File(request.getServletContext().getRealPath("")+"/User/"+UserName);
            //没有对应的文件夹，就创建
            if(!file.exists())file.mkdir();
            //给用户添加一篇系统文章
            String sql1 = "insert into \n" +
                    "\tblog(Blog_Title,Blog_Content,Blog_UserID,Blog_ReleaseDate,Blog_ContextStr) \n" +
                    "VALUE \n" +
                    "\t(?,?,?,?,?)";
            String content = "欢迎使用食上达人博客，希望你在接下来的使用过程中体验良好，有任何问题请联系管理员";
            int count1 = temp.update(sql1,"你好新用户！",content,userid,date,content);
        }
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

package Tests;

import Bean.Blog;
import Bean.Personal;
import Bean.User;
import Dao.Blog_Edit;
import Dao.User_LoginAndRegister;
import Utils.ConnectionUtil;
import Utils.MailUtil;
import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class ConnectionUtilTest {

    Gson gson = new Gson();
    JdbcTemplate temp = new JdbcTemplate(ConnectionUtil.getDataSource());
    //获取连接
    @Test
    public void GetConnTest(){
        try {
            for(int i=0;i<20;i++){
                Connection conn = ConnectionUtil.getConn();
                System.out.println(i+"==>"+conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //登录测试
    @Test
    public void LoginTest(){
        //获取JDBCTemplate对象
        temp = new JdbcTemplate(ConnectionUtil.getDataSource());
        //SQl语句
        String sql = "select t1.*,t2.img_Percorso as img from user t1,headimg t2 where t1.User_Name=? AND t1.User_Pass=? AND t1.User_HeadImg=t2.img_ID";
        //List<User> list = temp.query(sql,new BeanPropertyRowMapper<User>(User.class));
        List<User> list = temp.query(sql,new Object[]{"Jaoden","123456"},new BeanPropertyRowMapper<>(User.class));
        System.out.println(list);
    }
    //用户名判重测试
    @Test
    public void userNameCheck(){
        temp = new JdbcTemplate(ConnectionUtil.getDataSource());
        //SQL
        String sql = "select count(User_ID) from user where User_Name=?";
        long total = temp.queryForObject(sql,new Object[]{"js"},Long.class);
        System.out.println(total);

    }
    //注册功能测试
    @Test
    public void registerTest(){
        JdbcTemplate temp = new JdbcTemplate(ConnectionUtil.getDataSource());
        //SQL
        String sql = "insert into user(User_IP,User_Name,User_Pass,User_Email,User_RegTime)values(?,?,?,?,?)";
        int count = temp.update(sql,111,"Jkm","1234","123456@qq.com","2021-04-25");
        System.out.println(count);
    }
    //忘记密码功能测试
    @Test
    public void  retrieveTest(){
        User_LoginAndRegister user = new User_LoginAndRegister();
        if(user.UserUpdatePass("111","1835784566@qq.com")){
            System.out.println("成功！");
        }else {
            System.out.println("失败！");
        }

    }
    //获取文章的所有数据测试
    @Test
    public void getJsonBlogTest(){
        JdbcTemplate temp = new JdbcTemplate(ConnectionUtil.getDataSource());
        //String sql = "select * from blog";
        String sql = "select Blog_ID,Blog_Title,Blog_Content,Blog_UserID,Blog_Likes,Blog_ImgID,Blog_ReleaseDate,Blog_Comment,Blog_ContextStr from blog";
        List<Blog> list = temp.query(sql,new BeanPropertyRowMapper<>(Blog.class));
   /*     for(Blog blog : list){
            System.out.println(blog);
        }*/
        //转换为Json对象
        String str = gson.toJson(list);
        System.out.println(str);
    }
    //测试邮件发送功能
    @Test
    public void SendEmailTest(){
        System.out.println(MailUtil.SendMail("1835784566@qq.com", "123"));
    }
    //测试发布文章功能
    @Test
    public void addBlog(){
        Blog blog = new Blog();
//        blog.setBlog_Title("Jaoden");
//        blog.setBlog_ContextStr("欢迎大家，我希望和大家皮带能否");
//        blog.setBlog_Content("欢迎大家，我希望和大家皮带能否");
        blog.setBlog_UserID("1");
//        blog.setBlog_ReleaseDate(UseUtils.getRunTiem());
        Blog_Edit edit = new Blog_Edit();
        System.out.println(edit.getUserName(blog));
    }

    //测试用户
    @Test
    public void GetUser(){
        String sql ="select Blog_Title,Blog_ContextStr from blog";
        List<Blog> blog = temp.query(sql,new BeanPropertyRowMapper<>(Blog.class));
        System.out.println(blog);
    }

    //排序查询
    @Test
    public void Demo01(){
        String sql = "select Blog_Title from blog ORDER BY Blog_Likes DESC";
        List<Blog> map = temp.query(sql, new BeanPropertyRowMapper<>(Blog.class));
        System.out.println(gson.toJson(map));
        String sql2 = "select User_Name from user order by  User_FansNumber desc";
        List<User> user = temp.query(sql2, new BeanPropertyRowMapper<>(User.class));
        System.out.println(user);
    }

    @Test
    public void Demo2(){
        String sql = "SELECT\n" +
                "\tt1.User_Name as UserName ,\n" +
                "\tt1.User_FansNumber as FansNumber ,\n" +
                "\tCOUNT(t1.Blog_Title) as BlogNumber,\n" +
                "\tCOUNT(t1.Launch_ID) as LaunchNumber,\n" +
                "\tSUM(t1.Blog_Likes) as LikesNumber\n" +
                "FROM\n" +
                "\t(select\n" +
                "\tDISTINCT\n" +
                "\tt1.User_Name,\n" +
                "\tt1.User_FansNumber,\n" +
                "\tt3.Launch_ID,\n" +
                "\tt2.*\n" +
                "FROM\n" +
                "\t`user` as t1 INNER JOIN blog as t2 INNER JOIN follow as t3\n" +
                "ON\n" +
                "\tt1.User_ID=t2.Blog_UserID=t3.Launch_ID\n" +
                "WHERE\n" +
                " t1.User_ID = ?) as t1";
        List<Personal> personal = temp.query(sql,new BeanPropertyRowMapper<>(Personal.class),"1");
        System.out.println(personal);
    }
}

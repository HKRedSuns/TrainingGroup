package Dao;

import Bean.Blog;
import Bean.Personal;
import Bean.User;
import Utils.ConnectionUtil;
import com.google.gson.Gson;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 个人中心页面逻辑类
 */
public class Personnal_Center {
    Gson gson = new Gson();
    private JdbcTemplate temp = new JdbcTemplate(ConnectionUtil.getDataSource());
    public String getBlog(String id){
        String sql ="select Blog_Title,Blog_ContextStr from blog where Blog_UserID=?";
        List<Blog> blog = temp.query(sql,new BeanPropertyRowMapper<>(Blog.class),id);
        return gson.toJson(blog);
    }
    public String getUser(String id){
        String sql = "SELECT\n" +
                "\tt1.User_Name as UserName ,\n" +
                "\tt1.User_FansNumber as FansNumber ,\n" +
                "\tCOUNT( DISTINCT t1.Blog_Title) as BlogNumber,\n" +
                "\tCOUNT( DISTINCT t1.Receive_ID) as LaunchNumber,\n" +
                "\tSUM(t1.Blog_Likes) as LikesNumber\n" +
                "FROM\n" +
                "\t(select\n" +
                "\tDISTINCT\n" +
                "\tt1.User_Name,\n" +
                "\tt1.User_FansNumber,\n" +
                "\tt3.Receive_ID,\n" +
                "\tt2.*\n" +
                "FROM\n" +
                "\t`user` as t1 INNER JOIN blog as t2 INNER JOIN follow as t3\n" +
                "ON\n" +
                "\tt1.User_ID=t2.Blog_UserID=t3.Launch_ID\n" +
                "WHERE\n" +
                " t1.User_ID = ?) as t1";
        List<Personal> personal = temp.query(sql,new BeanPropertyRowMapper<>(Personal.class),id);
        return gson.toJson(personal);
    }

    //修改用户信息
    public boolean setUser(String sex,String Birthday,String Str,String id){
        String sql = "update user set User_Sex=?,User_Birthday=?,User_Str=? where User_ID=?";
        int count = temp.update(sql,sex,Birthday,Str,id);
        return count==1;
    }
    //修改用户图片
    public boolean setUserImg(String path,String id){
        String sql = "UPDATE `user` SET User_HeadImg=(SELECT img_ID FROM headimg WHERE img_Percorso=?) WHERE User_ID=?";
        int count = temp.update(sql,path,id);
        return count==1;
    }
    public Object getUserImg(String id){
        String sql = "select img_Percorso as img from headimg,user where User_ID=? and img_ID = User_HeadImg";
        Map<String, Object> map = temp.queryForMap(sql,id);
        return map.get("img");
    }
    public String getUser1(String id){
        String sql = "select User_Name,User_Birthday,User_Str from user where User_ID=?";
        Map<String, Object> map = temp.queryForMap(sql, id);
        System.out.println(gson.toJson(map));
        return gson.toJson(map);
    }
}

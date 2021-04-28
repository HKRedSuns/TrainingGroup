package Dao;

import Bean.Blog;
import Utils.ConnectionUtil;
import Utils.JsonUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 主页面的逻辑类
 */
public class IndexDao {

    private JdbcTemplate temp = new JdbcTemplate(ConnectionUtil.getDataSource());
    //JSON格式文章表中内容
    //定义一个方法，以json格式返回所有的文章数据
    public String getBlog(){
        //String sql = "select * from blog";
        String sql = "select Blog_ID,Blog_Title,Blog_Content,Blog_UserID,Blog_Likes,Blog_ImgID,Blog_ReleaseDate,Blog_Comment,Blog_ContextStr from blog";
        List<Blog> list = temp.query(sql,new BeanPropertyRowMapper<>(Blog.class));
        return JsonUtils.JsonSerializeList(list);
    }

    //排序（用户，文章）

}

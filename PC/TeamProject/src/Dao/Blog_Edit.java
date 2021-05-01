package Dao;

import Bean.Blog;
import Utils.ConnectionUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 文章编辑逻辑类
 */
public class Blog_Edit {

    private JdbcTemplate temp = new JdbcTemplate(ConnectionUtil.getDataSource());

    public boolean add(Blog blog) {
//        String sql ="insert into "
        String sql = "insert into blog(Blog_Title,Blog_Content,Blog_UserID,Blog_ReleaseDate,Blog_ContextStr,Blog_ImgID) values(?,?,(select User_Name from `user` where User_ID=?),?,?,?)";
        int count = temp.update(sql,blog.getBlog_Title(),blog.getBlog_Content(),blog.getBlog_UserID(),blog.getBlog_ReleaseDate(),blog.getBlog_ContextStr(),blog.getBlog_ImgID());
        return count == 1;
    }

    //定义一个添加博客图片路径的方法
    public String getUserName(Blog blog){
        String sql = "select User_Name from user where User_ID=?";
        return temp.queryForObject(sql, String.class, blog.getBlog_UserID());
    }
}

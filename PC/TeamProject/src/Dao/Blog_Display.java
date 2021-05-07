package Dao;

import Utils.ConnectionUtil;
import com.google.gson.Gson;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 文章显示页面逻辑类
 */
public class Blog_Display {
    private static Gson gson = new Gson();
    private JdbcTemplate temp = new JdbcTemplate(ConnectionUtil.getDataSource());
    //获取文章的题目文章点赞量文章评论量，用户名用户头像
    public String getBlog(String blogID){
        String sql ="SELECT\n" +
                "\tblog.Blog_Title as Title,\n" +
                "\tblog.Blog_Likes as Likes,\n" +
                "\tblog.Blog_Comment as Comments,\n" +
                "\t(select User_Name from `user` where blog.Blog_UserID=User_ID) as UserName,\n" +
                "\t(select img_Percorso FROM headimg where img_ID=(select `user`.User_HeadImg FROM `user` where `user`.User_ID=blog.Blog_UserID)) as UserHeadImg\n" +
                "FROM\n" +
                "\tblog\n" +
                "WHERE\n" +
                "\tblog.Blog_ID = ?";
        List<Map<String, Object>> maps = temp.queryForList(sql,blogID);
        return gson.toJson(maps);
    }
    //获取文章的带标签对象的内容
    public String getBlogStr(String blogID){
        String sql="SELECT Blog_Content as BlogStr FROM blog WHERE Blog_ID=?";
        List<Map<String, Object>> maps = temp.queryForList(sql,blogID);
        Map<String, Object> map = maps.get(0);
        String blogStr = map.get("BlogStr").toString();
        return blogStr;
    }
}

package Dao;

import Bean.Blog;
import Utils.ConnectionUtil;
import com.google.gson.Gson;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

/**
 * 主页面的逻辑类
 */
public class IndexDao {
    private static Gson gson = new Gson();
    private JdbcTemplate temp = new JdbcTemplate(ConnectionUtil.getDataSource());
    //JSON格式文章表中内容
    //定义一个方法，以json格式返回所有的文章数据
    public String getBlog(){
        String sql = "select \n" +
                "\tBlog_ID,Blog_Title,Blog_Content,User_Name as Blog_UserID,Blog_Likes,Blog_ImgID,Blog_ReleaseDate,Blog_Comment,Blog_ContextStr \n" +
                "from \n" +
                "\tblog,\n" +
                "\t`user`\n" +
                "WHERE\n" +
                " Blog_UserID = User_ID";
        List<Blog> list = temp.query(sql,new BeanPropertyRowMapper<>(Blog.class));
        return gson.toJson(list);
    }
    //定义一个方法，以json格式返回排序后的文章
    public String getBolgSort(){
        String sql = "select Blog_Title from blog ORDER BY Blog_Likes DESC";
        Map<String, Object> map = temp.queryForMap(sql);
        return gson.toJson(map);
    }

    //排序（用户，文章）

}

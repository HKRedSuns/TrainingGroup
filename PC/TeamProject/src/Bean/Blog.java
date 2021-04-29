package Bean;

/**
 * 文章实体类
 */
public class Blog {
    //文章ID
    private int Blog_ID;
    //文章标题
    private String Blog_Title;
    //文章内容
    private String Blog_Content;
    //文章编写用户ID
    private String Blog_UserID;
    //文章点赞量
    private int Blog_Likes;
    //文章图片ID
    private String Blog_ImgID;
    //文章发布时间
    private String Blog_ReleaseDate;
    //文章评论量
    private int Blog_Comment;
    //文章显示
    private String Blog_ContextStr;

    //无参构造函数
    public Blog(){}

    public String getBlog_ContextStr() {
        return Blog_ContextStr;
    }

    public void setBlog_ContextStr(String blog_ContextStr) {
        Blog_ContextStr = blog_ContextStr;
    }

    public int getBlog_ID() {
        return Blog_ID;
    }

    public void setBlog_ID(int blog_ID) {
        Blog_ID = blog_ID;
    }

    public String getBlog_Title() {
        return Blog_Title;
    }

    public void setBlog_Title(String blog_Title) {
        Blog_Title = blog_Title;
    }

    public String getBlog_Content() {
        return Blog_Content;
    }

    public void setBlog_Content(String blog_Content) {
        Blog_Content = blog_Content;
    }

    public String getBlog_UserID() {
        return Blog_UserID;
    }

    public void setBlog_UserID(String blog_UserID) {
        Blog_UserID = blog_UserID;
    }

    public int getBlog_Likes() {
        return Blog_Likes;
    }

    public void setBlog_Likes(int blog_Likes) {
        Blog_Likes = blog_Likes;
    }

    public String getBlog_ImgID() {
        return Blog_ImgID;
    }

    public void setBlog_ImgID(String blog_ImgID) {
        Blog_ImgID = blog_ImgID;
    }

    public String getBlog_ReleaseDate() {
        return Blog_ReleaseDate;
    }

    public void setBlog_ReleaseDate(String blog_ReleaseDate) {
        Blog_ReleaseDate = blog_ReleaseDate;
    }

    public int getBlog_Comment() {
        return Blog_Comment;
    }

    public void setBlog_Comment(int blog_Comment) {
        Blog_Comment = blog_Comment;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "Blog_ID=" + Blog_ID +
                ", Blog_Title='" + Blog_Title + '\'' +
                ", Blog_Content='" + Blog_Content + '\'' +
                ", Blog_UserID='" + Blog_UserID + '\'' +
                ", Blog_Likes=" + Blog_Likes +
                ", Blog_ImgID='" + Blog_ImgID + '\'' +
                ", Blog_ReleaseDate='" + Blog_ReleaseDate + '\'' +
                ", Blog_Comment=" + Blog_Comment +
                ", Blog_ContextStr='" + Blog_ContextStr + '\'' +
                '}';
    }
}

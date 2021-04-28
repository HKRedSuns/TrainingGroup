package Bean;

/**
 * 评论实体类
 */
public class Comment {
    //评论ID
    private int Com_ID;
    //评论文章ID
    private int Com_BolgID;
    //当前评论的父级评论用户ID
    private int Com_ParentID;
    //评论获赞量
    private int Com_Likes;
    //发表评论用户ID
    private int Com_UserID;
    //评论的发表时间
    private String Com_Date;
    //评论的内容
    private String Com_Content;

    //无参构造函数
    public Comment(){}

    //有参构造函数
    public Comment(int com_ID, int com_BolgID, int com_ParentID, int com_Likes, int com_UserID, String com_Date, String com_Content) {
        Com_ID = com_ID;
        Com_BolgID = com_BolgID;
        Com_ParentID = com_ParentID;
        Com_Likes = com_Likes;
        Com_UserID = com_UserID;
        Com_Date = com_Date;
        Com_Content = com_Content;
    }

    //Get和Set方法
    public int getCom_ID() {
        return Com_ID;
    }

    public void setCom_ID(int com_ID) {
        Com_ID = com_ID;
    }

    public int getCom_BolgID() {
        return Com_BolgID;
    }

    public void setCom_BolgID(int com_BolgID) {
        Com_BolgID = com_BolgID;
    }

    public int getCom_ParentID() {
        return Com_ParentID;
    }

    public void setCom_ParentID(int com_ParentID) {
        Com_ParentID = com_ParentID;
    }

    public int getCom_Likes() {
        return Com_Likes;
    }

    public void setCom_Likes(int com_Likes) {
        Com_Likes = com_Likes;
    }

    public int getCom_UserID() {
        return Com_UserID;
    }

    public void setCom_UserID(int com_UserID) {
        Com_UserID = com_UserID;
    }

    public String getCom_Date() {
        return Com_Date;
    }

    public void setCom_Date(String com_Date) {
        Com_Date = com_Date;
    }

    public String getCom_Content() {
        return Com_Content;
    }

    public void setCom_Content(String com_Content) {
        Com_Content = com_Content;
    }

    //ToString方法
    @Override
    public String toString() {
        return "Comment{" +
                "Com_ID=" + Com_ID +
                ", Com_BolgID=" + Com_BolgID +
                ", Com_ParentID=" + Com_ParentID +
                ", Com_Likes=" + Com_Likes +
                ", Com_UserID=" + Com_UserID +
                ", Com_Date='" + Com_Date + '\'' +
                ", Com_Content='" + Com_Content + '\'' +
                '}';
    }

}

package Data;

/**
 * JavaBean对象
 * 用户封装数据库的用户表数据
 */
public class User {
    //用户ID
    private int UserID;
    //用户名
    private String UserName;
    //用户密码
    private String UserPassword;


    //Get方法
    public String getUserName() {
        return UserName;
    }
    public int getUserID() {
        return UserID;
    }
    public String getUserPassword() {
        return UserPassword;
    }
    //Set方法
    public void setUserName(String userName) {
        UserName = userName;
    }
    public void setUserID(int userID) {
        UserID = userID;
    }
    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

}

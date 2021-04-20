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
    //用户邮箱
    private String email;
    //用户注册时间
    private String regTime;
    //用户生日
    private String birthday;
    //用户年龄
    private int age;
    //用户头像
    private String headImg;


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
    public String getEmail() {
        return email;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getRegTime() {
        return regTime;
    }
    public int getAge() {
        return age;
    }
    public String getHeadImg() {
        return headImg;
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
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}

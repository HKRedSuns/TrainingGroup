package Bean;

import java.util.Date;

/**
 * 用户实体类
 */
public class User {
    //ID
    private int User_ID;
    //IP
    private String User_IP;
    //用户名
    private String User_Name;
    //用户密码
    private String User_Pass;
    //邮箱
    private String User_Email;
    //用户注册时间
    private Date User_RegTime;
    //用户生日
    private Date User_Birthday;
    //用户性别
    private int User_Sex;
    //用户头像
    private int User_HeadImg;
    //用户粉丝量
    private int User_FansNumber;
    //头像路径
    private String img;
    //用户简介
    private String User_Str;

    public User(){}

    public User(int user_ID, String user_IP, String user_Name, String user_Pass, String user_Email, Date user_RegTime, Date user_Birthday, int user_Sex, int user_HeadImg, int user_FansNumber, String img, String user_Str) {
        User_ID = user_ID;
        User_IP = user_IP;
        User_Name = user_Name;
        User_Pass = user_Pass;
        User_Email = user_Email;
        User_RegTime = user_RegTime;
        User_Birthday = user_Birthday;
        User_Sex = user_Sex;
        User_HeadImg = user_HeadImg;
        User_FansNumber = user_FansNumber;
        this.img = img;
        User_Str = user_Str;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUser_IP() {
        return User_IP;
    }

    public void setUser_IP(String user_IP) {
        User_IP = user_IP;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Pass() {
        return User_Pass;
    }

    public void setUser_Pass(String user_Pass) {
        User_Pass = user_Pass;
    }

    public String getUser_Email() {
        return User_Email;
    }

    public void setUser_Email(String user_Email) {
        User_Email = user_Email;
    }

    public Date getUser_RegTime() {
        return User_RegTime;
    }

    public void setUser_RegTime(Date user_RegTime) {
        User_RegTime = user_RegTime;
    }

    public Date getUser_Birthday() {
        return User_Birthday;
    }

    public void setUser_Birthday(Date user_Birthday) {
        User_Birthday = user_Birthday;
    }

    public int getUser_Sex() {
        return User_Sex;
    }

    public void setUser_Sex(int user_Sex) {
        User_Sex = user_Sex;
    }

    public int getUser_HeadImg() {
        return User_HeadImg;
    }

    public void setUser_HeadImg(int user_HeadImg) {
        User_HeadImg = user_HeadImg;
    }

    public int getUser_FansNumber() {
        return User_FansNumber;
    }

    public void setUser_FansNumber(int user_FansNumber) {
        User_FansNumber = user_FansNumber;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUser_Str() {
        return User_Str;
    }

    public void setUser_Str(String user_Str) {
        User_Str = user_Str;
    }

    @Override
    public String toString() {
        return "User{" +
                "User_ID=" + User_ID +
                ", User_IP='" + User_IP + '\'' +
                ", User_Name='" + User_Name + '\'' +
                ", User_Pass='" + User_Pass + '\'' +
                ", User_Email='" + User_Email + '\'' +
                ", User_RegTime=" + User_RegTime +
                ", User_Birthday=" + User_Birthday +
                ", User_Sex=" + User_Sex +
                ", User_HeadImg=" + User_HeadImg +
                ", User_FansNumber=" + User_FansNumber +
                ", img='" + img + '\'' +
                ", User_Str='" + User_Str + '\'' +
                '}';
    }
}


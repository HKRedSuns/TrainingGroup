package Bean;

public class Personal {
    private String UserName;
    private String FansNumber;
    private String BlogNumber;
    private String LaunchNumber;
    private String LikesNUmber;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFansNumber() {
        return FansNumber;
    }

    public void setFansNumber(String fansNumber) {
        FansNumber = fansNumber;
    }

    public String getBlogNumber() {
        return BlogNumber;
    }

    public void setBlogNumber(String blogNumber) {
        BlogNumber = blogNumber;
    }

    public String getLaunchNumber() {
        return LaunchNumber;
    }

    public void setLaunchNumber(String launchNumber) {
        LaunchNumber = launchNumber;
    }

    public String getLikesNUmber() {
        return LikesNUmber;
    }

    public void setLikesNUmber(String likesNUmber) {
        LikesNUmber = likesNUmber;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "UserName='" + UserName + '\'' +
                ", FansNumber='" + FansNumber + '\'' +
                ", BlogNumber='" + BlogNumber + '\'' +
                ", LaunchNumber='" + LaunchNumber + '\'' +
                ", LikesNUmber='" + LikesNUmber + '\'' +
                '}';
    }
}

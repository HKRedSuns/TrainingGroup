package Bean;

/**
 * 关注与取消关注状态实体类
 */
public class Follow {
    //发起方用户ID（也就是关注别人的用户ID)
    private int Launch_ID;
    //接收方用户ID（也就是被关注用户）
    private int Receive_ID;
    //行为(0代表取消关注；1代表关注)
    private int Follow_Type;

    //无参构造函数
    public Follow(){}

    //有参构造函数
    public Follow(int launch_ID, int receive_ID, int follow_Type) {
        Launch_ID = launch_ID;
        Receive_ID = receive_ID;
        Follow_Type = follow_Type;
    }

    //Get和Set方法
    public int getLaunch_ID() {
        return Launch_ID;
    }

    public void setLaunch_ID(int launch_ID) {
        Launch_ID = launch_ID;
    }

    public int getReceive_ID() {
        return Receive_ID;
    }

    public void setReceive_ID(int receive_ID) {
        Receive_ID = receive_ID;
    }

    public int getFollow_Type() {
        return Follow_Type;
    }

    public void setFollow_Type(int follow_Type) {
        Follow_Type = follow_Type;
    }

    //ToString方法
    @Override
    public String toString() {
        return "Follow{" +
                "Launch_ID=" + Launch_ID +
                ", Receive_ID=" + Receive_ID +
                ", Follow_Type=" + Follow_Type +
                '}';
    }

}

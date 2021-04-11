package Test;

import Controllter.UserControllter;

public class RetrieveDemoTest {
    public static void main(String[] args) {
        UserControllter user = new UserControllter();
        System.out.println(user.retrieveVerification("183578566@qq.com"));
    }
}

package Servlet;

import Controllter.UserControllter;
import Data.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录页面数据请求
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建用户逻辑处理对象
        UserControllter userDao = new UserControllter();
        //创建一个返回值
        //0:用户不存在;1:登录成功;-1:用户名或密码错误
        int result = 0;
        //定义输出前端页面的流对象
        PrintWriter pw = null;

        //设置字符集asss
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");

        //对流对象进行赋值
        pw = response.getWriter();

        //获取数据
        String userName = request.getParameter("user");
        String userPass = request.getParameter("pass");
        System.out.println(userName+"......"+userPass);     //测试成功

        //调用方法与数据库进行用户名密码验证
        User user = userDao.userLogin(userName,userPass);

        if(user==null){
            //返回数据
            pw.print("0");
        }else if(!user.getUserPassword().equals(userPass)){
            pw.print("-1");
        }else{
            //用户登录成功，将用户头像返回给前端
            String img = userDao.getHeadImg(user.getHeadImg());
            //设置Cookie
            Cookie cookie = new Cookie("headImg",img);
            //设置时长
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
            pw.print("1");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

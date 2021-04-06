package Servlet;

import Controllter.UserControllter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建用户逻辑处理对象
        UserControllter userDao = new UserControllter();
        //创建一个返回值
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
        result = userDao.userLogin(userName,userPass);
        if(result==0){
            //返回数据
            pw.print("用户不存在!");
        }else if(result == -1){
            pw.print("密码错误!");
        }else{
            pw.print("登录成功!");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

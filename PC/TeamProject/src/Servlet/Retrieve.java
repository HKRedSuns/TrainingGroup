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
 * 忘记密码页面
 */
@WebServlet("/retrieve")
public class Retrieve extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //创建流对象
        PrintWriter pw = response.getWriter();

        //获取新密码
        String newPassword = request.getParameter("newPassword");
        //获取邮箱
        String userEmail = request.getParameter("Email");
        //测试
        System.out.println(newPassword+"啊实打实的"+userEmail);

        UserControllter user = new UserControllter();
        //调用方法
        boolean isRetrieve = user.UpdatePassword(userEmail,newPassword);
        if(isRetrieve){
            //成功
            pw.print("修改密码成功!");
        }else{
            //失败
            pw.print("修改密码失败!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

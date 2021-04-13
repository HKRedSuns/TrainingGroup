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
 * 注册页面数据请求
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建用户逻辑处理对象
        UserControllter userDao = new UserControllter();
        //创建一个返回值
        //0:用户不存在;1:登录成功;-1:用户名或密码错误
        int result = 0;
        //定义输出前端页面的流对象
        PrintWriter pw = null;

        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //对流对象进行赋值
        pw = response.getWriter();

        //获取数据
        String userName = request.getParameter("userName");         //用户名
        String passWord = request.getParameter("passWord");         //密码
        String userEmil = request.getParameter("Email");            //邮箱
        //测试
        //System.out.println("用户名:"+userName+"密码:"+passWord+"邮箱:"+userEmil);      //成功

        //调用方法,将用户数据添加到数据库
        boolean isRegister = userDao.InsertUser(userName,passWord,userEmil);
        if(isRegister){
            //注册成功
            result = 1;
            //System.out.println("注册成功");
            //成功返回1
            pw.print(result);
        }else{
            //注册失败
            result = -1;
            //System.out.println("注册失败");
            //失败返回-1
            pw.print(result);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

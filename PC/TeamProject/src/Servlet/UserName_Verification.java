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
 * 注册页面用户名判断用户名是否存在请求
 */
@WebServlet("/UserName_Verification")
public class UserName_Verification extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建用户逻辑处理对象
        UserControllter userDao = new UserControllter();
        //设置返回数据(默认为-1表示用户名失败
        int temp = -1;
        //定义输出前端页面的流对象
        PrintWriter pw = null;

        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //对流对象进行赋值
        pw = response.getWriter();

        //获取用户名
        String userName = request.getParameter("userName");
        //测试
        System.out.println(userName);
        //判断和数据库中是否有重名
        temp = userDao.UserName_Verification(userName);
        if(temp==1){
            //用户名存在
            //System.out.println("用户名存在");
            //返回数据
            pw.print("1");
        }else if(temp == -1){
            //用户名不存在
            //System.out.println("用户名不存在");
            pw.print("-1");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

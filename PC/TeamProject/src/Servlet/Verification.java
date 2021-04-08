package Servlet;

import Utils.MailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 邮箱验证码请求
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //创建流对象
        PrintWriter pw = response.getWriter();

        //获取用户的邮箱号码
        String userEmail = request.getParameter("Email");
        //System.out.println(userEmail);

        //获取随机数
        String random = MailUtil.getRandom();
        //System.out.println(random);
        //发送邮件
        boolean isEmail = MailUtil.SendMail(userEmail,random);
        //System.out.println(isEmail);
        //返回验证码
        if(isEmail){
            pw.print(random);
        }else{
            pw.print(-1);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

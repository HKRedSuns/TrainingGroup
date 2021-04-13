package Servlet;

import Controllter.UserControllter;
import Utils.MailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 忘记密码邮箱验证
 */
@WebServlet("/retrieveVerification")
public class retrieveVerification extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //创建流对象
        PrintWriter pw = response.getWriter();

        //获取用户的邮箱号码
        String userEmail = request.getParameter("Email");

        UserControllter user = new UserControllter();
        //获取返回码(0为用户不存在;1为存在,-1为验证码发送失败)
        int result = user.retrieveVerification(userEmail);
        if (result==1){
            //用户存在
            //发送验证码
            //获取随机数
            String random = MailUtil.getRandom();
            //System.out.println(random);
            //发送邮件
            boolean isEmail = MailUtil.SendMail(userEmail,random);
            if(isEmail){
                pw.print(random);
            }else{
                pw.print(-1);
            }
        }else if(result == 0){
            //用户不存在
            pw.print(0);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

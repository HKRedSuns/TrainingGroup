package Servlet;

import Bean.User;
import Dao.User_LoginAndRegister;
import Utils.ConnectionUtil;
import Utils.MailUtil;
import Utils.UseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;

@WebServlet("/Login")
public class UserLogin extends HttpServlet {
    public User_LoginAndRegister UserCon = new User_LoginAndRegister();
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String action = request.getParameter("action");
        //System.out.println(action);
        if(action==null)
            Login(request,response);
        else
        {
            switch (action){
                case "login":                   //登录
                    //调用登录方法
                    Login(request,response);
                    break;
                case "userNameCheck":           //用户名验证
                    //调用用户名验证方法
                    userNameCheck(request,response);
                    break;
                case "emailCheck":              //邮箱验证
                    //调用用邮箱验证的方法
                    emailCheck(request,response);
                    break;
                case "emailSend":
                    emailSend(request,response);
                    break;
                case "register":                //注册
                    //调用注册方法
                    register(request,response);
                    break;
                case "retrieve":                //忘记密码
                    //调用忘记密码方法
                    retrieve(request,response);
                    break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        this.doPost(request, response);
    }

    //登录方法
    public void Login(HttpServletRequest request, HttpServletResponse response){
        //定义输出前端页面的流对象
        PrintWriter pw = null;
        //设置字符集
        try {
            request.setCharacterEncoding("utf-8");
            pw = response.getWriter();
        }catch (IOException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");
        //对流对象进行赋值

        //获取数据
        String userName = request.getParameter("user");
        String userPass = request.getParameter("pass");
        System.out.println(userName+"......"+userPass);     //测试成功
        User user = UserCon.UserLogin(userName,userPass);
        if(user==null) {
            pw.print("0");
        }else{
            //用户登录成功，将用户头像返回给前端
            Cookie cookie = new Cookie("headImg",user.getImg());
            Cookie cookie2 = new Cookie("id",user.getUser_ID()+"");
            //设置时长
            cookie.setMaxAge(60*60*24*7);
            cookie2.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
            response.addCookie(cookie2);
            pw.print("1");
        }
    }
    //用户名验证方法
    public void userNameCheck(HttpServletRequest request, HttpServletResponse response){
        //定义输出前端页面的流对象
        PrintWriter pw = null;
        //设置字符集
        try {
            request.setCharacterEncoding("utf-8");
            //对流对象进行赋值
            pw = response.getWriter();
        }catch (IOException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");

        //获取数据
        String name = request.getParameter("userName");
        //System.out.println(name);               //测试

        //System.out.println(UserCon.UserName_Check(name));
        pw.print(UserCon.UserName_Check(name));
    }
    //发送邮箱方法
    public void emailSend(HttpServletRequest request, HttpServletResponse response){
        //创建流对象
        PrintWriter pw = null;
        try {
            request.setCharacterEncoding("utf-8");
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //获取用户的邮箱号码
        String userEmail = request.getParameter("Email");


        //判断邮箱是否存在，不存在则发送邮件
        if(!UserCon.UserEmail_Check(userEmail)){
            //获取随机数
            String random = MailUtil.getRandom();
            //发送邮件
            boolean isEmail = MailUtil.SendMail(userEmail,random);
            //返回验证码
            if(isEmail){
                pw.print(random);

            }else{
                pw.print(-1);
            }
        }
    }
    //邮箱验证方法
    public void emailCheck(HttpServletRequest request, HttpServletResponse response){
        //创建流对象
        PrintWriter pw = null;
        try {
            request.setCharacterEncoding("utf-8");
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //获取用户的邮箱号码
        String userEmail = request.getParameter("Email");

        //判断邮箱是否存在，存在则发送邮件
        if(UserCon.UserEmail_Check(userEmail)){
            //获取随机数
            String random = MailUtil.getRandom();
            //发送邮件
            boolean isEmail = MailUtil.SendMail(userEmail,random);
            //返回验证码
            if(isEmail){
                pw.print(random);

            }else{
                pw.print(-1);
            }
        }
    }
    //注册方法
    public void register(HttpServletRequest request, HttpServletResponse response){
        //创建流对象
        PrintWriter pw = null;
        try {
            request.setCharacterEncoding("utf-8");
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //获取IP
        String IP = UseUtils.getAddr(request);
        //获取数据
        String userName = request.getParameter("userName");         //用户名
        String passWord = request.getParameter("passWord");         //密码
        String userEmil = request.getParameter("Email");            //邮箱
        if(UserCon.UserInsert(IP,userName,passWord,userEmil)){
            //注册成功
            pw.print(1);
        }else{
            //注册失败
            pw.print(-1);
        }

    }
    //忘记密码方法
    public void retrieve(HttpServletRequest request, HttpServletResponse response) {
        //创建流对象
        PrintWriter pw = null;
        try {
            request.setCharacterEncoding("utf-8");
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //获取新密码
        String newPassword = request.getParameter("newPassword");
        //获取邮箱
        String userEmail = request.getParameter("Email");

        if(UserCon.UserUpdatePass(newPassword,userEmail)){
            //成功
            pw.print("修改密码成功!");
        }else{
            //失败
            pw.print("修改密码失败!");
        }
    }

}

package Servlet;

import Dao.Blog_Display;
import Dao.Personnal_Center;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Browse_Blog")
public class Browse_Blog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");

        //定义输出流对象
        PrintWriter pw = response.getWriter();
        Blog_Display blog = new Blog_Display();
        String action = request.getParameter("action");
        String BlogID = request.getParameter("cont_ID");
        switch (action){
            case "user":
                pw.print(blog.getBlog(BlogID));
                break;
            case "BlogStr":
                pw.print(blog.getBlogStr(BlogID));
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package Servlet;

import Dao.IndexDao;

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

@WebServlet("/indexBlog")
public class Index_Blog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");
        //定义输出流对象
        PrintWriter pw = response.getWriter();
        //获取操作对象
        IndexDao index = new IndexDao();
        Cookie[] cookie = request.getCookies();
        Map<String,String > map = new HashMap<>();
        if(cookie!=null) {
            for (Cookie item : cookie) {
                map.put(item.getName(), item.getValue());
            }
        }
        String action = request.getParameter("action");
        switch (action){
            case "blog":
                pw.print(index.getBlog());
                break;
            case "blogSort":        //字符串
                pw.print(index.getBolgSort());
                break;
            case "userSort":        //头像，用户名，个人介绍
                pw.print(index.getUserSort());
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

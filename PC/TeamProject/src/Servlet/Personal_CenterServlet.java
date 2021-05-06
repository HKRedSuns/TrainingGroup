package Servlet;

import Dao.Personnal_Center;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieStore;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/personal_Center")
public class Personal_CenterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");

        //定义输出流对象
        PrintWriter pw = response.getWriter();
        Personnal_Center personnal_center = new Personnal_Center();
        Cookie[] cookie = request.getCookies();
        Map<String,String > map = new HashMap<>();
        for (Cookie item : cookie) {
            map.put(item.getName(),item.getValue());
        }
        String action = request.getParameter("action");

        switch (action){
            case "user":
                pw.print(personnal_center.getUser(map.get("id")));
                break;
            case "blog":
                pw.print(personnal_center.getBlog(map.get("id")));
                break;
            case "person":
                //获取提交的数据
                String sex = request.getParameter("sex");
                String birthday = request.getParameter("birthday");
                String UserStr = request.getParameter("person_data");
                //System.out.println(sex+"...."+birthday+"....."+UserStr);    //数据获取成功
                boolean temp = personnal_center.setUser(sex, birthday, UserStr, map.get("id"));
                if(temp){
                    pw.write("1");
                }else{
                    pw.write("-1");
                }
                break;
            case "img":

                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    //修改个人信息
    public void UpdatePerson(Personnal_Center dao,HttpServletRequest request, HttpServletResponse response){

    }
}

package Servlet;

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
        Map<String,Object > map = new HashMap<>();
        for (Cookie item : cookie) {
            map.put(item.getName(),item.getValue());
        }
        String action = request.getParameter("action");

        switch (action){
            case "user":
                pw.print(personnal_center.getUser(map.get("id").toString()));
                break;
            case "blog":
                pw.print(personnal_center.getBlog(map.get("id").toString()));
                break;
            case "person":
                //获取提交的数据
                String sex = request.getParameter("sex");
                String birthday = request.getParameter("birthday");
                String UserStr = request.getParameter("person_data");
                boolean temp = personnal_center.setUser(sex, birthday, UserStr, map.get("id").toString());
                if(temp){
                    pw.write("1");
                }else{
                    pw.write("-1");
                }
                break;
            case "img":
                String path = request.getParameter("path");
                path = path.substring(4,path.length());
                boolean isPaht = personnal_center.setUserImg(path, map.get("id").toString());
                if(isPaht){
                    //修改成功后重新设置Cookie的值
                    map.put("headImg",personnal_center.getUserImg(map.get("id").toString()));
                    for (Cookie item : cookie) {
                        if(item.getName().equals("headImg")){
                            item.setValue(map.get("headImg").toString());
                            response.addCookie(item);
                        }
                    }
                    pw.write("1");
                }else{
                    pw.write("-1");
                }
                break;

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

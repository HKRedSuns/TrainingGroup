package Servlet;

import Bean.Blog;
import Dao.Blog_Edit;
import Utils.UseUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/addBlog")
public class AddBlog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 针对post请求，设置允许接收中文
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        try {
            //创建Blog实体类
            Blog_Edit edit = new Blog_Edit();
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            List<FileItem> items = upload.parseRequest(request);
            Map<String,FileItem> map = new HashMap<>();
            for (FileItem item : items) {
                map.put(item.getFieldName(),item);
            }
            System.out.println(request.getContextPath());
            //将数据封装到Blog对象中
            Blog blog = new Blog();
            //添加文章的标题
            blog.setBlog_Title(map.get("title").getString("utf-8"));
            //添加文章的主页显示内容
            blog.setBlog_ContextStr(map.get("conStr").getString("utf-8"));
            //添加文章的正文内容
            blog.setBlog_Content(map.get("context").getString("utf-8"));
            //添加文章的用户ID
            blog.setBlog_UserID(map.get("userId").getString("utf-8"));
            //添加用户发布文章的时间
            blog.setBlog_ReleaseDate(UseUtils.getRunTiem());
            //获取用户名
            String name = edit.getUserName(blog);
            //将图片放入对应地址
            String Img_url = request.getServletContext().getRealPath("")+"/User/"+name+"/img";
            //获取input流
            if (!(map.get("file").getString("utf-8").equals("1"))) {
                InputStream in = map.get("file").getInputStream();
                //创建文件对象，并且判断文件是否存在，不存在就创建
                File file = new File(Img_url);
                if(!file.exists())file.mkdir();

                //重构图片路径
                String date = new Date().getTime()+"";
                Img_url = Img_url+"/"+name+"_"+date+".jpg";
                //创建输出流
                FileOutputStream fos = new FileOutputStream(Img_url);
                int len = 0;
                byte[] b = new byte[2048];
                while((len=in.read(b))!=-1){
                    fos.write(b,0,len);
                }

                String path = "/Project/User/"+name+"/img/"+name+"_"+date+".jpg";
                //将路径存储到对应的字段中
                blog.setBlog_ImgID(path);
                //关闭流对象
                fos.close();
                in.close();
                //调用添加数据方法
            }else{
                String path = map.get("file").getString("utf-8");
                //将路径存储到对应的字段中
                blog.setBlog_ImgID(path);
            }
            edit.add(blog);
            // 输出数据
            out.println("200");

        } catch (FileUploadException e1) {
            e1.printStackTrace();
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

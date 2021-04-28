package Utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

/**
 * 邮件工具类
 */
public class MailUtil {
    //定义发件人的邮箱账号
    public static final String emailAccount = "kz_game0524@163.com";
    //发件人邮箱密码(授权码)
    public static final String emailPassword = "FJORWWKWBQUMTZHP";
    //发件人邮箱服务器地址
    public static final String emailSMTPHost = "smtp.163.com";

    /**
     *定义一个发送邮件的工具方法
     * @param to    验证码接收邮件地址
     * @param text  随机数验证码
     * @return  返回true则发送邮件成功,返回false则发送邮件失败
     */
    public static boolean SendMail(String to,String text){
        //邮件内容HTML内容
        String content = "<h1><b>亲爱的用户</b></h1>"+
                "<p>您本次操作的验证码为<h2><u style='color:#ffa60f'>"+text+"</u></h2></p>"+
                "<p>为了您账号的安全,千万不要告诉别人哦!</p>";
        //配置参数对象
        Properties pro = new Properties();
        //配置发件人邮箱账号
        pro.put("username",emailAccount);
        //配置发件人密码
        pro.put("password",emailPassword);
        //使用的协议(必须写)
        pro.put("mail.transport.protocol","smtp");
        //指定服务器端口
        pro.put("mail.smtp.port","25");
        //指定SMTP服务器
        pro.put("mail.smtp.host",emailSMTPHost);
        //创建会话对象
        Session session = Session.getDefaultInstance(pro);

        //在控制台中显示Debug信息
        //session.setDebug(true);
        //创建一封邮件
        MimeMessage message = new MimeMessage(session);
        try{
            //邮件的发送者
            message.setFrom(new InternetAddress(emailAccount));
            //抄送一份邮件
            message.addRecipients(Message.RecipientType.CC,InternetAddress.parse(pro.getProperty("username")));
            //创建邮件接收者的地址,并设置到邮件消息中
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            //邮件发送时间
            message.setSentDate(new Date());
            //设置邮件的主题
            message.setSubject("KZ美食博客_新用户注册邮件");
            Multipart mu = new MimeMultipart();
            BodyPart bd = new MimeBodyPart();
            bd.setContent(content,"text/html;charset=utf-8");
            mu.addBodyPart(bd);
            //邮件正文
            message.setContent(mu);
            //保存设置
            message.saveChanges();
            //获取邮件传输对象
            Transport trans = session.getTransport("smtp");
            //确定服务器地址和发件人邮箱账号和密码连接邮件服务器
            trans.connect(pro.getProperty("mail.smtp.host"), pro.getProperty("username"), pro.getProperty("password"));
            //发送邮件
            trans.sendMessage(message,message.getAllRecipients());
            //关闭连接
            trans.close();
        }catch(MessagingException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *定义一个获取邮件验证的随机数工具类
     * @return 返回一个六位的随机验证码
     */
    public static String getRandom(){
        String[] letters = new String[]{
                "A","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M",
                "0","1","2","3","4","5","6","7","8","9"
        };
        String code = "";
        for(int i = 0;i<6;i++){
            code = code+letters[(int)Math.floor(Math.random()*letters.length)];
        }
        return code;
    }

}

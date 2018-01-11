package util;

import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.UUID;

public class Email {
    private String sendAddress = "191506389@qq.com";
//    private String receiveAddress = "2716939658@qq.com";
    private String pass = "bgbejrmmwoosbihj";
    @Test
    public void sendMail(String receiveAddress) throws MessagingException {
        String s = UUID.randomUUID().toString();
//        System.out.println(s);
        Properties prop = new Properties();
        prop.setProperty("mail.host","smtp.qq.com");
        prop.setProperty("mail.smtp.auth","true");
        prop.setProperty("mail.smtp.port","587");
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendAddress,pass);
            }
        };
        Session session = Session.getInstance(prop, auth);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(sendAddress));
        msg.setRecipients(Message.RecipientType.TO,receiveAddress);
        msg.setSubject("测试");
        msg.setContent("<a href="+"http://localhost:8080/?method=register>点击验证</a>","text/html;charset=utf-8");
        Transport.send(msg);
    }
}

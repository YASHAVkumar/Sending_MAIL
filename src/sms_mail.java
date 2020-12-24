import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import  javax.mail.*;
import  javax.activation.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.crypto.Data;

public class sms_mail {
    public  static void main(String args[]) throws MessagingException {
        //put Properties for a session
        System.out.println("Preparing to send a msg to you respective mail");
        Properties properties =new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");  
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        String user="your mail";
        String pass="your password";
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,pass);
            }
        });
        Date date=new Date();
        SimpleDateFormat simple=new SimpleDateFormat("dd/yyyy/mm");
        System.out.println(simple.format(date));
        String client="receiver mail";

        //otp Generation are of two mentioned below

        String str="0123456789";
        int otp=0;
        String otp2="";
        String str1="0123456789abcefghijklmnopqurstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r=new Random();
        int j;
        for(int i=0;i<4;i++)
        {   j=r.nextInt(str1.length());
            otp=otp*10+(r.nextInt(str.length()));
            otp2=otp2+str1.charAt(j);
        }
        System.out.println(otp+" otp two is "+otp2);

        try {
            MimeMessage msg=new MimeMessage(session);
            msg.setFrom(new InternetAddress(user));
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(client));
        msg.setSubject("<h1>Hi user It's just a demo to show this things works");
        msg.setSentDate(date);
        String html="<div bgcolor='black'>" +
                "<div class='container'>" +
                "<h1 style=\"color:yellow;font-size:60px;\">Welcome's u to Learning world</h1>\n This is otp one for Traders :-" +
                otp +
                "\nThis is otp two  for Traders :- " +otp2+
                "</div>" +
                "<div style='color:white':font-size:30px;><h2>This is our owner of Traders </h2>" +
                "<img src=\"C:\\Users\\DELL\\IdeaProjects\\waitdata\\src\\a.jpeg\" width='240px' height='300px'>" +
                "<h5>Good bye sir</h5></div>" +
                "</div>";
      msg.setContent(html,"text/html");

            Transport.send(msg);
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("Msg send successfully");

    }
}

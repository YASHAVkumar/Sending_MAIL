
import java.util.*;
        import javax.mail.*;
        import javax.mail.internet.*;
        import javax.activation.*;

public class sending_mail {

    public static void main(String [] args) {

      /*
        // Recipient's email ID needs to be mentioned.
        String to = "yashavkumar91@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "kumaryashav@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();
 */
        System.out.println("Sending mail");
      Properties prop=new Properties();
       prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.port","587");
        String from = "kumaryashav@gmail.com";
        String pass="yashpal2711";
        String to = "yashavkumar91@gmail.com";

        Session session=Session.getInstance(prop, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from,pass);
        }
    });

       // Setup mail server
     //   properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
       // Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line! I done it dkjl ");

            // Now set the actual message
            message.setText("Tune kya hi padna tuje kya jarut ha bachee ?tu kya hi kr lega bachee laokdls");
            String  html="<div class='container' style='color:purple'>" +
                    "<h1>Your Maximum Length is over now</h1>" +
                    "<h3>Length is  now getting over now </h3>" +
                    "<h6>now this is wrong </h6>" +
                    "</div>";
            // Send message
            message.setContent(html,"text/html");
           // message.addHeader("kllol","990");




            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
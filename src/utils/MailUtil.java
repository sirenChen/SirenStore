package utils;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Siren Chen.
 * Send email
 */
public class MailUtil {

    public static boolean sendMail(String email, String emailMsg) {

//        String from = “xxx”;
//        String to = email;
//
//        final String username = “xxx”;
//        final String password = “xxx”;
//
//        // set the mail properties
//        Properties props = new Properties();
//
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class",
//                "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
//
//        Session session = Session.getInstance(props);
//
//
//        try {
//            // the email
//            MimeMessage message = new MimeMessage(session);
//            // sender add
//            message.setFrom(new InternetAddress(from));
//            // subject
//            message.setSubject("user active");
//            //
//            message.setContent(emailMsg, "text/html;charset=utf-8");
//            //
//            Transport transport = session.getTransport();
//            transport.connect("smtp.gmail.com", 465, username, password);
//            transport.sendMessage(message, new Address[]{new InternetAddress(to)});
//            transport.close();
//
//            return true;
//        } catch (MessagingException e) {
//            e.printStackTrace();
//
//            return false;
//        }
        return true;
    }
}

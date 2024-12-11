package com.example.springdemo2.Service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void ssendMail(String to,String subject, String body){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(body);
        javaMailSender.send(mail);
    }

    public String createMsg(String name, String passcode){
        return "Hey,Thank you for creating account in our website. We are really happy to have you here and looking" +
                " forward for a beautiful journey with us." +
                " \n" +
                "Your credentials are : \n" +
                "Username: " + name +"\n"+
                "Password: "+passcode+ "\n"+
                " Feel free to reach out to us in case of any queries.\n" +
                "Thank you, again.\n"+
                "Team - Nirvana...\n" +
                "Contact Us - help@nirvana.com | instagram.com/saivardhan96";
    }

}

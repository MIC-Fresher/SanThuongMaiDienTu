package model;

import entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.Mail.MailUtilGmail;
@Service
public class Mail {

    private String to;
    private String from;
    private String subject;
    private String body;
    private boolean bodyIsHTML;

    @Autowired
    MailUtilGmail mailUtilGmail;

    public boolean sendEmailToShop(Shop shop) {
        try {
            String to = shop.getUserId().getEmail();
            String from = "lisatthu35@gmail.com";
            String subject = "Gui ma kich hoat";
            String body = "mật khẩu để kích hoạt :" + shop.getUserId().getPassWord();
            // active?code=123
            boolean bodyIsHTML = true;
            mailUtilGmail.sendMail(to, from, subject, body, bodyIsHTML);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isBodyIsHTML() {
        return bodyIsHTML;
    }

    public void setBodyIsHTML(boolean bodyIsHTML) {
        this.bodyIsHTML = bodyIsHTML;
    }

}

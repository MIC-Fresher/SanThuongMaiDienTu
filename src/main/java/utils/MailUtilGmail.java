/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.Mail;

import javax.mail.MessagingException;

/**
 *
 * @author Admin
 */
public interface MailUtilGmail {

    public void sendMail(String to, String from, String subject, String body, boolean bodyIsHTML)
            throws MessagingException;
}

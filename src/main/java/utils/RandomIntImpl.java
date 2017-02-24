/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.Number;

import java.util.Random;
import org.springframework.stereotype.Service;
import utils.Mail.MailUtilGmail;
@Service
public class RandomIntImpl implements RandomInt {

    public Integer rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

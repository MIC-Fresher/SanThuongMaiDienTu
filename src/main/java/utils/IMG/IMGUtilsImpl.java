/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.IMG;

import utils.IMG.IMGUtils;
import entity.Producimage;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class IMGUtilsImpl implements IMGUtils {

    @Autowired(required = false)
    ServletContext servletContext;

    public String uploadImg(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            //File destination = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\BanThuoc\\web\\images\\shop\\" + file.getOriginalFilename()); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png

            String realpath = servletContext.getRealPath("");
            String[] temp = realpath.split("target", 2);
            File destination = new File(temp[0] + "src\\main\\webapp\\resources\\images\\product-details\\" + file.getOriginalFilename()); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
            System.out.println(temp[0] + "src\\main\\webapp\\resources\\images\\product-details\\");

            ImageIO.write(src, "jpg", destination);

           
            return file.getOriginalFilename();
        }
        return null;

    }
}

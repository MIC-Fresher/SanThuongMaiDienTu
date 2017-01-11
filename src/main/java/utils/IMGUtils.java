/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Producimage;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
public interface IMGUtils {

    public String uploadImg(MultipartFile file) throws IOException;
}

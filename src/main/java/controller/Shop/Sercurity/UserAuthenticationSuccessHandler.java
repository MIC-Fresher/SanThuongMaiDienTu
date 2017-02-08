package controller.Shop.Sercurity;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import services.*;
import config.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserAuthenticationSuccessHandler extends
        SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthenticationSuccessHandler.class);

    @Autowired
    UserService userService;
    
    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // last access timestamp
        User userSpringAuthencation = (User) authentication.getPrincipal();
        HttpSession session = request.getSession();
        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

            UserService userService = context.getBean("userService", UserService.class);
            entity.User user = userService.getUser(userSpringAuthencation.getUsername(), "").get(0);

            session.setAttribute("shop", user.getShop());

            response.sendRedirect(request.getContextPath() + "/Shop/ShopIndex");
        } catch (Exception e) {
            e.getMessage();
            LOGGER.error("User authenticationSuccess", e);
        }
    }

}

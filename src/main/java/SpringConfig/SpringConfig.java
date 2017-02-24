/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringConfig;

import java.util.Properties;
import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import services.*;

/**
 *
 * @author Asus
 */
@Configuration
//@ComponentScan("services")
//@ComponentScan("utils")
//@ComponentScan("model")
//@ComponentScan("controller")
//@ComponentScan("entity")
//@ComponentScan("config")
//@ComponentScan("repository")
@EnableJpaRepositories(basePackages = "repository")
@EnableTransactionManagement
public class SpringConfig {

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://mysql52650-micfresher.jelastic.tsukaeru.net/bbshop");
      
        dataSource.setUrl("jdbc:mysql://localhost:3306/bbshop");
//        dataSource.setUsername("bbshop");
        dataSource.setUsername("root");
        dataSource.setPassword("sa");
        return (DataSource) dataSource;
    }
    
    @Bean
    Properties properties() {
       
        return new Properties();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entitymanager = new LocalContainerEntityManagerFactoryBean();
        entitymanager.setDataSource((javax.sql.DataSource) dataSource);
        entitymanager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entitymanager.setPackagesToScan("entity");
        Properties p = new Properties();
        p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        p.setProperty("hibernate.hbm2ddl.auto", "update");
        p.setProperty("hibernate.id.new_generator_mappings", "false");
        entitymanager.setJpaProperties(p);
        return entitymanager;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpatran = new JpaTransactionManager();
        jpatran.setEntityManagerFactory(entityManagerFactory);
        return jpatran;
    }

//    @Bean
//    public UserService userService() {
//        UserServiceImpl bean = new UserServiceImpl();
//
//        return bean;
//
//    }
}

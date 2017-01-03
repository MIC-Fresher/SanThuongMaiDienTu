 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.Properties;
import javax.sql.DataSource;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Asus
 */
@Configuration
@EnableJpaRepositories(basePackages = "repository")
@EnableTransactionManagement
public class SpringConfig {
    
    @Bean 
    DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bbshop");
        dataSource.setUsername("root");
        dataSource.setPassword("sa");
        return (DataSource) dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource ) {
        LocalContainerEntityManagerFactoryBean entitymanager = new LocalContainerEntityManagerFactoryBean();
        entitymanager.setDataSource((javax.sql.DataSource) dataSource);
        entitymanager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entitymanager.setPackagesToScan("entity");
        
        //pja
        Properties p = new Properties();
        p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        p.setProperty("hibernate.hbm2ddl.auto", "update");
        p.setProperty("hibernate.id.new_generator_mappings", "false");
        entitymanager.setJpaProperties(p);
        return entitymanager;
    }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpatran = new JpaTransactionManager();
        jpatran.setEntityManagerFactory(entityManagerFactory);
        return jpatran;
    }
}

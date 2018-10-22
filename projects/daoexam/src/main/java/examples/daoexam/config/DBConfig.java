package examples.daoexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.sql.Connection;

@Configuration
@EnableTransactionManagement
public class DBConfig {
    private String driverClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/fcdb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private String username = "fcuser";
    private String password = "fc123";

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        System.out.println("[BasicDataSource InitialSize] " + dataSource.getInitialSize());
        System.out.println("[BasicDataSource getMaxIdle] " + dataSource.getMaxIdle());
        System.out.println("[BasicDataSource getMinIdle] " + dataSource.getMinIdle());
        System.out.println("[BasicDataSource getNumActive] " + dataSource.getNumActive());
        return dataSource;
    }
    
    @Bean
    public PlatformTransactionManager transactionManger(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
}
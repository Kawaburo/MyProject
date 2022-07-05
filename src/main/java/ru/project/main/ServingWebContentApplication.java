package ru.project.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.project.main.utils.db.SettingsConnectDatabase;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;

@SpringBootApplication
public class ServingWebContentApplication {

    public ServingWebContentApplication() throws IOException {
    }

    private HashMap<String,String>
            HashMapSettingConnectDataBase = SettingsConnectDatabase.getSetConnectDB();

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(HashMapSettingConnectDataBase.get("url"));
        dataSource.setUsername(HashMapSettingConnectDataBase.get("username"));
        dataSource.setPassword(HashMapSettingConnectDataBase.get("password"));
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

}

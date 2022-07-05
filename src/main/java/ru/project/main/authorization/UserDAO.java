package ru.project.main.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class UserDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public UserDAO(){

    }

    //новый пользователь
    public void newUser(UserModel userModel){
        jdbcTemplate.update("INSERT INTO users (name, email, password) VALUES(?, ?, ?);",
                userModel.getName(),userModel.getEmail(),userModel.getPassword());
    }
    //авторизация пользователя
    public boolean tryAuthentication(String name,String password) {
        boolean tryGetAuthentication = false;
        String requestSql = "SELECT * FROM users WHERE name = '" + name + "';";
        Map<String, Object> getTableRow = jdbcTemplate.queryForMap(requestSql);
        if (password.equals(getTableRow.get("password")))
            tryGetAuthentication = true;

        return tryGetAuthentication;
    }
}























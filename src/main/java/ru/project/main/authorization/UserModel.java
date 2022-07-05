package ru.project.main.authorization;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserModel {

    //Валидация
    //id валидируется таблицей
    private Integer id;

    @NotEmpty(message = "Name not empty")
    @Size(min = 2,max = 50, message = "Name size 2-50 ")
    private String name;

    @Email(message = "Email not valid")
    @NotEmpty(message = "Email not empty")
    private String email;

    @NotEmpty(message = "Password not empty")
    @Size(min = 5,max = 50, message = "Password size 5-50 ")
    private String password;
    //

    public UserModel(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserModel(){

    }

    //
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

package ru.project.main.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

/*
    Контроллер для авторизации.Используется паттерн REST(ну или почти)
 */
@Controller
@RequestMapping("/authorization")
public class AuthorizationController {

    //Внедрение конструктора DAO
    private UserDAO userDAO;
    @Autowired
    public AuthorizationController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //Гет запрос для формы авторизации
    @GetMapping
    public String getAuthorization(@ModelAttribute("userModel")UserModel userModel){
        return "viewAuthorization/authorization";
    }

    //Гет запрос на форму регистрации
    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("userModel")UserModel userModel){
        return "viewAuthorization/registration";
    }

    //Пост запрос для регистрации с валидацией
    //BindingResult должен быть сразу после модели валидации
    @PostMapping()
    public String newUser(@ModelAttribute("userModel")
                          @Valid UserModel userModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "viewAuthorization/registration";
        }
        userDAO.newUser(userModel);
        return "redirect:/authorization";
    }

    //Гет запрос на сброс пароля
    @GetMapping("/resetPassword")
    public String getResetPassword(){
        return "viewAuthorization/resetPassword";
    }

    //Пост запрос для аутентификации
    @PostMapping("/authentication")
    public String authentication(@ModelAttribute("userModel") UserModel userModel){
        boolean tryAuthentication = userDAO.tryAuthentication(userModel.getName(),userModel.getPassword());
        if (tryAuthentication)
            return "viewDesk/mainDesk";
        return "redirect:/authorization";
    }


}

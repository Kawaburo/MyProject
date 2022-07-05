package ru.project.main.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.project.main.authorization.UserDAO;
import ru.project.main.authorization.UserModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {

    private UserDAO userDAO;
    @Autowired
    public AuthorizationController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String getAuthorization(@ModelAttribute("userModel")UserModel userModel){
        return "authorization/authorization";
    }
    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("userModel")UserModel userModel){
        return "authorization/registration";
    }

    @PostMapping()
    public String newUser(@ModelAttribute("userModel")
                          @Valid UserModel userModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "authorization/registration";
        }
        userDAO.newUser(userModel);
        return "redirect:/authorization";
    }

    @GetMapping("/resetPassword")
    public String getResetPassword(){
        return "authorization/resetPassword";
    }

    @PostMapping("/authentication")
    public String authentication(@ModelAttribute("userModel") UserModel userModel){
        boolean tryAuthentication = userDAO.tryAuthentication(userModel.getName(),userModel.getPassword());
        if (tryAuthentication)
            System.out.println("ok");
        return "redirect:/authorization";
    }
}

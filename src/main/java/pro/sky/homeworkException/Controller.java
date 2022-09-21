package pro.sky.homeworkException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    private LoginService loginService;
    public Controller(LoginService loginService) {
        this.loginService = loginService;}

    @GetMapping (path = "/enter")
    public String registration (@RequestParam String login,
                                @RequestParam String userPassword,
                                @RequestParam String confirmPassword) {
        try {loginService.isLoginTrue(login);
            loginService.isPasswordTrue(userPassword);
            loginService.isConfirmPasswordTrue(userPassword, confirmPassword);
        }catch (WrongLoginException e) {
            return "Логин может содержать только латинские буквы, цифры и нижнее подчеркивание. " +
                    "Допускается до 20 символов включительно.";
        } catch (WrongPasswordException e) {
            return "Пароль может содержать только латинские буквы, цифры и нижнее подчеркивание. " +
                    "Допускается до 20 символов включительно. " +
                    "Подтверждение пароля должно совпадать с паролем";
        }

        return "Регистрация прошла успешно.";
    }
}

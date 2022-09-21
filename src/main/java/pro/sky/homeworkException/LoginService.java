package pro.sky.homeworkException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    public boolean isLoginTrue (String string) {
        if (isValidChar(string) && string.length() <= 20 &&
                !string.startsWith(String.valueOf(0-9))) {
            return true;
        } else {throw new WrongLoginException();}
    }
    public boolean isPasswordTrue (String string) {
        if (isValidChar(string) && string.length() <= 20 &&
                !string.startsWith(String.valueOf(0-9))) {
            return true;
        } else {throw new WrongPasswordException();}
    }

    public boolean isConfirmPasswordTrue (String userPassword, String confirmPassword) {
        if (confirmPassword.equals(userPassword)) {
            return true;
        } else {
            throw new WrongPasswordException();
        }
    }

    public boolean isValidChar(String abc) {
        int length = abc.length();
        for (int i = 0; i < length; i++) {
            char c = abc.charAt(i);
            if ('0' <= c && c <= '9') continue;
            if ('a' <= c && c <= 'z') continue;
            if ('A' <= c && c <= 'Z') continue;
            if (c == '_') continue;
            return false;
        }
        return true;
    }

}

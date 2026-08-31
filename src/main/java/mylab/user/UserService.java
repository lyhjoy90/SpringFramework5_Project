package mylab.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }

    public boolean registerUser(String username, String password) {
        if (securityService.authenticate(password)) {
            // 사용자 등록 로직 수행
            return true;
        }
        return false;
    }
}
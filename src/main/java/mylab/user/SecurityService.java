package mylab.user;

import org.springframework.stereotype.Component;

@Component("securityService")
public class SecurityService {

    public boolean authenticate(String password) {
        // 비밀번호가 존재(null이 아니고 빈 문자열이 아님)하면 인증 성공
        return password != null && !password.trim().isEmpty();
    }
}
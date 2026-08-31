package mylab.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("userRepository")
public class UserRepository {

    @Value("MySQL")
    private String dbType;

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }
}
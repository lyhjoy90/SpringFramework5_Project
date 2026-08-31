package mylab.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserServiceDI() {
        // 1. UserService 주입 및 Not Null 검증
        assertNotNull(userService);

        // 2. UserRepository Not Null 및 @Value("MySQL") 주입 값 검증
        assertNotNull(userService.getUserRepository());
        assertEquals("MySQL", userService.getUserRepository().getDbType());

        // 3. SecurityService Not Null 검증
        assertNotNull(userService.getSecurityService());

        // 4. registerUser() 검증: 비밀번호가 전달되면 True, 없으면 False
        assertTrue(userService.registerUser("hong", "1234"));
        assertFalse(userService.registerUser("hong", null));
    }
}
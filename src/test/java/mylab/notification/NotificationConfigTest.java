package mylab.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    public void testNotificationManager() {
        // 1. NotificationManager 주입 및 Not Null 검증
        assertNotNull(notificationManager);

        // 2. 이메일 서비스 검증 (smtpServer: "smtp.gmail.com", port: 587)
        assertNotNull(notificationManager.getEmailService());
        EmailNotificationService emailService = (EmailNotificationService) notificationManager.getEmailService();
        assertEquals("smtp.gmail.com", emailService.getSmtpServer());
        assertEquals(587, emailService.getPort());

        // 3. SMS 서비스 검증 (provider: "SKT")
        assertNotNull(notificationManager.getSmsService());
        SmsNotificationService smsService = (SmsNotificationService) notificationManager.getSmsService();
        assertEquals("SKT", smsService.getProvider());

        // 4. NotificationManager 알림 전송 메서드 실행
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
    }
}
package com.hit.hitproduct.applications.schedules;

import com.hit.hitproduct.applications.services.PasswordResetTokenService;
import com.hit.hitproduct.applications.services.VerificationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledTasks {

    @Autowired
    VerificationTokenService verificationTokenService;

    @Autowired
    PasswordResetTokenService passwordResetTokenService;

    // Delete User undetermined when verification token expired repeat 3h
    @Scheduled(fixedRate = 10800)
    public void scheduleTaskWithFixedRate() {
        verificationTokenService.backUpDBUser();
        verificationTokenService.backUpDBEmailNotification();
    }

    @Scheduled(fixedRate = 600)
    public void backupPasswordToken() {
        passwordResetTokenService.backUpDBPasswordResetToken();
    }

    public void scheduleTaskWithFixedDelay() {

    }

    public void scheduleTaskWithInitialDelay() {

    }

    @Scheduled(cron = "59 59 23 ? * *")
    public void scheduleTaskWithCronExpression() {
        verificationTokenService.backUpDBUser();
    }
}

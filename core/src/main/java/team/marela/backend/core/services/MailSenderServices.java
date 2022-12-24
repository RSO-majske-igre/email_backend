package team.marela.backend.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import team.marela.backend.core.exceptions.DataNotFoundException;
import team.marela.backend.database.entities.MailLogEntity;
import team.marela.backend.database.repositories.MailLogRepository;
import team.marela.backend.database.repositories.MailTemplateRepository;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MailSenderServices {

    private final JavaMailSender mailSender;

    private final MailTemplateRepository mailTemplateRepository;
    private final MailLogRepository mailLogRepository;

    @Value("${spring.mail.username}")
    private String emailSender;

    public MailLogEntity sendTemplate(String templateName, String to, HashMap<String, String> variables) {
        var template = mailTemplateRepository.findByTemplateName(templateName).orElseThrow(DataNotFoundException::new);
        var message = template.getMessage();
        for (var variable : variables.keySet()) {
            message = message.replaceAll(variable, variables.get(variable));
        }

        var log = MailLogEntity.builder()
                .mailTemplate(template)
                .email(to)
                .build();

        try {
//            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//            simpleMailMessage.setFrom(emailSender);
//            simpleMailMessage.setSubject("Hello from Spring Boot");
//            simpleMailMessage.setTo(to);
//            simpleMailMessage.setText("This is a test email from Spring Boot.");
//            mailSender.send(simpleMailMessage);
            log.setSuccess(true);
        } catch (Exception e) {
            log.setSuccess(false);
        }
        return mailLogRepository.save(log);
    }

}

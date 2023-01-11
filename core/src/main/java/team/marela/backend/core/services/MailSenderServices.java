package team.marela.backend.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
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
                .message(message)
                .build();

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(emailSender);
            simpleMailMessage.setSubject(template.getSubject());
            simpleMailMessage.setTo(to);
            simpleMailMessage.setText(message);
            mailSender.send(simpleMailMessage);
            log.setSuccess(true);
        } catch (Exception e) {
            log.setSuccess(false);
        }
        return mailLogRepository.save(log);
    }

}

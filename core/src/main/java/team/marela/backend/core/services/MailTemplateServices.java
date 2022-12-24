package team.marela.backend.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.marela.backend.database.entities.MailTemplateEntity;
import team.marela.backend.database.repositories.MailTemplateRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MailTemplateServices {
    private final MailTemplateRepository mailTemplateRepository;

    public MailTemplateEntity saveTemplate(MailTemplateEntity template) {
        return mailTemplateRepository.save(template);
    }

    public List<MailTemplateEntity> getTemplates() {
        return mailTemplateRepository.findAll();
    }
}

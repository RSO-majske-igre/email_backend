package team.marela.backend.database.repositories;

import team.marela.backend.database.BaseRepository;
import team.marela.backend.database.entities.MailTemplateEntity;

import java.util.Optional;

public interface MailTemplateRepository extends BaseRepository<MailTemplateEntity> {
    Optional<MailTemplateEntity> findByTemplateName(String templateName);
}

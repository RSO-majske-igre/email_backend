package team.marela.backend.database.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import team.marela.backend.database.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "mail_template")
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MailTemplateEntity extends BaseEntity {

    @Column(nullable = false, updatable = false, unique = true)
    private String templateName;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false, length = 4096)
    private String message;

    @OneToMany(mappedBy = "mailTemplate")
    private Set<MailLogEntity> logs;
}

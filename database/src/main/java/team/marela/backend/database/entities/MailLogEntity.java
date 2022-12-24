package team.marela.backend.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import team.marela.backend.database.BaseEntity;

@Entity(name = "mail_log")
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MailLogEntity extends BaseEntity {

    @Column(nullable = false, updatable = false)
    private String email;

    @Column(nullable = false, updatable = false)
    private Boolean success;

    @ManyToOne
    @JoinColumn(name = "mail_template")
    private MailTemplateEntity mailTemplate;
}

package team.marela.backend.database.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import team.marela.backend.database.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

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
    private String templateName;

    @Column(nullable = false, updatable = false)
    private Boolean success;
}

package team.marela.backend.api.graphql;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import team.marela.backend.api.input.MailTemplateInput;
import team.marela.backend.core.services.MailTemplateServices;
import team.marela.backend.database.entities.MailTemplateEntity;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MailTemplateGraphQl {

    private final MailTemplateServices mailTemplateServices;

    @QueryMapping
    List<MailTemplateEntity> getAllTemplates() {
        return mailTemplateServices.getTemplates();
    }

    @MutationMapping
    MailTemplateEntity addTemplate(@Argument(name = "template") MailTemplateInput input) {
        return mailTemplateServices.saveTemplate(
                MailTemplateEntity.builder()
                        .templateName(input.templateName())
                        .subject(input.subject())
                        .message(input.message())
                        .build()
        );
    }
}

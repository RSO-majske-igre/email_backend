package team.marela.backend.api.graphql;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import team.marela.backend.api.input.MailInput;
import team.marela.backend.core.services.MailSenderServices;
import team.marela.backend.database.entities.MailLogEntity;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class MailSenderGraphQl {

    private final MailSenderServices mailSenderServices;

    @MutationMapping
    public MailLogEntity sendEmail(@Argument(name = "email") MailInput mailInput) {
        var parameters = new HashMap<String, String>();
        if (mailInput.parameters() != null) {
            for (var parameter : mailInput.parameters()) {
                parameters.put(parameter.key(), parameter.value());
            }
        }

        return mailSenderServices.sendTemplate(
                mailInput.templateName(),
                mailInput.to(),
                parameters
        );
    }
}

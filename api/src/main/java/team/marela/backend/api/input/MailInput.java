package team.marela.backend.api.input;

import java.util.List;

public record MailInput(String to, String templateName, List<MailInputParameter> parameters) {
}
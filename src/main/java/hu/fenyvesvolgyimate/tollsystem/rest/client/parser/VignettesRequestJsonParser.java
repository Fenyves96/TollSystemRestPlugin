package hu.fenyvesvolgyimate.tollsystem.rest.client.parser;

import java.text.MessageFormat;

public class VignettesRequestJsonParser {
    public String parseRegistrationNumberToJson(String registrationNumber){
        return MessageFormat.format("'{'\"registrationNumber\": \"{0}\"'}'", registrationNumber);
    }
}

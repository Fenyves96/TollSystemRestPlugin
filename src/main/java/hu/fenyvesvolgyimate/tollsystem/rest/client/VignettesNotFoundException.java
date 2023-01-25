package hu.fenyvesvolgyimate.tollsystem.rest.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VignettesNotFoundException extends RuntimeException {
}

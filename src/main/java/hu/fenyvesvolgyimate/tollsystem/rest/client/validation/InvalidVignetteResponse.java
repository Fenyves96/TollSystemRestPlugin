package hu.fenyvesvolgyimate.tollsystem.rest.client.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidVignetteResponse extends RuntimeException {
}

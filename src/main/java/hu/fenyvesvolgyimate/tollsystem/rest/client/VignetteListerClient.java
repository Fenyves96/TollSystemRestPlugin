package hu.fenyvesvolgyimate.tollsystem.rest.client;


import hu.fenyvesvolgyimate.tollsystem.entity.Vignette;

public interface VignetteListerClient {
    String getVignetteByRegistrationNumber(String registrationNumber);
}

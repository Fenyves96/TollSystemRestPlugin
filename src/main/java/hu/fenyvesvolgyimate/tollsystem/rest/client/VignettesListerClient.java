package hu.fenyvesvolgyimate.tollsystem.rest.client;


import hu.fenyvesvolgyimate.tollsystem.rest.client.dto.VignettesResponseDTO;

public interface VignettesListerClient {
    VignettesResponseDTO listVignettesByRegistrationNumber(String registrationNumber);
}

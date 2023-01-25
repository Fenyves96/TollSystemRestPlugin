package hu.fenyvesvolgyimate.tollsystem.rest.controller;

import hu.fenyvesvolgyimate.tollsystem.rest.client.VignettesListerRestClient;
import hu.fenyvesvolgyimate.tollsystem.rest.client.dto.VignettesResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VignetteRestController {
    @Autowired
    VignettesListerRestClient vignetteListerClient;

    @GetMapping("vignette")
    public VignettesResponseDTO listVignettesByRegistrationNumber (String registrationNumber){
        return vignetteListerClient.listVignettesByRegistrationNumber(registrationNumber);
    }
}

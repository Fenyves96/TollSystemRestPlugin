package hu.fenyvesvolgyimate.tollsystem.rest.client;

import hu.fenyvesvolgyimate.tollsystem.VignetteListerAPI;
import hu.fenyvesvolgyimate.tollsystem.presenter.VignettePresenter;
import hu.fenyvesvolgyimate.tollsystem.rest.client.dto.VignettesResponseDTO;
import hu.fenyvesvolgyimate.tollsystem.rest.client.parser.VignettesRequestJsonParser;
import hu.fenyvesvolgyimate.tollsystem.rest.client.parser.VignettesResponseJsonParser;
import hu.fenyvesvolgyimate.tollsystem.rest.client.validation.VignettesResponseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VignettesListerRestClient implements VignettePresenter, VignettesListerClient {
    @Autowired
    VignetteListerAPI vignetteListerAPI;
    VignettesResponseDTO response;
    VignettesResponseJsonParser responseParser = new VignettesResponseJsonParser();
    VignettesRequestJsonParser requestParser = new VignettesRequestJsonParser();
    VignettesResponseValidator responseValidator = new VignettesResponseValidator();

    @Override
    public void displayVehicleVignettes(String jsonResult) {
        responseValidator.validate(jsonResult);
        this.response = responseParser.parseJsonToVignetteResponseDTO(jsonResult);
    }

    @Override
    public VignettesResponseDTO listVignettesByRegistrationNumber(String registrationNumber) {
        try {
            String requestJson = requestParser.parseRegistrationNumberToJson(registrationNumber);
            vignetteListerAPI.listVignettesByRegistrationNumber(requestJson);
        }catch (Exception exception){
            throw new VignettesNotFoundException();
        }
        return response;
    }
}

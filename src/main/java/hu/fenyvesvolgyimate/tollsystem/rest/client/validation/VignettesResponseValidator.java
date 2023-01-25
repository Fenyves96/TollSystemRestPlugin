package hu.fenyvesvolgyimate.tollsystem.rest.client.validation;

import hu.fenyvesvolgyimate.tollsystem.rest.client.dto.VignettesResponseDTO;
import hu.fenyvesvolgyimate.tollsystem.rest.client.parser.VignettesResponseJsonParser;

public class VignettesResponseValidator {
    VignettesResponseJsonParser jsonParser = new VignettesResponseJsonParser();
    public void validate(String vignettesResponseJson){
        VignettesResponseDTO responseDTO = jsonParser.parseJsonToVignetteResponseDTO(vignettesResponseJson);
        if(responseDTO == null || responseDTO.getVehicle() == null || responseDTO.getVignettes() == null)
            throw new InvalidVignetteResponse();
    }
}

package hu.fenyvesvolgyimate.tollsystem.rest.client.parser;

import hu.fenyvesvolgyimate.tollsystem.parser.JsonParser;
import hu.fenyvesvolgyimate.tollsystem.rest.client.dto.VehicleDTO;
import hu.fenyvesvolgyimate.tollsystem.rest.client.dto.VignetteDTO;
import hu.fenyvesvolgyimate.tollsystem.rest.client.dto.VignettesResponseDTO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VignettesResponseJsonParser {
    JsonParser jsonParser = new JsonParser();

    public VignettesResponseDTO parseJsonToVignetteResponseDTO(String vehicleVignettesResponse) {
        JSONObject vehicleJsonObject = jsonParser.getJsonObjectByKey(vehicleVignettesResponse, "vehicle");
        VehicleDTO vehicleDTO = parseJsonObjectToVehicleResponseDTO(vehicleJsonObject);

        VignettesResponseDTO vignettesResponseDTO = new VignettesResponseDTO();
        vignettesResponseDTO.setVehicle(vehicleDTO);
        List<VignetteDTO> vignetteResponseDTOs = parseJsonArrayToVignetteDTOs(jsonParser.getJsonArrayByKey(vehicleVignettesResponse, "vignettes"));
        vignettesResponseDTO.setVignettes(vignetteResponseDTOs);

        return vignettesResponseDTO;
    }

    private List<VignetteDTO> parseJsonArrayToVignetteDTOs(JSONArray vignettes) {
        List<VignetteDTO> vignetteResponseDTOs = new ArrayList<>();
        for(int i=0; i<vignettes.length(); i++){
            try {
                JSONObject jsonObject = vignettes.getJSONObject(i);
                VignetteDTO vignetteResponseDTO = parseJsonObjectToVignetteDTO(jsonObject);
                vignetteResponseDTOs.add(vignetteResponseDTO);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return vignetteResponseDTOs;
    }

    private VignetteDTO parseJsonObjectToVignetteDTO(JSONObject jsonObject) {
        Date dateOfPurchase = jsonParser.parseDateByKey(jsonObject, "dateOfPurchase");
        Date validFrom = jsonParser.parseDateByKey(jsonObject, "validFrom");
        Date validTo = jsonParser.parseDateByKey(jsonObject, "validTo");
        String vehicleCategory = jsonParser.parseString(jsonObject, "vehicleCategory");
        boolean isValid = false;
        try {
            isValid = jsonObject.getBoolean("isValid");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        VignetteDTO vignetteDTO = new VignetteDTO();
        vignetteDTO.setDateOfPurchase(dateOfPurchase);
        vignetteDTO.setValidFrom(validFrom);
        vignetteDTO.setValidTo(validTo);
        vignetteDTO.setVehicleCategory(vehicleCategory);
        vignetteDTO.setIsValid(isValid);
        return vignetteDTO;
    }

    private VehicleDTO parseJsonObjectToVehicleResponseDTO(JSONObject vehicleJsonObject) {
        VehicleDTO vehicleDTO;
        try {
            String registrationNumber = vehicleJsonObject.getString("registrationNumber");
            int maxTransportablePassengers = vehicleJsonObject.getInt("maxTransportablePassengers");
            String make = vehicleJsonObject.getString("make");
            String category = vehicleJsonObject.getString("category");

            vehicleDTO = new VehicleDTO();
            vehicleDTO.setRegistrationNumber(registrationNumber);
            vehicleDTO.setCategory(category);
            vehicleDTO.setMake(make);
            vehicleDTO.setMaxTransportablePassengers(maxTransportablePassengers);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return vehicleDTO;
    }
}

package hu.fenyvesvolgyimate.tollsystem.rest.client.dto;

import java.util.List;

public class VignettesResponseDTO {

    VehicleDTO vehicle;
    List<VignetteDTO> vignettes;
    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public List<VignetteDTO> getVignettes() {
        return vignettes;
    }

    public void setVignettes(List<VignetteDTO> vignettes) {
        this.vignettes = vignettes;
    }
}

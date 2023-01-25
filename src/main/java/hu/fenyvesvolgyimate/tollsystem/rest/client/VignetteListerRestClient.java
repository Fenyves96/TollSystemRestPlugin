package hu.fenyvesvolgyimate.tollsystem.rest.client;

import hu.fenyvesvolgyimate.tollsystem.VignetteListerAPI;
import hu.fenyvesvolgyimate.tollsystem.presenter.VignettePresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VignetteListerRestClient implements VignettePresenter, VignetteListerClient {

    String vignettesResponse = null;
    @Autowired
    VignetteListerAPI vignetteListerAPI;

    @Override
    public void displayVehicleVignettes(String jsonResult) {
        this.vignettesResponse = jsonResult;
    }

    @Override
    public String getVignetteByRegistrationNumber(String registrationNumber) {

        vignetteListerAPI.listVignettesByRegistrationNumber(registrationNumber);
        return vignettesResponse;
    }
}

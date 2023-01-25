package hu.fenyvesvolgyimate.tollsystem.rest;

import hu.fenyvesvolgyimate.tollsystem.VignetteLister;
import hu.fenyvesvolgyimate.tollsystem.VignetteListerAPI;
import hu.fenyvesvolgyimate.tollsystem.client.VehicleRegisterClientImpl;
import hu.fenyvesvolgyimate.tollsystem.dao.SqlLiteVignetteStorage;
import hu.fenyvesvolgyimate.tollsystem.dao.VignetteStorage;
import hu.fenyvesvolgyimate.tollsystem.presenter.VignettePresenter;
import hu.fenyvesvolgyimate.tollsystem.rest.controller.VignetteRestController;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleReader;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleRegister;
import hu.fenyvesvolgyimate.vehicleregisterapp.storage.FileVehicleRepository;
import hu.fenyvesvolgyimate.vehicleregisterapp.storage.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TollSystemRestPluginApplication {

    public static void main(String[] args) {
        SpringApplication.run(TollSystemRestPluginApplication.class, args);
    }

}

package hu.fenyvesvolgyimate.tollsystem.rest.configuration;

import hu.fenyvesvolgyimate.tollsystem.VignetteLister;
import hu.fenyvesvolgyimate.tollsystem.VignetteListerAPI;
import hu.fenyvesvolgyimate.tollsystem.client.VehicleRegisterClient;
import hu.fenyvesvolgyimate.tollsystem.client.VehicleRegisterClientImpl;
import hu.fenyvesvolgyimate.tollsystem.dao.SqlLiteVignetteStorage;
import hu.fenyvesvolgyimate.tollsystem.dao.VignetteStorage;
import hu.fenyvesvolgyimate.tollsystem.entity.Vignette;
import hu.fenyvesvolgyimate.tollsystem.presenter.VignettePresenter;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleReader;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleRegister;
import hu.fenyvesvolgyimate.vehicleregisterapp.presenter.VehiclePresenter;
import hu.fenyvesvolgyimate.vehicleregisterapp.storage.FileVehicleRepository;
import hu.fenyvesvolgyimate.vehicleregisterapp.storage.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Autowired
    private ApplicationContext appContext;
    VehicleReader vehicleReader;
    VehicleRegisterClientImpl vehicleRegisterClient;
    @Bean
    VehicleRepository vehicleRepository(){
        return new FileVehicleRepository();
    }
    @Bean
    public VignetteListerAPI vignetteListerAPI(){
        return new VignetteLister(vignetteStorage(), vehicleRegisterClient(), appContext.getBean(VignettePresenter.class));
    }


    @Bean
    public VehicleReader vehicleReader(){
        if(vehicleReader == null)
            vehicleReader = new VehicleRegister(vehicleRepository(), vehicleRegisterClient());
        return vehicleReader;
    }

    @Bean
    public VehiclePresenter vehiclePresenter(){
        return vehicleRegisterClient;
    }

    @Bean
    public VignetteStorage vignetteStorage(){
        return new SqlLiteVignetteStorage();
    }

    public VehicleRegisterClientImpl vehicleRegisterClient (){
        if(vehicleRegisterClient == null) {
            this.vehicleRegisterClient = new VehicleRegisterClientImpl();
            this.vehicleRegisterClient.setVehicleReader(vehicleReader());
        }
        return this.vehicleRegisterClient;

    }


}

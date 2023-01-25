package hu.fenyvesvolgyimate.tollsystem.rest.controller;

import hu.fenyvesvolgyimate.tollsystem.VignetteListerAPI;
import hu.fenyvesvolgyimate.tollsystem.rest.client.VignetteListerRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VignetteRestController {
    @Autowired
    VignetteListerRestClient vignetteListerClient;
    String response = null;

    @GetMapping("asd")
    public String asd (){
        String asd = vignetteListerClient.getVignetteByRegistrationNumber("{\"registrationNumber\": \"ABC-123\"}");
        System.out.println(asd);
        return asd;
    }

    public void setResponse(String s) {
        response = s;
    }
}

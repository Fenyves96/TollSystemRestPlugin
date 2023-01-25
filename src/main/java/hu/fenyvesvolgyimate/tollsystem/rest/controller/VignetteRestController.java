package hu.fenyvesvolgyimate.tollsystem.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VignetteRestController {
    @GetMapping("asd")
    public String asd (){
        return "asd";
    }
}

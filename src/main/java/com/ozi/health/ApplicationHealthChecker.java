package com.ozi.health;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationHealthChecker {

    @RequestMapping("/ozi")
    public String isApplicationRunning(){
        return "OZI application is running!";
    }

}

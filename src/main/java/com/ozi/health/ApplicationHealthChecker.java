package com.ozi.health;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationHealthChecker {

    @RequestMapping("/webmon")
    public String isApplicationRunning(){
        return "Weblogic Monitoring application is running!";
    }

}

package com.example.weather.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.externalapi.service.TimeService;

@RestController 
@RequestMapping ("/time")
@CrossOrigin(origins = "*")   //http://localhost:3000
public class TimeController 
{
    @Autowired 
    TimeService ts;

// http://localhost:8080/time/gettime/usa
    @GetMapping("/gettime/{cname}")
    public String getTime(@PathVariable String cname)
    {
       //return "hey iam time";
        return this.ts.getTimeService(cname);
    }
    
}

package com.deliveryboy.controller;

import com.deliveryboy.service.kafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class locationController
{
    @Autowired
    private kafkaService kafkaService;
    @Autowired
    private locationRepo locationRepo;
    @PostMapping("/update")
    public ResponseEntity<?>updatelocation()
    {
        this.kafkaService.updatelocation("(" + Math.round(Math.random() * 100) + "," + Math.round(Math.random() * 100) + ")");
        return new ResponseEntity<>(Map.of("message","locationupdated"), HttpStatus.OK);

    }
    @PostMapping("/updates")
    public ResponseEntity<?> updatelocations(@RequestBody location location) {
        int latitude = location.getLatitude();
        int longitude = location.getLongitude();
        String name = location.getName();

        this.kafkaService.updatelocation("(" + latitude + "," + longitude + "," + name + ")");
        this.locationRepo.save(location);
        return new ResponseEntity<>(Map.of("message", "location updated"), HttpStatus.OK);
    }



}

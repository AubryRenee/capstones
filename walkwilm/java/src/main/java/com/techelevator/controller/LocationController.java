package com.techelevator.controller;


import com.techelevator.model.Location;
import com.techelevator.service.LocationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public List<Location> viewAllLocations(){
        return locationService.getLocations();
    }
}

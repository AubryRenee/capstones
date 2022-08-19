package com.techelevator.service;


import com.techelevator.dao.LocationDao;
import com.techelevator.model.Location;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationService {

    private LocationDao locationDao;


    public LocationService(LocationDao locationDao){
        this.locationDao = locationDao;
    }

    public List<Location> getLocations(){
        return locationDao.getLocations();
    }

}

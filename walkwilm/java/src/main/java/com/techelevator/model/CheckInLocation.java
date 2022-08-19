package com.techelevator.model;

public class CheckInLocation {

        private String locationName;


        public CheckInLocation(){};

        public CheckInLocation(String locationName){
            this.locationName = locationName;
        }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return "CheckInLocation{" +
                "locationName='" + locationName + '\'' +
                '}';
    }
}

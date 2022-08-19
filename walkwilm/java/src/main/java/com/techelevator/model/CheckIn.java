package com.techelevator.model;

public class CheckIn {

    private int userId;
    private int locationId;


    public CheckIn() {
    }

    ;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public CheckIn(int locationId) {

        this.locationId = locationId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "userId=" + userId +
                ", locationId=" + locationId +
                '}';
    }
}

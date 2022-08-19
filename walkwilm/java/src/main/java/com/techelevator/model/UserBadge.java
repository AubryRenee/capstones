package com.techelevator.model;

public class UserBadge {

    private int userId;
    private int badgeId;

    public UserBadge(){};

    public UserBadge(int userId, int badgeId) {
        this.userId = userId;
        this.badgeId = badgeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    @Override
    public String toString() {
        return "UserBadge{" +
                "userId=" + userId +
                ", badgeId=" + badgeId +
                '}';
    }
}

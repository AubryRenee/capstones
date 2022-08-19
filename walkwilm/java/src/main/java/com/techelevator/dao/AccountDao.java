package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;

public interface AccountDao {

//    public List<CheckIn> getCheckinsByUserId (int userId);

    public List<CheckInLocation> getCheckInLocationsByUserId(int userId);

    public List<UserBadge> viewListOfUserBadges(int userId);

   public List<Integer> getLocationIdByCheckIn(int userId);

    public void createNewCheckIn(CheckIn checkIn);

    public void earnedFoodBadge(UserBadge userBadge);

    public void earnedEntertainmentBadge(UserBadge userBadge);

    public void earnedArtCultureBadge(UserBadge userBadge);

    public void earnedEducationBadge(UserBadge userBadge);

    public void earnedOutdoorBadge(UserBadge userBadge);

    public void earnedDefenderOfLandBadge(UserBadge userBadge);


    // LIST ALL LOCATIONS WHEN VIEWING CHECK IN HISTORY
    // THEN HIGHLIGHT OR MARK LOCATIONS THAT HAVE BEEN CHECKED IN
}

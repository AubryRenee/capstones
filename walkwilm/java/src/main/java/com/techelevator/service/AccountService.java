package com.techelevator.service;

import com.techelevator.dao.AccountDao;
import com.techelevator.dao.LocationDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.NotAccountOwnerException;
import com.techelevator.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {

    private AccountDao accountDao;
    private UserDao userDao;
    private LocationDao locationDao;

    public AccountService(AccountDao accountDao, UserDao userDao, LocationDao locationDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
        this.locationDao = locationDao;
    }

    public List<CheckInLocation> getCheckInLocationsByUserId(int userId, String username) {
        validateAccountOwner(userId, username);
        return accountDao.getCheckInLocationsByUserId(userId);
    }

    public void createNewCheckin(CheckIn checkIn, int userId, String username) {
        validateAccountOwner(userId, username);
        accountDao.createNewCheckIn(checkIn);
    }

    public List<Location> getLocationsWithCheckedInFilters(int userId, String username) {
        validateAccountOwner(userId, username);
        List<Integer> locationIds = accountDao.getLocationIdByCheckIn(userId);
        List<Location> locations = locationDao.getLocations();

        for (Location location : locations) {
            if (locationIds.contains(location.getLocationId())) {
                location.setCheckedIn(true);
            } else {
                location.setCheckedIn(false);
            }
        }
        return locations;
    }

    public void earnedFoodBadge(int userId, UserBadge userBadge, String username) {
        validateAccountOwner(userId, username);
        accountDao.earnedFoodBadge(userBadge);
    }

    public void earnedEntertainmentBadge(int userId, UserBadge userBadge, String username) {
        validateAccountOwner(userId, username);
        accountDao.earnedEntertainmentBadge(userBadge);
    }

    public void earnedArtCultureBadge(int userId, UserBadge userBadge, String username) {
        validateAccountOwner(userId, username);
        accountDao.earnedArtCultureBadge(userBadge);
    }

    public void earnedEducationBadge(int userId, UserBadge userBadge, String username) {
        validateAccountOwner(userId, username);
        accountDao.earnedEducationBadge(userBadge);
    }

    public void earnedOutdoorBadge(int userId, UserBadge userBadge, String username) {
        validateAccountOwner(userId, username);
        accountDao.earnedOutdoorBadge(userBadge);
    }

    public void earnedDefenderOfLandBadge(int userId, UserBadge userBadge, String username) {
        validateAccountOwner(userId, username);
        accountDao.earnedDefenderOfLandBadge(userBadge);
    }

    public List<UserBadge> viewListOfUserBadges(int userId, String username) {
        validateAccountOwner(userId, username);
        return accountDao.viewListOfUserBadges(userId);
    }

    public void validateAccountOwner(int userId, String username) {
        try{
            int loggedInUserId = userDao.findIdByUsername(username);
            if(loggedInUserId != 0){
                if(userId != loggedInUserId){
                    throw new NotAccountOwnerException("You must be the account owner to perform this operation.");
                }
            }
        }catch (NotAccountOwnerException ex){
            throw new NotAccountOwnerException("You must be the Account Owner to perform this operation.");
        }
    }
}

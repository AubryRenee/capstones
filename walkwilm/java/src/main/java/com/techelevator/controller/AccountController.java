package com.techelevator.controller;

import com.techelevator.exception.NotAccountOwnerException;
import com.techelevator.model.CheckIn;
import com.techelevator.model.CheckInLocation;
import com.techelevator.model.Location;
import com.techelevator.model.UserBadge;
import com.techelevator.service.AccountService;
import org.hibernate.validator.internal.constraintvalidators.bv.notempty.NotEmptyValidatorForArraysOfChar;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController {

    private AccountService accountService;

    public AccountController (AccountService accountService){
     this.accountService = accountService;
}

//view list of users checkins
    @GetMapping("/checkins/{userid}")
    public List<CheckInLocation> viewListOfUserCheckins(@PathVariable int userid, Principal user) throws NotAccountOwnerException{
        return accountService.getCheckInLocationsByUserId(userid, user.getName());
    }
    @GetMapping("/locations/{userid}")
    public List<Location> getLocationsWithCheckedInFilters(@PathVariable int userid, Principal user) throws NotAccountOwnerException{
        return accountService.getLocationsWithCheckedInFilters(userid, user.getName());
    }
//    view list of user earned badges
    @GetMapping("/badges/{userid}")
    public List<UserBadge> viewListOfUserBadges(@PathVariable int userid, Principal user) throws NotAccountOwnerException {
        return accountService.viewListOfUserBadges(userid, user.getName());
    }
    //creates a check-in
    @PostMapping("/locations/{userId}/checkIn")
    public void createCheckIn(@PathVariable int userId, @RequestBody CheckIn checkIn, Principal user) throws NotAccountOwnerException {
       accountService.createNewCheckin(checkIn, userId, user.getName());
    }

    @PostMapping("badges/{userId}/food_badge")
    public void earnedFoodBadge(@PathVariable int userId, @RequestBody UserBadge userBadge, Principal user) throws NotAccountOwnerException{
        accountService.earnedFoodBadge(userId, userBadge, user.getName());
    }

    @PostMapping("badges/{userId}/entertainment_badge")
    public void earnedEntertainmentBadge(@PathVariable int userId, @RequestBody UserBadge userBadge, Principal user) throws NotAccountOwnerException{
        accountService.earnedEntertainmentBadge(userId, userBadge, user.getName());
    }

    @PostMapping("badges/{userId}/artculture_badge")
    public void earnedArtCultureBadge(@PathVariable int userId, @RequestBody UserBadge userBadge, Principal user) throws NotAccountOwnerException{
        accountService.earnedArtCultureBadge(userId, userBadge, user.getName());
    }

    @PostMapping("badges/{userId}/education_badge")
    public void earnedEducationBadge(@PathVariable int userId, @RequestBody UserBadge userBadge, Principal user) throws NotAccountOwnerException{
        accountService.earnedEducationBadge(userId, userBadge, user.getName());
    }

    @PostMapping("badges/{userId}/outdoor_badge")
    public void earnedOutdoorBadge(@PathVariable int userId, @RequestBody UserBadge userBadge, Principal user) throws NotAccountOwnerException{
        accountService.earnedOutdoorBadge(userId, userBadge, user.getName());
    }

    @PostMapping("badges/{userId}/defender_badge")
    public void earnedDefenderOfLandBadge(@PathVariable int userId, @RequestBody UserBadge userBadge, Principal user) throws NotAccountOwnerException{
        accountService.earnedDefenderOfLandBadge(userId, userBadge, user.getName());
    }

}

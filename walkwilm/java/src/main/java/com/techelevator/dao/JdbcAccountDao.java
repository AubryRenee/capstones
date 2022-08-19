package com.techelevator.dao;

import com.techelevator.exception.InsufficientCheckInsException;
import com.techelevator.exception.NotAccountOwnerException;
import com.techelevator.model.CheckIn;
import com.techelevator.model.CheckInLocation;
import com.techelevator.model.UserBadge;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao{

    private JdbcTemplate jdbcTemplate;


    public JdbcAccountDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CheckInLocation> getCheckInLocationsByUserId(int userId) {
        List<CheckInLocation> checkInLocations = new ArrayList<>();
        String sql = "SELECT location_name FROM location l JOIN check_in ci ON ci.location_id = l.location_id WHERE user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        try {
            while (rowSet.next()) {
                CheckInLocation checkInLocation = mapRowToCheckInLocation(rowSet);
                checkInLocations.add(checkInLocation);
            }
            return checkInLocations;
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("User ID Not Found");
        }
        return null;
    }

    //    This is how we get the list of checkins that only include the user_id and location_id. Not the name of the check_in
    @Override
    public List<Integer> getLocationIdByCheckIn(int userId) {

        List<Integer> checkInLocationIds = new ArrayList<>();

        String sql = "SELECT location_id FROM check_in WHERE user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        try {
            while (rowSet.next()) {
                Integer checkInLocationId = mapRowToCheckInLocationId(rowSet);
                checkInLocationIds.add(checkInLocationId);
            }
            return checkInLocationIds;

        } catch (EmptyResultDataAccessException ex) {
            System.out.println("User ID Not Found");
        }
        return null;
    }
    @Override
    public List<UserBadge> viewListOfUserBadges(int userId) {

        List<UserBadge> userBadgeList = new ArrayList<>();

        String sql = "SELECT * FROM user_badge WHERE user_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        try {
            while (rowSet.next()) {
                UserBadge userBadge = mapRowToUserBadge(rowSet);
                userBadgeList.add(userBadge);
            }
            return userBadgeList;

        } catch (EmptyResultDataAccessException ex) {
            System.out.println("User ID Not Found");

            return null;

        }
    }

    @Override
    public void createNewCheckIn(CheckIn checkIn) {
        String sql = "INSERT INTO check_in (user_id, location_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, checkIn.getUserId(), checkIn.getLocationId());
    }

    @Override
    public void earnedFoodBadge(UserBadge userBadge) {
       String checkSql = "SELECT COUNT(*) AS checkin_count FROM check_in ci JOIN location l ON l.location_id = ci.location_id WHERE category_id = 2 AND user_id = ?";
       int count = jdbcTemplate.queryForObject(checkSql, int.class, userBadge.getUserId());
       if(count > 4) {
           String badgeSql = "INSERT INTO user_badge (user_id, badge_id) VALUES (?, ?)";
           jdbcTemplate.update(badgeSql, userBadge.getUserId(), userBadge.getBadgeId());
       } else{
              throw new InsufficientCheckInsException("Insufficient Check-Ins for This Badge");
           }
       }


    @Override
    public void earnedEntertainmentBadge(UserBadge userBadge) {
        String checkSql = "SELECT COUNT(*) AS checkin_count FROM check_in ci JOIN location l ON l.location_id = ci.location_id WHERE category_id = 3 AND user_id = ?";
        int count = jdbcTemplate.queryForObject(checkSql, int.class, userBadge.getUserId());
            if (count > 4) {
                String badgeSql = "INSERT INTO user_badge (user_id, badge_id) VALUES (?, ?)";
                jdbcTemplate.update(badgeSql, userBadge.getUserId(), userBadge.getBadgeId());
            } else {
                throw new InsufficientCheckInsException("Insufficient Check-Ins for This Badge");
            }
    }

    @Override
    public void earnedArtCultureBadge(UserBadge userBadge) {
        String checkSql = "SELECT COUNT(*) AS checkin_count FROM check_in ci JOIN location l ON l.location_id = ci.location_id WHERE category_id = 1 AND user_id = ?";
        int count = jdbcTemplate.queryForObject(checkSql, int.class, userBadge.getUserId());
        if (count > 4) {
            String badgeSql = "INSERT INTO user_badge (user_id, badge_id) VALUES (?, ?)";
            jdbcTemplate.update(badgeSql, userBadge.getUserId(), userBadge.getBadgeId());
        } else {
            throw new InsufficientCheckInsException("Insufficient Check-Ins for This Badge");
        }
    }
    @Override
    public void earnedEducationBadge(UserBadge userBadge){
        String checkSql = "SELECT COUNT(*) AS checkin_count FROM check_in ci JOIN location l ON l.location_id = ci.location_id WHERE category_id = 5 AND user_id = ?";
        int count = jdbcTemplate.queryForObject(checkSql, int.class, userBadge.getUserId());
        if (count > 4) {
            String badgeSql = "INSERT INTO user_badge (user_id, badge_id) VALUES (?, ?)";
            jdbcTemplate.update(badgeSql, userBadge.getUserId(), userBadge.getBadgeId());
        } else {
            throw new InsufficientCheckInsException("Insufficient Check-Ins for This Badge");
        }
    }
    @Override
    public void earnedOutdoorBadge(UserBadge userBadge){
        String checkSql = "SELECT COUNT(*) AS checkin_count FROM check_in ci JOIN location l ON l.location_id = ci.location_id WHERE category_id = 4 AND user_id = ?";
        int count = jdbcTemplate.queryForObject(checkSql, int.class, userBadge.getUserId());
        if (count > 4) {
            String badgeSql = "INSERT INTO user_badge (user_id, badge_id) VALUES (?, ?)";
            jdbcTemplate.update(badgeSql, userBadge.getUserId(), userBadge.getBadgeId());
        } else {
            throw new InsufficientCheckInsException("Insufficient Check-Ins for This Badge");
        }
    }
    @Override
    public void earnedDefenderOfLandBadge(UserBadge userBadge){
        String checkSql = "SELECT COUNT(*) AS badge_count FROM user_badge WHERE user_id = ?;";
        int count = jdbcTemplate.queryForObject(checkSql, int.class, userBadge.getUserId());
        if (count == 5) {
            String badgeSql = "INSERT INTO user_badge (user_id, badge_id) VALUES (?, ?)";
            jdbcTemplate.update(badgeSql, userBadge.getUserId(), userBadge.getBadgeId());
        } else {
            throw new InsufficientCheckInsException("Insufficient Badges to Be Crowned Defender of the Land!");
        }
    }

    private CheckIn mapRowToCheckIn(SqlRowSet rowSet) {
        CheckIn checkIn = new CheckIn();
        checkIn.setLocationId(rowSet.getInt("location_id"));
        return checkIn;
    }

    private CheckInLocation mapRowToCheckInLocation(SqlRowSet rowSet){
        CheckInLocation checkInLocation = new CheckInLocation();
        checkInLocation.setLocationName(rowSet.getString("location_name"));
        return checkInLocation;
    }

    private Integer mapRowToCheckInLocationId(SqlRowSet rowSet){
        return (rowSet.getInt("location_id"));
    }

    private UserBadge mapRowToUserBadge(SqlRowSet rowSet){
        UserBadge userBadge = new UserBadge();
        userBadge.setUserId(rowSet.getInt("user_id"));
        userBadge.setBadgeId(rowSet.getInt("badge_id"));
        return userBadge;
    }







}

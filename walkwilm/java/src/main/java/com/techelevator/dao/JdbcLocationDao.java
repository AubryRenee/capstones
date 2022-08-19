package com.techelevator.dao;

import com.techelevator.model.Location;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLocationDao implements LocationDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcLocationDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Location> getLocations() {

        List<Location> locations = new ArrayList<>();

        String sql = "SELECT * FROM location";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        try{
            while(rowSet.next()){
                Location location = mapRowToLocation(rowSet);
                locations.add(location);
            }
            return locations;

        } catch (EmptyResultDataAccessException ex){
            System.out.println("No Locations Found");
        }
        return null;
    }

    private Location mapRowToLocation(SqlRowSet rowSet){
        Location location = new Location();

        location.setLocationId(rowSet.getInt("location_id"));
        location.setLocationName(rowSet.getString("location_name"));
        location.setCategoryId(rowSet.getInt("category_id"));
        location.setPhoneNumber(rowSet.getString("phone_number"));
        location.setStreet(rowSet.getString("street"));
        location.setCity(rowSet.getString("city"));
        location.setState(rowSet.getString("state"));
        location.setZip(rowSet.getString("zip"));
        location.setLatitude(rowSet.getString("latitude"));
        location.setLongitude(rowSet.getString("longitude"));
        location.setCheckedIn(false);

        return location;
    }


//    SELECT * FROM location ORDER BY category_id ASC
}

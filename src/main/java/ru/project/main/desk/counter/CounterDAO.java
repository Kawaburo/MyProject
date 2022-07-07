package ru.project.main.desk.counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CounterDAO {

    private JdbcTemplate jdbcTemplate;
    public CounterDAO(){ }
    @Autowired
    public CounterDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Create new counter
    public void CreateNewCounter(CounterModel counterModel){
        jdbcTemplate.update("INSERT INTO counters " +
                        "(pool_1, pool_2, pool_3,pool_4,pool_5,pool_6,pool_7,pool_8,pool_9,pool_10" +
                        ",pool_11,pool_12,pool_13,boilerRoom,kpp,ahzDown,ahzUp,mainHouseLeft,mainHouseRight," +
                        "guestHouse,workerHotel,mainWaterInput,gas)" +
                        " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);",
                counterModel.getAhzDown());
    }
}

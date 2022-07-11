package ru.project.main.desk.counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/*
    автоматическое
 */
@Component
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
                counterModel.getData(),counterModel.getPool_1(),counterModel.getPool_2(),counterModel.getPool_3(),
                counterModel.getPool_4(),counterModel.getPool_5(),counterModel.getPool_6(),counterModel.getPool_7(),
                counterModel.getPool_8(),counterModel.getPool_9(),counterModel.getPool_10(),counterModel.getPool_11(),
                counterModel.getPool_12(),counterModel.getPool_13(),counterModel.getBoilerRoom(),counterModel.getKpp(),
                counterModel.getAhzDown(),counterModel.getAhzUp(),counterModel.getMainHouseLeft(),counterModel.getMainHouseRight(),
                counterModel.getGuestHouse(),counterModel.getWorkerHotel(),counterModel.getMainWaterInput(),counterModel.getGas());
    }

    //Read list counter
    public List<CounterModel> getListCounterDAO(){
        return jdbcTemplate.query("select * from counters;", new BeanPropertyRowMapper<>(CounterModel.class));
    }
}

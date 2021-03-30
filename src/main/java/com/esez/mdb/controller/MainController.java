package com.esez.mdb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esez.mdb.model.postgres.Cars;
import com.esez.mdb.model.postgres.User;
import com.esez.mdb.model.tibero.Test;
import com.esez.mdb.repository.postgres.CarsPostgresRepository;
import com.esez.mdb.repository.postgres.UserPostgresRepository;
import com.esez.mdb.repository.tibero.TestTiberoRepository;
import com.esez.mdb.repository.tibero.UserTiberoRepository;

import java.util.List;
 
@RestController
@RequestMapping("/esez/*")
public class MainController {
 
    @Autowired
    private UserPostgresRepository postgresDao;
 
    @GetMapping("/master")
    @ResponseBody
    public List<com.esez.mdb.model.postgres.User> getMasterUser(){
        String data = "";
 
        List<com.esez.mdb.model.postgres.User> users = postgresDao.findAll();
        for(com.esez.mdb.model.postgres.User user : users) {
            data += user.getName();
            data += "\n";
        }
        System.out.println(data);
        return users;
    }
 
    @Autowired
    private UserTiberoRepository tiberoDao;
 
    @GetMapping("/stanby")
    @ResponseBody
    public List<com.esez.mdb.model.tibero.User> getStanbyUser(){
        String data = "";
 
        List<com.esez.mdb.model.tibero.User> users = tiberoDao.findAll();
        for(com.esez.mdb.model.tibero.User user : users) {
            data += user.getName();
            data += "\n";
        }
        System.out.println(data);
        return users;
    }
    
    @Autowired
    private CarsPostgresRepository carDao;
 
    @GetMapping("/car")
    @ResponseBody
    public Cars getCars(){
        String data = "";
 
        List<Cars> cars = carDao.findAll();
        for(Cars car : cars) {
            data += car.getMaker();
            data += "\n";
        }
        System.out.println(data);
        return cars.get(0);
    }
 
    @Autowired
    private TestTiberoRepository testDao;
 
    @GetMapping("/test")
    @ResponseBody
    public Test getTest(){
        String data = "";
 
        List<Test> tests = testDao.findAll();
        for(Test test : tests) {
            data += test.getName();
            data += "\n";
        }
        System.out.println(data);
        return tests.get(0);
    }
}

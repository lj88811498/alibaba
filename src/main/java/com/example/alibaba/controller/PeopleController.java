package com.example.alibaba.controller;

import com.example.alibaba.model.People;
import com.example.alibaba.service.IPeopleService;
import com.example.alibaba.util.Constant;
import com.example.alibaba.util.MethodChangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("people")
public class PeopleController {


    @Autowired
    private IPeopleService peopleService;


    @GetMapping("/{name}")
    public String hello(@PathVariable(name = "name")  String name) {
       return "hello , " + name;
    }


    @GetMapping("query")
    public List<People> query(List<People> people, List<Map<String, String>> where, List<Map<String, String>> orderBy, List<String> groupBy, Integer limit) throws Exception{
        List<People> tempPeople = new ArrayList<People>();

        try {
            tempPeople = peopleService.query(people, where, orderBy, groupBy, limit);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


        return tempPeople;
    }
 }

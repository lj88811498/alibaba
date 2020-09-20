package com.example.alibaba.service;

import com.example.alibaba.model.People;

import java.util.List;
import java.util.Map;

public interface IPeopleService {

    List<People> query(List<People> people, List<Map<String, String>> where, List<Map<String, String>> orderBy, List<String> groupBy, Integer limit) throws Exception ;
}

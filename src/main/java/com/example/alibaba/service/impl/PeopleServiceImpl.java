package com.example.alibaba.service.impl;

import com.example.alibaba.model.People;
import com.example.alibaba.service.IPeopleService;
import com.example.alibaba.util.Constant;
import com.example.alibaba.util.MethodChangeUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleServiceImpl implements IPeopleService{
    @Override
    public List<People> query(List<People> people, List<Map<String, String>> where, List<Map<String, String>> orderBy, List<String> groupBy, Integer limit) throws Exception {
        List<People> tempPeople = new ArrayList<People>();

        //判断数组长度
        if (people.size() <= Constant.NUMBER_ZERO) {
            throw new Exception(Constant.ARRAY_NULL_CONFIRM);
        }
        //多个条件，此处列出“与”的写法
        tempPeople = people;
        if (where.size() > Constant.NUMBER_ZERO) {
            for (Map<String, String> map : where) {
                for (String key : map.keySet()) {
                    String val = map.get(key);
                    tempPeople = tempPeople.stream().filter(people1 -> MethodChangeUtil.change(key).equals(val)).collect(Collectors.toList());
                }
            }
        }

        //多个排序，Map value默认为 0正序，1反序
        //这里是模拟的查询 不方便使用mybatis特性EntityWrapper
        if (orderBy.size() > Constant.NUMBER_ZERO) {
            Comparator<People> comparator = null;
            for (Map<String, String> map : orderBy) {
                //这里是为了模拟排序
                for (String key : map.keySet()) {
                    //调用排序
                    comparator = getComparator(comparator, key, map.get(key));
                    if (comparator != null) {
                        tempPeople.sort(comparator);
                    }
                }
            }
        }

        //多个分组
        //这里是模拟的查询 不方便使用mybatis特性EntityWrapper
        if (groupBy.size() > Constant.NUMBER_ZERO) {
            Comparator<People> comparator = null;
            for (String field: groupBy) {
                Map<Object, List<People>> peopleMap = getGroupBy(tempPeople, field);
            }
        }

        if (limit > Constant.NUMBER_ZERO) {
            tempPeople = tempPeople.subList(0, limit);
        }

        return tempPeople;
    }


    /**
     * 该方法直接模拟匹配字段
     * @param comparator
     * @param key
     * @param val
     * @return
     */
    private  Comparator<People> getComparator(Comparator<People> comparator , String key, String val) {
        if (key.equals(Constant.FIELD_NAME)) {
            //正序
            comparator = (people1,people2) -> people1.getPeopleName().compareTo(people2.getPeopleName());
            if (val.equals(Constant.NUMBER_ONE)) {
                //反序
                comparator.reversed();
            }
        }
        if (key.equals(Constant.FIELD_AGE)) {
            //正序
            comparator = (people1,people2) -> people1.getPeopleAge().compareTo(people2.getPeopleAge());
            if (val.equals(Constant.NUMBER_ONE)) {
                //反序
                comparator.reversed();
            }
        }
        if (key.equals(Constant.FIELD_SEX)) {
            //正序
            comparator = (people1,people2) -> people1.getPeopleSex().compareTo(people2.getPeopleSex());
            if (val.equals(Constant.NUMBER_ONE)) {
                //反序
                comparator.reversed();
            }
        }
        if (key.equals(Constant.FIELD_CITY)) {
            //正序
            comparator = (people1,people2) -> people1.getPeopleCity().compareTo(people2.getPeopleCity());
            if (val.equals(Constant.NUMBER_ONE)) {
                //反序
                comparator.reversed();
            }
        }

        return comparator;
    }

    /**
     * 该方法直接模拟匹配字段
     * @param tempPeople
     * @param key
     * @return
     */
    private Map<Object, List<People>> getGroupBy(List<People> tempPeople, String key) {
        Map<Object, List<People>> peopleMap = null;
        if (key.equals(Constant.FIELD_NAME)) {
            peopleMap = tempPeople.stream().collect(Collectors.groupingBy(People::getPeopleName));
        }
        if (key.equals(Constant.FIELD_AGE)) {
            peopleMap = tempPeople.stream().collect(Collectors.groupingBy(People::getPeopleAge));
        }
        if (key.equals(Constant.FIELD_SEX)) {
            peopleMap = tempPeople.stream().collect(Collectors.groupingBy(People::getPeopleSex));
        }
        if (key.equals(Constant.FIELD_CITY)) {
            peopleMap = tempPeople.stream().collect(Collectors.groupingBy(People::getPeopleCity));
        }

        return peopleMap;
    }
}

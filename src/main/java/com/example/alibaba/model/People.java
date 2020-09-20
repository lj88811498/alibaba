package com.example.alibaba.model;

/**
 * @date 2020-09-20
 * @author Monkey
 * @desc 人类
 */
public class People {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 名称
     */
    private String peopleName;

    /**
     * 年龄
     */
    private Integer peopleAge;

    /**
     * 性别：0男 1女
     */
    private String peopleSex;

    /**
     * 城市
     */
    private String peopleCity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public Integer getPeopleAge() {
        return peopleAge;
    }

    public void setPeopleAge(Integer peopleAge) {
        this.peopleAge = peopleAge;
    }

    public String getPeopleSex() {
        return peopleSex;
    }

    public void setPeopleSex(String peopleSex) {
        this.peopleSex = peopleSex;
    }

    public String getPeopleCity() {
        return peopleCity;
    }

    public void setPeopleCity(String peopleCity) {
        this.peopleCity = peopleCity;
    }

    public People(Integer id, String peopleName, Integer peopleAge, String peopleSex, String peopleCity) {
        this.id = id;
        this.peopleName = peopleName;
        this.peopleAge = peopleAge;
        this.peopleSex = peopleSex;
        this.peopleCity = peopleCity;
    }

    public People() {
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", peopleName='" + peopleName + '\'' +
                ", peopleAge=" + peopleAge +
                ", peopleSex=" + peopleSex +
                ", peopleCity='" + peopleCity + '\'' +
                '}';
    }
}

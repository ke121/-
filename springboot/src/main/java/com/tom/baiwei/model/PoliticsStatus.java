package com.tom.baiwei.model;

public class PoliticsStatus  {
    private  Integer id ;
    private  String name ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PoliticsStatus(Integer id, String name) {

        this.id = id;
        this.name = name;
    }

    public PoliticsStatus() {

    }
}
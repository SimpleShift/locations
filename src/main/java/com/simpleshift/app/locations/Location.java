package com.simpleshift.app.locations;


import java.util.List;

public class Location {
    private String id;
    private String company;
    private String name;
    private String address;
    private String lat;
    private String lon;
    private String weather;

    private List<Integer> openDays;
    private int openingHour;
    private int closingHour;

    private List<Employee> employees;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(int openingHour) {
        this.openingHour = openingHour;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(int closingHout) {
        this.closingHour = closingHout;
    }

    public List<Integer> getOpenDays() {
        return openDays;
    }

    public void setOpenDays(List<Integer> openDays) {
        this.openDays = openDays;
    }
}
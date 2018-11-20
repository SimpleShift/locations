package com.simpleshift.app.locations;


class Location {
    private String id;
    private String company;
    private String name;
    private String address;

    /*
    @Transient
    private List<com.simpleshift.app.locations.Employee> employees;
    */

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    String getCompany() {
        return company;
    }

    void setCompany(String company) {
        this.company = company;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }
}

package com.antipatterns.messagechain;

/**
 * Department class for Message Chain demonstration
 */
public class Department {
    private String name;
    private String building;
    private Address address;
    
    public Department(String name, String building, Address address) {
        this.name = name;
        this.building = building;
        this.address = address;
    }
    
    public String getName() { return name; }
    public String getBuilding() { return building; }
    public Address getAddress() { return address; }
}

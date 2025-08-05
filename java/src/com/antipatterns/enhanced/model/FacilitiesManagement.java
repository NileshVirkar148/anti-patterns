package com.antipatterns.enhanced.model;

public class FacilitiesManagement {
    public ParkingAssignments getParkingAssignments() { return new ParkingAssignments(); }
    public BuildingManagement getBuildingManagement() { return new BuildingManagement(); }
}

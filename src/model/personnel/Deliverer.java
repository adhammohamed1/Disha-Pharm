package model.personnel;

import java.util.Calendar;
import java.util.HashMap;

public class Deliverer extends SystemUser {

    public static HashMap<Integer, Deliverer> deliverers = new HashMap<>();

    private double salary;
    private int id;
    private String vehicle;
    private String vehicleType;

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {

        int birthMonth = getBirthDate().get(Calendar.MONTH) + 1;

        return
                id + "," + getName() + "," + vehicle + "," + vehicleType
                        + "," + salary + "," + getBirthDate().get(Calendar.DAY_OF_MONTH)
                        + "," + birthMonth + "," + getBirthDate().get(Calendar.YEAR);
    }
}

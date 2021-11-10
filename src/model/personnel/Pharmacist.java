package model.personnel;

import model.operations.Operation;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

public class Pharmacist extends SystemUser {

    public static Pharmacist activePharmacist;
    public static HashMap<Integer, Pharmacist> pharmacists = new HashMap<>();
    public static int INVALID_PHARMACIST_ID = -404;

    private Calendar loginTime;
    private Calendar logoutTime;

    private double salary;
    private int id;

    private boolean hasInventoryAccess = false;

    private Vector<Operation> completedOperations = new Vector<>();


    @Override
    public String toString() {

        int birthMonth = getBirthDate().get(Calendar.MONTH) + 1;

        return
                id + "," + getName() + "," + getPassword()
                        + "," + salary + "," + getBirthDate().get(Calendar.DAY_OF_MONTH)
                        + "," + birthMonth + "," + getBirthDate().get(Calendar.YEAR)
                        + "," + hasInventoryAccess;
    }

    public Vector<Operation> getCompletedOperations() {
        return completedOperations;
    }

    public void setCompletedOperations(Vector<Operation> completedOperations) {
        this.completedOperations = completedOperations;
    }

    public void setInventoryAccess(boolean hasInventoryAccess) {
        this.hasInventoryAccess = hasInventoryAccess;
    }

    public boolean hasInventoryAccess() {
        return hasInventoryAccess;
    }

    public Calendar getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Calendar loginTime) {
        this.loginTime = loginTime;
    }

    public Calendar getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Calendar logoutTime) {
        this.logoutTime = logoutTime;
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

    /**
     * Compares this {@code Pharmacist} object's personal information with another one to determine whether they have
     * the exact same information or not.
     * <blockquote><pre>
     *
     *     Information compared:
     *     1. ID
     *     2. Name
     *     3. Date of Birth
     *
     * </pre></blockquote>
     *
     * @param comparison {@code Pharmacist} instance to be compared with.
     * @return true if both pharmacists have the exact same personal information, and false otherwise.
     */
    public boolean hasSamePersonalInfoAs(Pharmacist comparison) {
        if (this.getId() != comparison.getId()) return false; //Check for same ID
        if (!this.getName().equals(comparison.getName())) return false; //Check for same name
        if (!(this.getBirthDate().get(Calendar.DAY_OF_YEAR) == comparison.getBirthDate().get(Calendar.DAY_OF_YEAR))) //Check for same date of birth
            return false;
        return true;
    }
}

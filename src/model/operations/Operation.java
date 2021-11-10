package model.operations;

import model.personnel.Pharmacist;

import java.io.BufferedWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public abstract class Operation {

    public static HashMap<Integer, Operation> completedOperations = new HashMap<>();
    private int operationID;
    private Calendar operationDate;
    private Pharmacist pharmacist;
    private double operationBalance;

    public Calendar getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Calendar operationDate) {
        this.operationDate = operationDate;
    }

    public void setOperationDate(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);
        this.setOperationDate(cal);
    }

    public void setOperationDate(String parseableDateString) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.getDefault());
        try {
            cal.setTime(sdf.parse(parseableDateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.setOperationDate(cal);
    }

    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public double getOperationBalance() {
        return operationBalance;
    }

    public void setOperationBalance(double operationBalance) {
        this.operationBalance = operationBalance;
    }

    public int getOperationID() {
        return operationID;
    }

    public void setOperationID(int operationID) {
        this.operationID = operationID;
    }

    public abstract void saveToFile(BufferedWriter bw);

    /**
     * @return a user-friendly {@code String} representation of the operation
     * @author Adham Mohamed Aly
     */
    public abstract String toDescriptiveString();
}

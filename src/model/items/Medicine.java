package model.items;

import controller.filehandling.MedicineFileHandler;
import controller.financial.FinancialFactors;

import java.io.BufferedWriter;
import java.util.Calendar;

public class Medicine extends Product implements Pharmaceutical {

    public static int medicineCount;
    // Medicine policies
    public static final String OTC = "OTC", PRESCRIBED = "PRESCRIBED", SCHEDULED = "SCHEDULED";
    //Medicine types
    public static final String SYRUP = "SYRUP", TABLET = "TABLET", INJECTION = "INJECTION", OINTMENT = "OINTMENT";
    private String policy;
    private String type;

    public Medicine(Medicine copy) {
        setItemID(copy.getItemID());
        setBrandName(copy.getBrandName());
        setActiveConstituent(copy.getActiveConstituent());
        setExpiryDate(copy.getExpiryDate());
        setQuantityInStock(copy.getQuantityInStock());
        setSellingPrice(copy.getSellingPrice());
        setType(copy.getType());
        setPolicy(copy.getPolicy());
    }

    public Medicine() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    @Override
    public void expire() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveToFile(BufferedWriter writer) {
        new MedicineFileHandler().saveInstance(this, writer);
    }

    @Override
    public String toDisplayableString() {
        return "#" + getItemID() + "   " + getBrandName() + "   [" + getQuantityInStock() + " units]";
    }

    public boolean  needsPrescription() {
        return !policy.equals(OTC);
    }

    @Override
    public String toString() {
        return
                this.getItemID() + ","
                        + this.getBrandName() + ","
                        + this.getActiveConstituent() + ","
                        + this.getQuantityInStock() + ","
                        + this.getSellingPrice() + ","
                        + policy + ","
                        + type + ","
                        + this.getExpiryDate().get(Calendar.DAY_OF_MONTH) + ","
                        + (this.getExpiryDate().get(Calendar.MONTH) + 1) + ","
                        + this.getExpiryDate().get(Calendar.YEAR);
    }
}

package controller.log;

import model.items.Product;
import model.personnel.SystemUser;

import java.util.ArrayList;

public class Logger {

    private static final int soldItems = 0;
    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            return new Logger();
        }
        return logger;
    }

    public ArrayList<ArrayList<Product>> getCompletedOperations() {
        return Tools.completedOperations;
    }

    public ArrayList<SystemUser> getVendors() {
        return Tools.vendors;
    }

    protected static class PurchaseLogger {


    }

    protected static class PersonnelLogger {

    }

    protected static class Tools {
        public static ArrayList<ArrayList<Product>> completedOperations = new ArrayList<>();
        public static ArrayList<SystemUser> vendors = new ArrayList<>();
    }

}

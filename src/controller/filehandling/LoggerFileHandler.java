package controller.filehandling;

import controller.financial.Balance;
import controller.log.Logger;
import model.items.Product;
import model.personnel.SystemUser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LoggerFileHandler implements FileHandler {

    protected static final String ADMIN_FINANCIAL_LOG = "log.ad-financial.bat";
    static Logger logger = Logger.getInstance();


    @Override
    public void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ADMIN_FINANCIAL_LOG));
            ArrayList<ArrayList<Product>> operations = logger.getCompletedOperations();
            ArrayList<SystemUser> vendors = logger.getVendors();
            ArrayList<double[]> operationsIncome = Balance.operationIncome;
        } catch (IOException e) {
            System.out.println("\033[31mError saving logger data: " + e.getMessage() + "\033[0m");
        }
    }

    @Override
    public boolean loadFromFile() {
        return false;
    }

    @Override
    public void loadInstance(String line) {
    }

    @Override
    public void saveInstance(Object object, BufferedWriter writer) {

    }
}

package controller.log;

import controller.financial.Balance;
import model.items.Product;
import model.personnel.SystemUser;

import javax.swing.*;
import java.util.ArrayList;

public class LoggerView {

    static Logger logger = Logger.getInstance();

    public static void updateAdminFinancialBriefing(JList<String> list) {
        String briefing = "";
        ArrayList<ArrayList<Product>> operations = logger.getCompletedOperations();
        ArrayList<double[]> operationsIncome = Balance.operationIncome;
        ArrayList<SystemUser> vendors = logger.getVendors();
        for (int i = 0; i < operations.size(); i++) {
            ArrayList<Product> operation = operations.get(i);
            double[] operationIncome = operationsIncome.get(i);
            SystemUser vendor = vendors.get(i);
            briefing += "\033[32mGained " + operationIncome[0]
                    + " from selling " + operation.size() + " items <" + vendor.getName() + ">\n";
        }
    }

}

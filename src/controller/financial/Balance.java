package controller.financial;

import model.operations.Operation;
import system.general.DateAndTime;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * This class handles all financial balance-related operations such as
 * overall balance and net monthly balance.
 * @author Adham Mohamed Aly
 */
public class Balance {

    public static double monthNetBalance;

    public static double totalBalance;
    public static double totalIncome;
    public static double totalExpenses;

    public static double sellingIncome;
    public static double deliveryIncome;
    public static double taxIncome;
    public static ArrayList<double[]> operationIncome = new ArrayList<>();

    /**
     * Update the overall total balance
     * @param subTotal Subtotal to be added
     * @param delivery Delivery fees
     * @param tax Taxes to be added
     */
    public static void updateBalance(double subTotal, double delivery, double tax) {
        Balance.sellingIncome += subTotal;
        Balance.deliveryIncome += delivery;
        Balance.taxIncome += tax;
        Balance.totalIncome += (subTotal + delivery + tax);
        Balance.operationIncome.add(
                new double[]{subTotal, delivery, tax});
        Balance.totalBalance = Balance.totalIncome - Balance.totalExpenses;
    }

    /**
     * Adjusts the net operation balance for the current month
     */
    public static void adjustMonthBalance() {
        monthNetBalance = 0;
        DateAndTime.setCurrentDate();
        Calendar cal = DateAndTime.currentDate;
        for (int key : Operation.completedOperations.keySet()) {
            Operation op = Operation.completedOperations.get(key);
            if (op.getOperationDate().get(Calendar.MONTH) == cal.get(Calendar.MONTH)) {
                monthNetBalance += op.getOperationBalance();
            }
        }
    }
}

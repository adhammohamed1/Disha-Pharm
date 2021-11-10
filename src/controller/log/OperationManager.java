package controller.log;

import controller.filehandling.OperationsFileHandler;
import controller.financial.InvoiceGenerator;
import controller.financial.ShoppingCart;
import controller.financial.TransactionManager;
import model.operations.ClientPurchase;
import model.operations.Operation;
import model.personnel.Pharmacist;
import system.general.DateAndTime;

import java.io.IOException;

public class OperationManager {

    public static final String OPERATION_CLIENT_PURCHASE = "class ClientPurchase";
    //TODO: Add more operation type constants

    public void logClientPurchase() {
        ClientPurchase purchase = new ClientPurchase();
        purchase.setSoldProducts(ShoppingCart.shoppingCartItems);
        DateAndTime.setCurrentDate();
        purchase.setOperationDate(DateAndTime.currentDate);
        purchase.setPharmacist(Pharmacist.activePharmacist);
        purchase.setOperationBalance(ShoppingCart.totalSum);
        purchase.setSubTotal(ShoppingCart.subTotal);
        purchase.setDelivery(ShoppingCart.deliveryFees);
        purchase.setTax(ShoppingCart.taxes);
        purchase.setOperationID(TransactionManager.generateOperationID());
        InvoiceGenerator.op = purchase;
        Operation.completedOperations.put(purchase.getOperationID(), purchase);
        try {
            new OperationsFileHandler().saveToFile();
        } catch (IOException e) {
            System.out.println("\033[31mError logging client purchase: " + e.getMessage() + "\033[0m");
        }
    }

}

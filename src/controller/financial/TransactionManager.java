package controller.financial;

import controller.filehandling.ProductFileHandler;
import controller.log.OperationManager;
import model.operations.Operation;

import java.io.IOException;

public class TransactionManager {

    public static int generateOperationID() {
        int rand;
        do {
            rand = (int) (Math.random() * 5000000);
        } while (Operation.completedOperations.get(rand) != null);
        return rand;
    }

    /**
     * Returns the given operation's ID
     */
    public static String getOperationID(Operation op) {
        return String.valueOf(op.getOperationID());
    }

    /**
     * Completes purchase. Does all file handling and logs all relevant data.
     */
    public void completePurchase() throws IOException {
        new ProductFileHandler().saveToFile();
        new OperationManager().logClientPurchase();
        Balance.updateBalance(ShoppingCart.subTotal, ShoppingCart.deliveryFees, ShoppingCart.taxes);
    }

}

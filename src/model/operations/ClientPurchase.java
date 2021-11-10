package model.operations;

import controller.filehandling.ClientPurchaseFileHandler;
import controller.financial.FinancialFactors;
import controller.management.personnel.PersonnelHandler;
import model.items.Product;

import java.io.BufferedWriter;
import java.util.ArrayList;

/**
 * Represents operations in which products registered in the system are sold to a client.
 * Typically, has positive financial balance as the products are sold for money.
 * @author Adham Mohamed Aly
 */
public class ClientPurchase extends Operation {

    private ArrayList<Product> soldProducts;
    private double subTotal, delivery, tax;

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDelivery() {
        return delivery;
    }

    public void setDelivery(double delivery) {
        this.delivery = delivery;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     * @return products sold in this client purchase
     * @author Adham Mohamed Aly
     */
    public ArrayList<Product> getSoldProducts() {
        return soldProducts;
    }

    /**
     * @param soldProducts products sold in this client purchase
     * @author Adham Mohamed Aly
     */
    public void setSoldProducts(ArrayList<Product> soldProducts) {
        this.soldProducts = new ArrayList<>();
        this.soldProducts.addAll(soldProducts);
    }

    @Override
    public void saveToFile(BufferedWriter bw) {
        new ClientPurchaseFileHandler().saveInstance(this, bw);
    }

    @Override
    public String toDescriptiveString() {
        int soldQuantity = 0;
        for (Product soldProduct : soldProducts) {
            soldQuantity += soldProduct.getQuantityInStock();
        }
        return "[Operation #" + getOperationID() + "] "
                + "[" + getPharmacist().getName() + "] "
                + "Sold " + soldProducts.size() + " items "
                + "(" + soldQuantity + " units)"
                + " for " + FinancialFactors.PREFERRED_CURRENCY + getOperationBalance()
                + " on " + getOperationDate().getTime();
    }

    public String soldProductsStringFormat() {
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < soldProducts.size(); i++) {
            Product soldProduct = soldProducts.get(i);
            finalString.append(soldProduct.getClass()).append(",").append(soldProduct);
            if (i < soldProducts.size() - 1) finalString.append("*");
        }
        return finalString.toString();
    }

    @Override
    public String toString() {
        return String.valueOf(this.getOperationID())
                + "," + String.valueOf(this.getOperationBalance())
                + "," + String.valueOf(this.getSubTotal())
                + "," + String.valueOf(this.getTax())
                + "," + String.valueOf(this.getDelivery())
                + "," + String.valueOf(this.getPharmacist().getId() - PersonnelHandler.PHARMACIST_BASE_ID)
                + "," + String.valueOf(this.getPharmacist().getName())
                + "," + String.valueOf(this.getOperationDate().getTime())
                + "," + String.valueOf(soldProducts.size())
                + "," + soldProductsStringFormat();
    }
}

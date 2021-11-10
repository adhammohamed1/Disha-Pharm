package controller.management.items;

import model.items.Medicine;
import model.items.Product;
import system.exceptions.EmptyFieldException;
import system.exceptions.IllegalIDException;
import system.exceptions.IllegalPriceException;
import system.exceptions.IllegalQuantityException;

import java.io.IOException;
import java.util.Calendar;

public class MedicineHandler extends ProductHandler implements ItemHandler {

    public static String inputPolicy;
    public static String inputType;

    @Override
    public void addToStock(String productType) throws NumberFormatException, IOException {
        int quantity, ID;
        double price;

        if (inputBrandName.isEmpty() || inputActiveConst.isEmpty()
                || inputPrice.isEmpty() || inputQuantity.isEmpty()
                || inputID.isEmpty()) {
            throw new EmptyFieldException();
        }
        try {
            ID = Integer.parseInt(inputID);
            if (ID < 0) {
                throw new IllegalIDException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalIDException();
        }
        try {
            quantity = Integer.parseInt(inputQuantity);
            if (quantity < 1) {
                throw new IllegalQuantityException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalQuantityException();
        }
        try {
            if ((price = Double.parseDouble(inputPrice)) < 0) {
                throw new IllegalPriceException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalPriceException();
        }
        Medicine medicine = (Medicine) Product.productInventory.get(ID);
        if (medicine != null) {
            medicine.setQuantityInStock(quantity + medicine.getQuantityInStock());
        } else {
            medicine = new Medicine();
            Product.productInventory.put(ID, medicine);

            medicine.setItemID(ID);
            medicine.setBrandName(inputBrandName);
            medicine.setActiveConstituent(inputActiveConst);
            medicine.setSellingPrice(price);
            medicine.setQuantityInStock(quantity);
            medicine.setPolicy(inputPolicy);
            medicine.setType(inputType);

            Calendar cal = Calendar.getInstance();
            cal.clear();
            cal.set(inputExpiryYear, inputExpiryMonth - 1, inputExpiryDay);

            medicine.setExpiryDate(cal);
            Medicine.medicineCount++;
        }
    }

}

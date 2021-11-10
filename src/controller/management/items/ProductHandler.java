package controller.management.items;

import controller.financial.ShoppingCart;
import model.items.Medicine;
import model.items.Product;

import java.io.IOException;

import static model.items.Pharmaceutical.CLASS_COSMETIC;
import static model.items.Pharmaceutical.CLASS_MEDICINE;

public class ProductHandler implements ItemHandler {

    public static String inputBrandName;
    public static String inputActiveConst;
    public static String inputPrice;
    public static String inputQuantity;
    public static int inputExpiryDay, inputExpiryMonth, inputExpiryYear;
    public static String inputID;

    @Override
    public void addToStock(String productType) throws NumberFormatException, IOException {
        if (productType.equals(CLASS_MEDICINE)) {
            new MedicineHandler().addToStock(null);
        } else if (productType.equals(CLASS_COSMETIC)) {
            new CosmeticHandler().addToStock(null);
        }
    }

    public static void checkMedsForPrescriptionRequirement() {
        String policy;
        for (Product product : ShoppingCart.shoppingCartItems) {
            if (product instanceof Medicine) {
                if (!(policy = ((Medicine) product).getPolicy()).equals(Medicine.OTC)) {
                    if (policy.equals(Medicine.PRESCRIBED)) {
                        ShoppingCart.prescriptionMedsInCart.add(product);
                    } else if (policy.equals(Medicine.SCHEDULED)) {
                        ShoppingCart.scheduledMedsInCart.add(product);
                    }
                }
            }
        }
    }

    public static boolean purchaseNeedsPrescription() {
        return !ShoppingCart.prescriptionMedsInCart.isEmpty() || !ShoppingCart.scheduledMedsInCart.isEmpty();
    }
}

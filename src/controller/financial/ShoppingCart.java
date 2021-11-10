package controller.financial;

import model.items.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ShoppingCart {

    public static ArrayList<Product> shoppingCartItems = new ArrayList<>();
    public static HashSet<Product> prescriptionMedsInCart = new HashSet<>();
    public static HashSet<Product> scheduledMedsInCart = new HashSet<>();
    public static double subTotal = 0, deliveryFees = 0, totalSum = 0;
    public static double taxes = ShoppingCart.subTotal * FinancialFactors.TAX_FACTOR;
    public static int selectedID, selectedQuantity;
    public static final int REMOVE_ALL = -2;

    public static String[] getShoppingCartContentsAsStrings() {
        subTotal = 0;
        int shoppingCartCounter = 0;
        String[] contents = new String[shoppingCartItems.size() + 1];

        for (Product product : shoppingCartItems) {

            if (product.getQuantityInStock() == 0) {
                shoppingCartItems.remove(product);
                continue;
            }

            contents[shoppingCartCounter++] = product.toShoppingCartRepresentation();
            subTotal += product.getSellingPrice() * product.getQuantityInStock();
        }

        updateTotalSum();

        return contents;
    }

    public static Product newEntryInCart(Product product) {

        for (Product productInCart : shoppingCartItems) {
            if (productInCart.getItemID() == product.getItemID()) {
                return productInCart;
            }
        }
        return null;
    }

    public static void emptyTheCart() {
        for (Product productInCart : shoppingCartItems) {
            int id = productInCart.getItemID();
            Product productInStock = Product.productInventory.get(id);
            productInStock.setQuantityInStock(productInStock.getQuantityInStock() + productInCart.getQuantityInStock());
        }
        clear();
    }

    public static void removeFromCart(Product selectedItem, int inputQuantity) {
        Product productInStock = Product.productInventory.get(selectedItem.getItemID());
        if (inputQuantity == REMOVE_ALL || selectedItem.getQuantityInStock() == inputQuantity) {
            productInStock.setQuantityInStock(productInStock.getQuantityInStock() + selectedItem.getQuantityInStock());
            ShoppingCart.shoppingCartItems.remove(selectedItem);
        } else {
            productInStock.setQuantityInStock(inputQuantity + productInStock.getQuantityInStock());
            selectedItem.setQuantityInStock(selectedItem.getQuantityInStock() - inputQuantity);
        }
    }

    public static void updateTotalSum() {
        updateTaxes();
        updateSubtotal();
        totalSum = subTotal + deliveryFees + taxes;
    }

    public static void updateSubtotal() {
        subTotal = 0;
        for(Product productInCart : shoppingCartItems) {
            subTotal += productInCart.getQuantityInStock() * productInCart.getSellingPrice();
        }
    }

    public static void updateTaxes() {
        taxes = subTotal * FinancialFactors.TAX_FACTOR;
    }

    public static void clear() {
        shoppingCartItems.clear();
        prescriptionMedsInCart.clear();
        scheduledMedsInCart.clear();
        subTotal = 0;
        taxes = 0;
        deliveryFees = 0;
        totalSum = 0;
    }
}

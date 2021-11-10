package model.items;

import controller.financial.FinancialFactors;
import controller.financial.ShoppingCart;
import controller.searching.BST;

import java.io.BufferedWriter;
import java.util.Calendar;
import java.util.HashMap;

public abstract class Product {

    public static HashMap<Integer, Product> productInventory = new HashMap<>();
    public static BST<Integer> productSearchTree = new BST<>();

    private String brandName;
    private String activeConstituent;

    private int itemID;
    private int quantityInStock;

    private double sellingPrice;

    private Calendar expiryDate;

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setExpiryDate(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);
        this.setExpiryDate(cal);
    }

    public String getActiveConstituent() {
        return activeConstituent;
    }

    public void setActiveConstituent(String activeConstituent) {
        this.activeConstituent = activeConstituent;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setSellingDate(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);
        this.setExpiryDate(cal);
    }

    public abstract void saveToFile(BufferedWriter writer);

    public abstract String toDisplayableString();

    public String toShoppingCartRepresentation() {
        return ShoppingCart.shoppingCartItems.contains(this) ?
                ((ShoppingCart.shoppingCartItems.indexOf(this) + 1)
                        + ". [" + brandName + "] [" + itemID + "] [" + quantityInStock + " units] ["
                        + FinancialFactors.PREFERRED_CURRENCY + sellingPrice + "]\n")
                : "";
    }

    public Product() {
    }

    public Product(Product copy) {
        itemID = copy.itemID;
        brandName = copy.brandName;
        activeConstituent = copy.activeConstituent;
        expiryDate = copy.expiryDate;
        quantityInStock = copy.quantityInStock;
        sellingPrice = copy.sellingPrice;
    }

    @Override
    public Product clone() {
        if (this instanceof Medicine) {
            return new Medicine((Medicine) this);
        } else if (this instanceof Cosmetic) {
            return new Cosmetic((Cosmetic) this);
        }

        return null;
    }
}

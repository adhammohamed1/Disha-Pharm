package model.operations;

import model.items.Product;

import java.io.BufferedWriter;
import java.util.ArrayList;

/**
 * Represents operations in which products are imported into the system from an outside source.
 * Typically, has negative financial balance as the products are bought with money.
 * @author Adham Mohamed Aly
 */
public class StockUpOperation extends Operation {

    private ArrayList<Product> boughtProducts;


    /**
     * @return products bought in this stock-up operation
     * @author Adham Mohamed Aly
     */
    public ArrayList<Product> getBoughtProducts() {
        return this.boughtProducts;
    }

    /**
     * @param boughtProducts products bought in this stock-up operation
     * @author Adham Mohamed Aly
     */
    public void setBoughtProducts(ArrayList<Product> boughtProducts) {
        this.boughtProducts = new ArrayList<>();
        this.boughtProducts.addAll(boughtProducts);
    }

    @Override
    public void saveToFile(BufferedWriter bw) {

    }

    @Override
    public String toDescriptiveString() {
        return null;
    }
}

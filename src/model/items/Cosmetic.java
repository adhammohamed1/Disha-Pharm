package model.items;

import java.io.BufferedWriter;

public class Cosmetic extends Product implements Pharmaceutical {

    public Cosmetic(Cosmetic copy) {
        setItemID(copy.getItemID());
        setBrandName(copy.getBrandName());
        setActiveConstituent(copy.getActiveConstituent());
        setExpiryDate(copy.getExpiryDate());
        setQuantityInStock(copy.getQuantityInStock());
        setSellingPrice(copy.getSellingPrice());
    }

    public Cosmetic() {
    }

    @Override
    public void expire() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveToFile(BufferedWriter writer) {

    }

    @Override
    public String toDisplayableString() {
        return null;
    }
}

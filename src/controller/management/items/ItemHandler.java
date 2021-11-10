package controller.management.items;

import java.io.IOException;

public interface ItemHandler {

    void addToStock(String productType) throws IOException;

}

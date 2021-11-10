package controller.authentication.item;

import model.items.Product;

public class ProductAuthenticator implements ItemAuthenticator {

    @Override
    public boolean authenticateItem() {
        return false;
    }

    @Override
    public void decryptItemData(Product product) {

    }

    @Override
    public void encryptItemDate(Product product) {

    }
}

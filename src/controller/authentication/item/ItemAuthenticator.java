package controller.authentication.item;

import model.items.Product;

/**
 * This interface is responsible for item data authentication and encryption.
 * The {@code ItemAuthenticator} interface contains <b>3</b> abstract methods:
 * <i>authenticateItem()</i> ,
 * <i>decryptItemData()</i>
 * &
 * <i>encryptItemDate()</i>.
 *
 * @author Adham Mohamed Aly
 * @implNote It is advised to strictly manipulate encrypted data
 * and only decrypt user data when absolutely necessary.
 **/
public interface ItemAuthenticator {

    boolean authenticateItem();

    void decryptItemData(Product product);

    void encryptItemDate(Product product);

}

package controller.authentication.user;

import model.personnel.SystemUser;

/**
 * This interface is responsible for personnel data authentication and encryption.
 * The {@code UserAuthenticator} interface contains <b>3</b> abstract methods:
 * <i>authenticateUser()</i> ,
 * <i>encryptUserData()</i>
 * &
 * <i>decryptUserData()</i>.
 *
 * @author Adham Mohamed Aly
 * @implNote It is advised to strictly manipulate encrypted data
 * and only decrypt user data when absolutely necessary.
 **/
public interface UserAuthenticator {

    boolean authenticateUser();

    void decryptUserData(SystemUser systemUser);

    void encryptUserDate(SystemUser systemUser);

}

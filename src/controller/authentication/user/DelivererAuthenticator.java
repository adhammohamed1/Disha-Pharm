package controller.authentication.user;

import model.personnel.SystemUser;

/**
 * {@code Deliverer}-related implementation of the {@code UserAuthenticator} interface.
 * This implementation provides all the necessary operations related to {@code Deliverer} verification.
 *
 * @author Adham Mohamed Aly
 **/
public class DelivererAuthenticator implements UserAuthenticator {
    @Override
    public boolean authenticateUser() {
        return false;
    }

    @Override
    public void decryptUserData(SystemUser systemUser) {

    }

    @Override
    public void encryptUserDate(SystemUser systemUser) {

    }
}

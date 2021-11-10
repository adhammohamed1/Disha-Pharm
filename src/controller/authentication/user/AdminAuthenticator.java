package controller.authentication.user;

import controller.filehandling.AdminFileHandler;
import model.personnel.Admin;
import model.personnel.SystemUser;
import system.exceptions.EmptyFieldException;
import system.exceptions.NoSuchUsernameException;
import system.exceptions.UsingDefaultCredentialsException;
import system.exceptions.WrongPasswordException;

/**
 * {@code Admin}-related implementation of the {@code UserAuthenticator} interface.
 * This implementation provides all the necessary operations related to {@code Admin} login verification.
 * The {@code AdminAuthenticator} class also contains all the public static constants and variables related to initial {@code Admin}
 * setup.
 *
 * @author Adham Mohamed Aly
 **/
public class AdminAuthenticator implements UserAuthenticator {

    public static final String defaultAdminUsername = "admin";
    public static final String defaultAdminPassword = "admin";
    public static boolean useDefault = true;
    public static String inputUsername = "";
    public static String inputPassword = "";

    /**
     * The {@code Admin}-related implementation of the abstract method from the {@code UserAuthenticator} interface.
     * This method validates input login credentials during {@code Admin} login.
     *
     * @throws EmptyFieldException              In case the user leaves a blank field in the login window.
     * @throws NoSuchUsernameException          In case the user enters an unrecognized username.
     * @throws WrongPasswordException           In case the user enters an incorrect password for a recognized username.
     * @throws UsingDefaultCredentialsException In case the user enters the default {@code Admin} credentials
     *                                          when the {@code Admin} has set custom credentials via the {@code AdminSettings} menu.
     * @author Adham Mohamed Aly
     **/
    @Override
    public boolean authenticateUser() {
        if (inputUsername.trim().isEmpty() || inputPassword.isEmpty()) {
            throw new EmptyFieldException();
        }
        if (!(new AdminFileHandler().loadFromFile())) {
            return false;
        }
        if (!useDefault && inputUsername.equals(defaultAdminUsername)) {
            throw new UsingDefaultCredentialsException();
        }
        if (!inputUsername.trim().equalsIgnoreCase(Admin.currentAdmin.getUserName())) {
            throw new NoSuchUsernameException();
        }
        if (!inputPassword.equals(Admin.currentAdmin.getPassword())) {
            throw new WrongPasswordException();
        }
        return true;
    }

    /**
     * The {@code Admin}-related implementation of the abstract method from the {@code UserAuthenticator} interface.
     * This method decrypts data of given {@code Admin} instance. The method will be obsolete if the {@code Admin} instance
     * is not already encrypted. However, It will not throw any exceptions in that case.
     *
     * @param adminInstance {@code Admin} instance for which the data will be decrypted.
     * @implNote Pass the {@code currentAdmin} instance as the {@code Admin} is a singleton class.
     * @author Adham Mohamed Aly
     **/
    @Override
    public void decryptUserData(SystemUser adminInstance) {

    }

    /**
     * The {@code Admin}-related implementation of the abstract method from the {@code UserAuthenticator} interface.
     * This method encrypts data of given {@code Admin} instance. The method will be obsolete if the {@code Admin} instance
     * is already encrypted. However, It will not throw any exceptions in that case.
     *
     * @param adminInstance {@code Admin} instance for which the data will be encrypted.
     * @implNote Pass the {@code currentAdmin} instance as the {@code Admin} is a singleton class.
     * @author Adham Mohamed Aly
     **/
    @Override
    public void encryptUserDate(SystemUser adminInstance) {

        if (!adminInstance.isEncrypted) {
            Admin admin = (Admin) adminInstance;
        }
    }


}

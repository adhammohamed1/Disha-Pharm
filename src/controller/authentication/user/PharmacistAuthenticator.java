package controller.authentication.user;

import controller.management.personnel.PersonnelHandler;
import model.personnel.Pharmacist;
import model.personnel.SystemUser;
import system.exceptions.EmptyFieldException;
import system.exceptions.IllegalNegativeNumberException;
import system.exceptions.NoSuchUsernameException;
import system.exceptions.WrongPasswordException;

/**
 * {@code Pharmacist}-related implementation of the {@code UserAuthenticator} interface.
 * This implementation provides all the necessary operations related to {@code Pharmacist} verification.
 *
 * @author Adham Mohamed Aly
 **/
public class PharmacistAuthenticator implements UserAuthenticator {

    public static String inputID;
    public static String inputPassword = "";

    /**
     * The {@code Pharmacist}-related implementation of the abstract method from the {@code UserAuthenticator} interface.
     * This method validates input login credentials during {@code Pharmacist} login.
     * Credentials are validated by comparing the user input with data of instance with corresponding ID in the
     * {@code HashMap} <i>pharmacists</i> from the model class {@link Pharmacist}.
     *
     * @throws EmptyFieldException            In case the user leaves a blank field in the login window.
     * @throws NoSuchUsernameException        In case the user enters an unrecognized ID({@code HashMap} returns {@code null})
     *                                        or if the user entered an invalid ID(In place of {@code NumberFormatException}).
     * @throws WrongPasswordException         In case the user enters an incorrect password for a recognized ID.
     * @throws IllegalNegativeNumberException In case the user enters a number less than {@code Pharmacist} base ID
     *                                        (= 30,000) in the ID field.
     * @author Adham Mohamed Aly
     **/
    @Override
    public boolean authenticateUser() {
        int ID;
        if (inputID.isEmpty() || inputPassword.isEmpty()) {
            throw new EmptyFieldException();
        }
        try {
            ID = Integer.parseInt(inputID);
        } catch (NumberFormatException e) {
            throw new NoSuchUsernameException();
        }
        Pharmacist.activePharmacist = Pharmacist.pharmacists.get(ID - PersonnelHandler.PHARMACIST_BASE_ID);
        if (Pharmacist.activePharmacist == null || ID == PersonnelHandler.PHARMACIST_BASE_ID) {
            throw new NoSuchUsernameException();
        }
        if (!inputPassword.equals(Pharmacist.activePharmacist.getPassword())) {
            throw new WrongPasswordException();
        }
        return true;
    }

    /**
     * The {@code Pharmacist}-related implementation of the abstract method from the {@code UserAuthenticator} interface.
     * This method decrypts data of given {@code Pharmacist} instance.
     * The method will be obsolete if the {@code Pharmacist} instance is not already encrypted.
     * However, It will not throw any exceptions in that case.
     *
     * @param pharmacistInstance {@code Pharmacist} instance for which the data will be decrypted.
     * @author Adham Mohamed Aly
     **/
    @Override
    public void decryptUserData(SystemUser pharmacistInstance) {
        Pharmacist pharmacist = (Pharmacist) pharmacistInstance;
    }


    /**
     * The {@code Pharmacist}-related implementation of the abstract method from the {@code UserAuthenticator} interface.
     * This method encrypts data of given {@code Pharmacist} instance.
     * The method will be obsolete if the {@code Pharmacist} instance is already encrypted.
     * However, It will not throw any exceptions in that case.
     *
     * @param pharmacistInstance {@code Pharmacist} instance for which the data will be encrypted.
     * @author Adham Mohamed Aly
     **/
    @Override
    public void encryptUserDate(SystemUser pharmacistInstance) {
        if (!pharmacistInstance.isEncrypted) {

            Pharmacist pharmacist = (Pharmacist) pharmacistInstance;
        }

    }
}

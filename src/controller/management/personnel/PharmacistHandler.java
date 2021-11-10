package controller.management.personnel;

import model.personnel.Pharmacist;
import system.exceptions.EmptyFieldException;
import system.exceptions.IllegalNegativeNumberException;

import java.util.Calendar;

public class PharmacistHandler implements PersonnelHandler {

    //    <input-variables>
    public static String inputName, inputPassword;
    public static int inputBirthDay, inputBirthMonth, inputBirthYear;
    public static double inputSalary;
    public static boolean inputInventoryAccess;
    //    </input-variables>

    @Override
    public int addToSystem() {

        if (inputName.isEmpty() || inputPassword.isEmpty()) {
            throw new EmptyFieldException();
        }
        if (inputSalary < 0) {
            throw new IllegalNegativeNumberException();
        }
        int newID = generateNewID();
        Pharmacist newPharmacist = new Pharmacist();
        Pharmacist.pharmacists.put(newID - PHARMACIST_BASE_ID, newPharmacist);
        newPharmacist.setId(newID);
        newPharmacist.setName(inputName);
        newPharmacist.setPassword(inputPassword);
        newPharmacist.setSalary(inputSalary);
        newPharmacist.setInventoryAccess(inputInventoryAccess);

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(inputBirthYear, inputBirthMonth - 1, inputBirthDay);
        newPharmacist.setBirthDate(cal);
        return newID;
    }

    public int generateNewID() {
        int newID = 1;
        while (Pharmacist.pharmacists.containsKey(newID)) {
            newID++;
        }
        return newID + PHARMACIST_BASE_ID;
    }

//    boolean logItem(Pharmacist pharmacist) {
//        Product soldProduct;
//
//        for (Product product : ShoppingCart.shoppingCartItems) {
//            pharmacist.getCompletedOperations().add(product);
//        }
//
//        return true;
//    }

}

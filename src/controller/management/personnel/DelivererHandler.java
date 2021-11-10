package controller.management.personnel;

import model.personnel.Deliverer;
import system.exceptions.EmptyFieldException;
import system.exceptions.IllegalNegativeNumberException;

import java.util.Calendar;

public class DelivererHandler implements PersonnelHandler {

    //    <input-variables>
    public static String inputName, inputVehicle, inputVehicleType;
    public static int inputBirthDay, inputBirthMonth, inputBirthYear;
    public static double inputSalary;
    //    </input-variables>

    @Override
    public int addToSystem() {

        if (inputName.isEmpty() || inputVehicle.isEmpty()) {
            throw new EmptyFieldException();
        }
        if (inputSalary < 0) {
            throw new IllegalNegativeNumberException();
        }
        int newID = DELIVERER_BASE_ID + Deliverer.deliverers.size();
        Deliverer newDeliverer = new Deliverer();
        Deliverer.deliverers.put(newID - PHARMACIST_BASE_ID, newDeliverer);

        newDeliverer.setId(newID);
        newDeliverer.setName(inputName);
        newDeliverer.setVehicle(inputVehicle);
        newDeliverer.setVehicleType(inputVehicleType);
        newDeliverer.setSalary(inputSalary);

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(inputBirthYear, inputBirthMonth - 1, inputBirthDay);
        newDeliverer.setBirthDate(cal);

        return newID;
    }
}

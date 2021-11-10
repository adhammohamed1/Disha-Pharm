package system.general;

import controller.filehandling.DelivererFileHandler;
import controller.filehandling.PharmacistFileHandler;
import controller.filehandling.ProductFileHandler;

public class ProgramInitializer {

    public void initProgram() {

        /*==>  Load data from database  <==*/

        PharmacistFileHandler pharmacistFileHandler = new PharmacistFileHandler();
        DelivererFileHandler delivererFileHandler = new DelivererFileHandler();
        ProductFileHandler productFileHandler = new ProductFileHandler();


        pharmacistFileHandler.loadFromFile();  // Load pharmacist data
        delivererFileHandler.loadFromFile();  // Load deliverer data
        productFileHandler.loadFromFile();  // Load product data


        /*==>  Set Date & Time  <==*/

        DateAndTime.setCurrentDate();

    }

}

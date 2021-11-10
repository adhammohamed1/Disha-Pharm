package model.personnel;

import controller.filehandling.PharmacistFileHandler;
import controller.management.personnel.PersonnelHandler;

public class Admin extends SystemUser {

    public static Admin currentAdmin = new Admin();
    public static Pharmacist adminPharmacist;
    public static boolean adminActive = false;

    private Admin() {
        adminActive = true;
    }

    public static Admin getInstance() {
        return currentAdmin;
    }

    public static void activateAdminPharmacist() {
        adminPharmacist = new Pharmacist();
        adminPharmacist.setName(currentAdmin.getName());
        adminPharmacist.setId(PersonnelHandler.PHARMACIST_BASE_ID);
        adminPharmacist.setBirthDate(currentAdmin.getBirthDate());
        adminPharmacist.setPassword(currentAdmin.getPassword());
        adminPharmacist.setInventoryAccess(true);
        Pharmacist.pharmacists.put(0, adminPharmacist);
        new PharmacistFileHandler().saveToFile();
        Pharmacist.activePharmacist = adminPharmacist;
    }

}

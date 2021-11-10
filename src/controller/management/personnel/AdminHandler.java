package controller.management.personnel;

import controller.authentication.user.AdminAuthenticator;
import model.personnel.Admin;

import java.util.Calendar;


public class AdminHandler {

    /**
     * Resets the {@code currentAdmin} info to default values.
     * Default {@code Admin} values are:
     * <blockquote><pre>
     *   Username -> admin
     *   Password -> admin
     *   Name -> Admin
     * </pre></blockquote>
     *
     * @author Adham Mohamed Aly
     **/
    public static void setDefaultValues() {
        AdminAuthenticator.useDefault = true;
        setDefaultLoginCredentials();
        Admin.currentAdmin.setName("Admin");

        Calendar cal = Calendar.getInstance();
        cal.set(2021, Calendar.JANUARY, 1);
        Admin.currentAdmin.setBirthDate(cal);
    }


    /**
     * Resets the {@code currentAdmin} login credentials to defaults.
     * Default {@code Admin} login credentials are:
     * <blockquote><pre>
     *   Username -> admin
     *   Password -> admin
     * </pre></blockquote>
     *
     * @author Adham Mohamed Aly
     **/
    public static void setDefaultLoginCredentials() {
        Admin.currentAdmin.setUserName(AdminAuthenticator.defaultAdminUsername);
        Admin.currentAdmin.setPassword(AdminAuthenticator.defaultAdminPassword);
    }

}

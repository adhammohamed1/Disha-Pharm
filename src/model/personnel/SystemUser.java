package model.personnel;

import java.util.Calendar;

public class SystemUser {

    public static final String CLASS_PHARMACIST = "class model.personnel.Pharmacist";
    public static final String CLASS_DELIVERER = "class model.personnel.Deliverer";
    ;
    public static final String CLASS_ADMIN = "class model.personnel.Admin";

    public boolean isEncrypted;

    private String userName;
    private String password;

    private String name;
    private Calendar birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

}

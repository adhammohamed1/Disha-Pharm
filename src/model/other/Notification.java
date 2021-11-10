package model.other;

public class Notification {

    public static final String EXPIRY_NOTIFICATION = "EXPIRY NOTIF";
    public static final String ADMIN_CREDENTIALS_NOTIFICATION = "CREDENTIALS NOTIF";
    public static final String STOCK_NOTIFICATION = "STOCK NOTIF";


    private String notificationType;

    @Override
    public String toString() {
        //TODO: Add notification formatter methods
        return notificationType + ": ";
    }
}

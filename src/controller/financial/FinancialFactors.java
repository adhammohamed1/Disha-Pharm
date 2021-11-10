package controller.financial;

/**
 * This class contains all enumerated values related to financial operations and settings.
 * @author Adham Mohamed Aly
 */
public class FinancialFactors {

    public static final int USD = 0, EGP = 1, EUR = 2, STERLING = 3;
    public static final String US_DOLLAR = "$", EGYPTIAN_POUND = "EGP ", EURO = "€", STERLING_POUND = "£";

    public static String PREFERRED_CURRENCY = Character.toString('$');
    public static double DELIVERY_FEE = 4.99;
    public static double TAX_FACTOR = 0.14;

}

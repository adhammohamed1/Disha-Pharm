package system.general;

public class DataEntryChecker {


    public static String fixIntegerInput(String input) {
        char[] arr = input.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char c : arr) {
            if (Character.isDigit(c)) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static String fixDoubleInput(String input) {
        char[] arr = input.toCharArray();
        boolean decimalPointAdded = false;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                res.append(c);
            } else if (c == '.' && !decimalPointAdded) {
                if (i > 0) {
                    res.append(c);
                } else {
                    res.append("0.");
                }
                decimalPointAdded = true;
            }
        }
        return res.toString();
    }


}
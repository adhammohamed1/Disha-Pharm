package controller.searching;

public class Comparer<T> {


    public T max(T a, T b) {
        if (a instanceof String) {
            return ((String) a).compareTo((String) b) > 0 ? a : b;
        } else if (a instanceof Integer) {
            return (Integer) a > (Integer) b ? a : b;
        } else if (a instanceof Double) {
            return (Double) a > (Double) b ? a : b;
        } else if (a instanceof Float) {
            return (Float) a > (Float) b ? a : b;
        } else if (a instanceof Character) {
            return (Character) a > (Character) b ? a : b;
        } else if (a instanceof Byte) {
            return (Byte) a > (Byte) b ? a : b;
        } else if (a instanceof Long) {
            return (Long) a > (Long) b ? a : b;
        }
        return null;
    }

    public T min(T a, T b) {
        if (a instanceof String) {
            return ((String) a).compareTo((String) b) < 0 ? a : b;
        } else if (a instanceof Integer) {
            return (Integer) a < (Integer) b ? a : b;
        } else if (a instanceof Double) {
            return (Double) a < (Double) b ? a : b;
        } else if (a instanceof Float) {
            return (Float) a < (Float) b ? a : b;
        } else if (a instanceof Character) {
            return (Character) a < (Character) b ? a : b;
        } else if (a instanceof Byte) {
            return (Byte) a < (Byte) b ? a : b;
        } else if (a instanceof Long) {
            return (Long) a < (Long) b ? a : b;
        }
        return null;
    }

    public int compare(T a, T b) {
        if (a instanceof String) {
            return ((String) a).compareTo((String) b);
        } else if (a instanceof Integer) {
            return Integer.compare((Integer) a, (Integer) b);
        } else if (a instanceof Double) {
            return Double.compare((Double) a, (Double) b);
        } else if (a instanceof Float) {
            return Float.compare((Float) a, (Float) b);
        } else if (a instanceof Character) {
            return Character.compare((Character) a, (Character) b);
        } else if (a instanceof Byte) {
            return Byte.compare((Byte) a, (Byte) b);
        } else if (a instanceof Long) {
            return Long.compare((Long) a, (Long) b);
        }
        return 0;
    }
}

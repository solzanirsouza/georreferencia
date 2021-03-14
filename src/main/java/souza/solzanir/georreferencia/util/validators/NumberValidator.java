package souza.solzanir.georreferencia.util.validators;

public class NumberValidator {

    public static boolean nonValid(Object value) {
        return !isValid(value, false);
    }

    public static boolean isValid(Object value) {
        return isValid(value, false);
    }

    public static boolean nonValid(Object value, boolean greaterThanZero) {
        return !isValid(value, greaterThanZero);
    }

    public static boolean isValid(Object value, boolean greaterThanZero) {
        if (value instanceof Integer) {
            return greaterThanZero ? 0 < (int) value : 0 <= (int) value;

        } else if (value instanceof Long) {
            return greaterThanZero ? 0 < (long) value : 0 <= (long) value;

        } else {
            throw new IllegalArgumentException("The value is not an accepted number");
        }
    }
}

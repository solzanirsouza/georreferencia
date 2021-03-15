package souza.solzanir.georreferencia.util.validators;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

public class NumberValidator {

    public static boolean nonValid(Object value) {
        return !isValid(value, false, false);
    }

    public static boolean isValid(Object value) {
        return isValid(value, false, false);
    }

    public static boolean nonValid(Object value, boolean greaterThanZero, boolean acceptAllValues) {
        return !isValid(value, greaterThanZero, acceptAllValues);
    }

    public static boolean isValid(Object value, boolean greaterThanZero, boolean acceptAllValues) {
        if (isNull(value)) {
            return false;

        } else if (value instanceof Integer) {
            return acceptAllValues || (greaterThanZero ? (int) value > 0 : (int) value >= 0);

        } else if (value instanceof Long) {
            return acceptAllValues || (greaterThanZero ? (long) value > 0 : (long) value >= 0);

        } else if (value instanceof BigDecimal) {
            return acceptAllValues || (greaterThanZero ? ((BigDecimal) value).signum() > 0 : ((BigDecimal) value).signum() >= 0);

        } else {
            throw new IllegalArgumentException("The value is not an accepted number");
        }
    }
}

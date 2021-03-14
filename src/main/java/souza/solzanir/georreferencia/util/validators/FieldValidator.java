package souza.solzanir.georreferencia.util.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@Component
public class FieldValidator<T> {

    @Autowired
    private Validator validator;

    public FieldValidator() {
    }

    public FieldValidator(Validator validator) {
        this.validator = validator;
    }

    public void validate(T o) {
        Set<ConstraintViolation<T>> violations = validator.validate(o);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<>(violations));
        }
    }
}

package souza.solzanir.georreferencia.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.apache.logging.log4j.util.Strings.isBlank;

@ControllerAdvice(annotations = RestController.class)
class ExceptionComponent extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<List<String>> exceptionHandler(ConstraintViolationException ex) {
        List<String> messages = ex.getConstraintViolations().stream()
                .map(violation -> violation.getMessage())
                .collect(toList());

        return ResponseEntity
                .badRequest()
                .body(messages);
    }

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(isBlank(ex.getMessage()) ? ex.getMessage() : "Erro não tratado");
    }
}

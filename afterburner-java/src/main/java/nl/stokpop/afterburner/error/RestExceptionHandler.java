package nl.stokpop.afterburner.error;

import nl.stokpop.afterburner.AfterburnerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleGeneralException(final Exception ex, final WebRequest request) {
        
        String devMessage = String.format("%s: %s (cause: %s)", ex.getClass().getSimpleName(), ex.getMessage(), ex.getCause());
        String userMessage = String.format("The afterburner failed for the following reason: %s", ex.getMessage());

        HttpStatus returnCode = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorMessage errorMessage = new ErrorMessage(devMessage, userMessage, returnCode.value());

        if (ex instanceof AfterburnerException) {
            log.error(devMessage);
        }
        else {
            log.error(devMessage, ex);
        }
        
        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), returnCode, request);
    }

}

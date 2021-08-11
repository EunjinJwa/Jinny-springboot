package springboot.sample.exception;

import org.springframework.http.HttpStatus;

public abstract class InternalException extends RuntimeException {

    public abstract HttpStatus getHttpStatus();

    public abstract CustomErrorCode getErrorCode();

    public InternalException(String message, Throwable cause) {
        super(message, cause);
    }

}

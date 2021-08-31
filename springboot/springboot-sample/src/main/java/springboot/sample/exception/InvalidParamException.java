package springboot.sample.exception;

import org.springframework.http.HttpStatus;

public class InvalidParamException extends InternalException {


    private static final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    private static final CustomErrorCode errorCode = CustomErrorCode.INVALID_REQUEST;


    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public CustomErrorCode getErrorCode() {
        return errorCode;
    }

    public InvalidParamException(String kassy) {
        this(kassy, null);
    }

    public InvalidParamException(String message, Throwable cause) {
        super(message, cause);
    }
}

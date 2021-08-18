package springboot.sample.exception;

import org.springframework.http.HttpStatus;

public class AuthException extends InternalException {

    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private static final CustomErrorCode errorCode = CustomErrorCode.NOT_AUTH;

    public AuthException(String userId, Throwable cause) {
        super(userId, cause);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public CustomErrorCode getErrorCode() {
        return errorCode;
    }
}

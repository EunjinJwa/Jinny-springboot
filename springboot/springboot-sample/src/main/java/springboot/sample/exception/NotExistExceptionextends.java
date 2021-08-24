package springboot.sample.exception;

import org.springframework.http.HttpStatus;

public class NotExistExceptionextends extends InternalException {

    private static final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    private static final CustomErrorCode errorCode = CustomErrorCode.NOT_EXIST;


    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public CustomErrorCode getErrorCode() {
        return errorCode;
    }

    public NotExistExceptionextends(String kassy) {
        this(kassy, null);
    }

    public NotExistExceptionextends(String user, Throwable cause) {
        super(user + " is not exist. ", cause);
    }
}

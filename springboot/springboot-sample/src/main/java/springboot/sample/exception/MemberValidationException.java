package springboot.sample.exception;

import org.springframework.http.HttpStatus;

public class MemberValidationException extends InternalException {

    private static final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    private static final CustomErrorCode errorCode = CustomErrorCode.ALREAY_EXIST;


    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public CustomErrorCode getErrorCode() {
        return errorCode;
    }

    public MemberValidationException(String kassy) {
        this(kassy, null);
    }

    public MemberValidationException(String user, Throwable cause) {
        super(user + " is already used. ", cause);
    }
}

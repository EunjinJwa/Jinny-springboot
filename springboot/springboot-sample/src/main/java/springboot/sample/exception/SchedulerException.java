package springboot.sample.exception;

import org.springframework.http.HttpStatus;

public class SchedulerException extends InternalException {

    private static final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    private CustomErrorCode errorCode;



    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public CustomErrorCode getErrorCode() {
        return errorCode;
    }


    public SchedulerException(String message, CustomErrorCode errorCode) {
        this(message, (Throwable) null);
        this.errorCode = errorCode;
    }


    public SchedulerException(String message, Throwable cause) {
        super(message, cause);
    }



}

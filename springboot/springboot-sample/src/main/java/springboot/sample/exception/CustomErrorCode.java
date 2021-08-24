package springboot.sample.exception;

public enum CustomErrorCode {

    SAMPLE_ERROR,
    INTERNAL_ERROR,
    INVALID_REQUEST,
    ALREAY_EXIST,
    NOT_AUTH,
    NOT_EXIST,

    // scheduler error
    NOT_RUNNING,
    ALREADY_RUNNING;


}

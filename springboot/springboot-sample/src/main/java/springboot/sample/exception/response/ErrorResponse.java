package springboot.sample.exception.response;

import springboot.sample.exception.CustomErrorCode;

public class ErrorResponse {

    private CustomErrorCode code;

    private String message;

    private String description;

    public ErrorResponse(CustomErrorCode code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public CustomErrorCode getCode() {
        return code;
    }

    public void setCode(CustomErrorCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

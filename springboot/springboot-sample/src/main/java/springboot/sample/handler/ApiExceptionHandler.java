package springboot.sample.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import springboot.sample.exception.CustomErrorCode;
import springboot.sample.exception.InternalException;
import springboot.sample.exception.response.ErrorResponse;
import springboot.sample.exception.SampleException;
import springboot.sample.exception.InternalErrorException;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SampleException.class)
    public ResponseEntity<ErrorResponse> sampleErrorHandler(SampleException e) {
        ErrorResponse response = new ErrorResponse(
                CustomErrorCode.SAMPLE_ERROR,
                "Error message..",
                "Sample Exception Test"
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({InternalErrorException.class})
    public ResponseEntity<ErrorResponse> internalErrorExceptionHandler(InternalErrorException e) {
        ErrorResponse response = new ErrorResponse(
                CustomErrorCode.INTERNAL_ERROR,
                e.getMessage(),
                "Internal Exception Test"
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({InternalException.class})
    public ResponseEntity<ErrorResponse> internalExceptionHandler(InternalException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse(
                ex.getErrorCode(),
                ex.getMessage(),
                "Description ... "
        );
        return new ResponseEntity<>(response, ex.getHttpStatus());
    }











}

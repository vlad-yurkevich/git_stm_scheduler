package by.softclub.stm_scheduler.config;

import by.softclub.stm_scheduler.domain.dto.ErrorDto;
import by.softclub.stm_scheduler.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice //Аннотация позволяет отслеживать всё, что происходит в контроллерах
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //String s = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResponseEntity<>(ex.getMessage(), headers, status);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest webRequest) {

        return respUnify(ex, webRequest, NOT_FOUND);

    }

    private ResponseEntity<Object> respUnify(RuntimeException ex, WebRequest webRequest, HttpStatus status){
        ErrorDto dto = new ErrorDto();
        dto.setError_text(ex.getMessage());
        dto.setError_code("RELATION_DATA_NOT_FOUND");

        return handleExceptionInternal(ex,
                dto,
                new HttpHeaders(), status, webRequest);
    }
}

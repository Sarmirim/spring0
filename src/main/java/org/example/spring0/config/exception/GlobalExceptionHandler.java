
package org.example.spring0.config.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HumanResponse> handleAddHumanException(Exception e) {
        log.error("e: ", e);
        HumanResponse humanResponse = new HumanResponse(e.getMessage(), e.toString());

        return new ResponseEntity<>(humanResponse, HttpStatus.BAD_GATEWAY);
    }
}

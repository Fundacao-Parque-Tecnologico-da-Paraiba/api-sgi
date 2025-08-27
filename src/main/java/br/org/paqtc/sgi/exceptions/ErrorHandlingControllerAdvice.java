package br.org.paqtc.sgi.exceptions;

import br.org.paqtc.sgi.dto.ExceptionDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {
    private ExceptionDto construtorPadraoDeErros(String message) {
        return ExceptionDto.builder()
                .timestamp(LocalDateTime.now())
                .errors(new ArrayList<>())
                .message(message)
                .build();
    }

    @ExceptionHandler(GeneralException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionDto onCommerceException(GeneralException generalException) {
        return construtorPadraoDeErros(
                generalException.getMessage()
        );
    }

    @ExceptionHandler(ItemCompradoNaoExisteException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionDto onCommerceException(ItemCompradoNaoExisteException generalException) {
        return construtorPadraoDeErros(
                generalException.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionDto onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ExceptionDto customErrorType = construtorPadraoDeErros(
                "Erros de validacao encontrados"
        );
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            customErrorType.getErrors().add(fieldError.getDefaultMessage());
        }
        return customErrorType;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionDto onConstraintViolation(ConstraintViolationException e) {
        ExceptionDto customErrorType = construtorPadraoDeErros(
                "Erros de validacao encontrados"
        );
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            customErrorType.getErrors().add(violation.getMessage());
        }
        return customErrorType;
    }
}

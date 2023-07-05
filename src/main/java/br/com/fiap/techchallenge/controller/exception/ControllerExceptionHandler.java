package br.com.fiap.techchallenge.controller.exception;

import br.com.fiap.techchallenge.service.exception.ControllerNotFoundException;
import br.com.fiap.techchallenge.service.exception.DatabaseException;
import br.com.fiap.techchallenge.service.exception.DefaultError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    private final DefaultError error = new DefaultError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<DefaultError> entityNotFound(ControllerNotFoundException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        error
                .setTimestamp(Instant.now())
                .setError("Entidade não encontrada.")
                .setMessage(exception.getMessage())
                .setPath(request.getRequestURI())
                .setStatus(status.value());
        return ResponseEntity.status(status).body(this.error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<DefaultError> database(DatabaseException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        error
                .setTimestamp(Instant.now())
                .setError("Erro na Base de Dados.")
                .setMessage(exception.getMessage())
                .setPath(request.getRequestURI())
                .setStatus(status.value());
        return ResponseEntity.status(status).body(this.error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidacaoForm> database(MethodArgumentNotValidException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidacaoForm validacaoForm = new ValidacaoForm();
        validacaoForm
                .setTimestamp(Instant.now())
                .setError("Erro de validação.")
                .setMessage(exception.getMessage())
                .setPath(request.getRequestURI())
                .setStatus(status.value());
        for (FieldError field: exception.getBindingResult().getFieldErrors()) {
            validacaoForm.addMensagens(field.getField(), field.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(validacaoForm);
    }
}

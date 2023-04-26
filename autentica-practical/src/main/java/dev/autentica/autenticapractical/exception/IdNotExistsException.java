package dev.autentica.autenticapractical.exception;

public class IdNotExistsException extends RuntimeException {

    public IdNotExistsException(Integer id) {
        super("Application with id " + id + " could not be found");
    }

    public IdNotExistsException(String message) {
        super(message);
    }
}

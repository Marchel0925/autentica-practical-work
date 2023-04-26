package dev.autentica.autenticapractical.exception;

public class InvalidStatusException extends RuntimeException {

    public InvalidStatusException() {
        super("Status has to be either \"accept\" or \"reject\"");
    }
}

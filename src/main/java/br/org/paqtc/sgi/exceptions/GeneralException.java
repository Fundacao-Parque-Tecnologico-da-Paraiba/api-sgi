package br.org.paqtc.sgi.exceptions;

public class GeneralException extends RuntimeException {
    public GeneralException(String message) {
        super(message);
    }
    public GeneralException(String message, Throwable cause) {
        super(message, cause);
    }
    public GeneralException() {
        super("Erro inesperado na API!");
    }
}

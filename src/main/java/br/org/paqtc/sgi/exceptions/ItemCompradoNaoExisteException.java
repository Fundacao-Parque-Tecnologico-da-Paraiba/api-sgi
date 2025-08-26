package br.org.paqtc.sgi.exceptions;

public class ItemCompradoNaoExisteException extends GeneralException {
    public ItemCompradoNaoExisteException(String message) {
        super(message);
    }
    public ItemCompradoNaoExisteException(String message, Throwable cause) {
        super(message, cause);
    }
    public ItemCompradoNaoExisteException() {
        super("O item comprado não foi encontrado!");
    }
}

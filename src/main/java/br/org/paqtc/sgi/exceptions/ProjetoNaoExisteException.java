package br.org.paqtc.sgi.exceptions;

public class ProjetoNaoExisteException extends GeneralException {
    public ProjetoNaoExisteException(String mensagemErro) {
        super(mensagemErro);
    }
    public ProjetoNaoExisteException(String mensagemErro, Throwable cause) {
        super(mensagemErro, cause);
    }
    public ProjetoNaoExisteException() {
        super("Projeto não encontrado!");
    }
}

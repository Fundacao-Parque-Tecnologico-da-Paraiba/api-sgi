package br.org.paqtc.sgi.entities.enums;

public enum SituacaoProjeto {
    FINALIZADO("Finalizado"),
    VIGENTE("Vigente");

    private String descricao;

    SituacaoProjeto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SituacaoProjeto getByDescricao(String descricao){
        return descricao.equals("Finalizado") ? FINALIZADO : VIGENTE;
    }
}

package br.org.paqtc.sgi.entities.solicitacoes;

import br.org.paqtc.sgi.entities.ids.SolicitacaoId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tusolicitacao")
@AllArgsConstructor
@NoArgsConstructor
public class Solicitacoes implements Serializable {
    @EmbeddedId
    private SolicitacaoId id;

    @Column(name = "NanoSolicitacao")
    private Integer ano;

    @Column(name = "NmesSolicitacao")
    private Integer mes;

    @Column(name = "NdiaSolicitacao")
    private Integer dia;

    @Column(name = "SetorResponsavel", length = 100)
    private String setorResponsavel;

    @Temporal(TemporalType.DATE)
    @Column(name = "DtSolicitacao")
    private Date dataSolicitacao;

    @Column(name = "datasetores", length = 10)
    private String datasetores;

    @Column(name = "tipoSolicitacao", length = 50)
    private String tipoSolicitacao;

    @Column(name = "autorizacoordtiposoli", length = 5)
    private String autorizacaoCoordTipoSoli;

    @Lob
    @Column(name = "DsSolicitacao")
    private String descricaoSolicitacao;

    @Lob
    @Column(name = "DsSolicitacaoSetor")
    private String descricaoSolicitacaoSetor;

    @Lob
    @Column(name = "InfSolicitacao")
    private String informacoesSolicitacao;

    @Column(name = "NuSolicitacao")
    private Integer numeroSolicitacao;

    @Column(name = "Situacao")
    private String situacao;

    @Column(name = "autorizacao")
    private String autorizacao;

    @Column(name = "autorizacaone", length = 5)
    private String autorizacaoNe;

    @Column(name = "NuOrdemPagamento")
    private Integer ordemPagamento;

    @Column(name = "NuOrdemRecebimento")
    private Integer ordemRecebimento;

    @Column(name = "NmCoordenador")
    private String nomeCoordenador;

    @Column(name = "NmProjeto")
    private String nomeProjeto;

    @Column(name = "NumConta", length = 12)
    private String numConta;

    @Column(name = "NuContaPag", length = 11)
    private String contaPagamento;

    @Column(name = "MaterialPermanente", length = 5)
    private String materialPermanente;

    @Column(name = "MaterialPermanenteStatus", length = 20)
    private String materialPermanenteStatus;

    @Column(name = "CompraStatus")
    private String compraStatus;

    @Column(name = "CompraCartao", length = 5)
    private String compraCartao;

    @Column(name = "TipoProcesso", length = 20)
    private String tipoProcesso;

    @Column(name = "NuTipoProcesso", length = 20)
    private String numeroTipoProcesso;

    @Column(name = "NuDispensa", length = 20)
    private String numeroDispensa;

    @Column(name = "NuInexigibilidade", length = 20)
    private String numeroInexigibilidade;

    @Column(name = "TipoProcessoDesc", length = 1000)
    private String tipoProcessoDescricao;

    @Column(name = "Obs_cont_NF", length = 1000)
    private String observacaoNotaFiscal;

    @Column(name = "Obs_cont_valor", length = 1000)
    private String observacaoValor;

    @Column(name = "Obs_cont_For", length = 1000)
    private String observacaoFornecedor;

    @Column(name = "Obs_cont_Obj", length = 1000)
    private String observacaoObjeto;

    @Column(name = "Obs_cont_cartao", length = 1000)
    private String observacaoCartao;

    @Column(name = "NuCelular", length = 15)
    private String numeroCelular;

    @Column(name = "IndicaForn1", length = 1000)
    private String fornecedor1;

    @Column(name = "IndicaForn2", length = 1000)
    private String fornecedor2;

    @Column(name = "IndicaForn3", length = 1000)
    private String fornecedor3;

    @Column(name = "LocalEntrega", length = 100)
    private String localEntrega;

    @Column(name = "ResponsavelEntrega", length = 100)
    private String responsavelEntrega;

    @Column(name = "ChaveSolicita", length = 50)
    private String chaveSolicitacao;

    @Lob
    @Column(name = "HistoricoSolicita")
    private String historicoSolicitacao;

    @Column(name = "aceitesolicatacao", length = 20)
    private String aceiteSolicitacao;

    @Column(name = "RubricaDespesa", length = 50)
    private String rubricaDespesa;

    @Column(name = "ContaSoli", length = 11)
    private String contaSolicitacao;

    @Column(name = "RecursoSoli", length = 50)
    private String recursoSolicitacao;

    @Column(name = "RubricaSoli", length = 500)
    private String rubricaSolicitacao;

    @Column(name = "ItemSoli", length = 500)
    private String itemSolicitacao;

    @Column(name = "ValorSoli", precision = 10, scale = 2)
    private BigDecimal valorSolicitacao;

    @Column(name = "comprador_compras", length = 100)
    private String comprador;

    @Column(name = "programador_pagamento", length = 100)
    private String programadorPagamento;

    @Column(name = "classe_compras", length = 100)
    private String classeCompras;

    @Column(name = "data_comprador", length = 10)
    private String dataComprador;
}

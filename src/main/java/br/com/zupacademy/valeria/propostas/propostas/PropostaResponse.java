package br.com.zupacademy.valeria.propostas.propostas;

import br.com.zupacademy.valeria.propostas.propostas.atrela.RetornoCartaoGerado;
import br.com.zupacademy.valeria.propostas.propostas.consulta.RetornoSolicitacaoProposta;

import java.math.BigDecimal;

public class PropostaResponse {

    private String documento;
    private String email;
    private String nome;
    private String endereco;
    private BigDecimal salario;
    private String resultadoSolicitacao;
    private String idCartao;
    private Long limite;

    public PropostaResponse(PropostaModel propostaModel, RetornoSolicitacaoProposta retornoSolicitacaoProposta, RetornoCartaoGerado cartaoGerado) {
        this.documento = propostaModel.getDocumento();
        this.email = propostaModel.getEmail();
        this.nome = propostaModel.getNome();
        this.endereco = propostaModel.getEndereco();
        this.salario = propostaModel.getSalario();
        this.resultadoSolicitacao = retornoSolicitacaoProposta.getResultadoSolicitacao();
        this.idCartao = cartaoGerado.getId();
        this.limite = cartaoGerado.getLimite();

    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public Long getLimite() {
        return limite;
    }
}

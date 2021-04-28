package br.com.zupacademy.valeria.propostas.propostas;

import java.math.BigDecimal;

public class PropostaResponse {

    private String documento;
    private String email;
    private String nome;
    private String endereco;
    private BigDecimal salario;

    public PropostaResponse(PropostaModel propostaModel) {
        this.documento = propostaModel.getDocumento();
        this.email = propostaModel.getEmail();
        this.nome = propostaModel.getNome();
        this.endereco = propostaModel.getEndereco();
        this.salario = propostaModel.getSalario();
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
}

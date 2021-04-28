package br.com.zupacademy.valeria.propostas.propostas;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class PropostaModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
    private String documento;
    private String email;
    private String nome;
    private String endereco;
    private BigDecimal salario;

    public PropostaModel() {
    }

    public PropostaModel(TipoPessoa tipoPessoa, String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.tipoPessoa = tipoPessoa;
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }
    public Long getId() {
        return id;
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

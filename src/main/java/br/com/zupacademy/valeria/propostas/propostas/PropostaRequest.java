package br.com.zupacademy.valeria.propostas.propostas;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

import static br.com.zupacademy.valeria.propostas.propostas.TipoPessoa.PF;
import static br.com.zupacademy.valeria.propostas.propostas.TipoPessoa.PJ;
@GroupSequenceProvider(value = DefineTipoPessoa.class)
public class PropostaRequest {


    @CPF(groups = PessoaFisica.class)
    @CNPJ(groups = PessoaJuridica.class)
    private String documento;

    @NotNull
    private TipoPessoa tipoPessoa;
    @NotBlank @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotNull @Positive
    private BigDecimal salario;

    public PropostaRequest(@NotNull TipoPessoa tipoPessoa, String documento, @NotBlank @Email String email, @NotBlank String nome,
                           @NotBlank String endereco, @NotNull @Positive BigDecimal salario) {
        this.tipoPessoa = tipoPessoa;
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public PropostaModel toModel() {
        return new PropostaModel(this.tipoPessoa, this.documento, this.email, this.nome, this.endereco, this.salario);
    }

    public String getDocumento() {
        return documento;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
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

    public boolean isPF(){
        return PF.equals(tipoPessoa);
    }

    public boolean isPJ(){
        return PJ.equals(tipoPessoa);
    }
}

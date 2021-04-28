package br.com.zupacademy.valeria.propostas.propostas;

public enum TipoPessoa {

    PJ("Pessoa Física"),
    PF("Pessoa Jurídica");

    private final String nome;

    TipoPessoa(String nome){
        this.nome = nome;
    }

}

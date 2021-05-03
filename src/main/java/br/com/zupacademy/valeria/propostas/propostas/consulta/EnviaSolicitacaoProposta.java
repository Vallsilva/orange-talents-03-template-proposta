package br.com.zupacademy.valeria.propostas.propostas.consulta;

import br.com.zupacademy.valeria.propostas.propostas.PropostaModel;

public class EnviaSolicitacaoProposta {

    private String documento;
    private String nome;
    private String idProduto;

    public EnviaSolicitacaoProposta(PropostaModel propostaModel) {
        this.documento = propostaModel.getDocumento();
        this.nome = propostaModel.getNome();
        this.idProduto = propostaModel.getId().toString();
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProduto() {
        return idProduto;
    }
}

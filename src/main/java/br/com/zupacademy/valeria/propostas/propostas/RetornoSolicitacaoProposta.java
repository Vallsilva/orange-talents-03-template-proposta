package br.com.zupacademy.valeria.propostas.propostas;

public class RetornoSolicitacaoProposta {

    private String documento;
    private String nome;
    private String resultadoSolicitacao;
    private String idProposta;

    public RetornoSolicitacaoProposta(String documento, String nome, String resultadoSolicitacao, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public String getIdProposta() {
        return idProposta;
    }
}

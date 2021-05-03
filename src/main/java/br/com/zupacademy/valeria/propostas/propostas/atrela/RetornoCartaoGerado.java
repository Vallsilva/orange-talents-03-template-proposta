package br.com.zupacademy.valeria.propostas.propostas.atrela;

public class RetornoCartaoGerado {

    private String id;
    private String emitidoEm;
    private String titular;
    private Long limite;
    private String idProposta;

    public RetornoCartaoGerado(String id, String emitidoEm, String titular, Long limite, String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.limite = limite;
        this.idProposta = idProposta;
    }

    public String getId() {
        return id;
    }

    public String getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }


    public Long getLimite() {
        return limite;
    }


    public String getIdProposta() {
        return idProposta;
    }
}

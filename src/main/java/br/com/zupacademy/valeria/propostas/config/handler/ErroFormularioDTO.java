package br.com.zupacademy.valeria.propostas.config.handler;

public class ErroFormularioDTO {

    private String campo;
    private String erro;

    public ErroFormularioDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}

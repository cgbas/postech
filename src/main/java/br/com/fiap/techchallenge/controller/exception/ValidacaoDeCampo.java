package br.com.fiap.techchallenge.controller.exception;

public class ValidacaoDeCampo {
    private String campo;
    private String mensagem;

    public ValidacaoDeCampo() {
    }

    public ValidacaoDeCampo(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public ValidacaoDeCampo setCampo(String campo) {
        this.campo = campo;
        return this;
    }

    public String getMensagem() {
        return mensagem;
    }

    public ValidacaoDeCampo setMensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }
}

package br.com.fiap.techchallenge.controller.exception;

import br.com.fiap.techchallenge.service.exception.DefaultError;

import java.util.ArrayList;
import java.util.List;

public class ValidacaoForm extends DefaultError {

    private final List<ValidacaoDeCampo> mensagens = new ArrayList<>();

    public List<ValidacaoDeCampo> getMensagens() {
        return mensagens;
    }

    public void addMensagens(String campo, String mensagem) {
        mensagens.add(new ValidacaoDeCampo(campo, mensagem));
    }
}

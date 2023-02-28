package br.com.projetofaculdade.gestao.exceptions;

public class IdNaoEncontradoException extends IllegalArgumentException {

    public IdNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}

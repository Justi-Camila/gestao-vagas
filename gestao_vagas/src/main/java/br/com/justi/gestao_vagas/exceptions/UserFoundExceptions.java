package br.com.justi.gestao_vagas.exceptions;

public class UserFoundExceptions extends RuntimeException{
    public UserFoundExceptions() {
        super("User exists");
    }

}

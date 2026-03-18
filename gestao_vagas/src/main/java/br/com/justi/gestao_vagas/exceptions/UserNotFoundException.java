package br.com.justi.gestao_vagas.exceptions;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User not found");
    }

}

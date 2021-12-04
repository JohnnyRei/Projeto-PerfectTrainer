package com.trabalhoFinal.perfectTrainer.service.expections;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException() {}

    public UsuarioNotFoundException(String mensagem) {
        super(mensagem);
    }
}

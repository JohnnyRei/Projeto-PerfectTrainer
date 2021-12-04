package com.trabalhoFinal.perfectTrainer.service.expections;

public class TreinoCasaNotFoundException extends RuntimeException{

    public TreinoCasaNotFoundException() {}

    public TreinoCasaNotFoundException(String mensagem) {
        super(mensagem);
    }
}

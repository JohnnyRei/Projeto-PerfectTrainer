package com.trabalhoFinal.perfectTrainer.service.expections;

public class TreinoAcademiaNotFoundException extends RuntimeException{

    public TreinoAcademiaNotFoundException() {}

    public TreinoAcademiaNotFoundException(String mensagem) {
        super(mensagem);
    }
}

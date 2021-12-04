package com.trabalhoFinal.perfectTrainer.service.expections;

public class PortifolioNotFoundException extends RuntimeException{

    public PortifolioNotFoundException() {}

    public PortifolioNotFoundException(String mensagem) {
        super(mensagem);
    }
}

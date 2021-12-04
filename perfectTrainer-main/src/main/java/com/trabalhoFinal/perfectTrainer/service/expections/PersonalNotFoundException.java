package com.trabalhoFinal.perfectTrainer.service.expections;

public class PersonalNotFoundException extends RuntimeException{

    public PersonalNotFoundException() {

    }

    public PersonalNotFoundException(String mensagem) {
        super(mensagem);
    }
}

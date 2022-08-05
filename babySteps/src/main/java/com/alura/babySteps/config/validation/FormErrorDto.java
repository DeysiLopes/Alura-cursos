package com.alura.babySteps.config.validation;

public class FormErrorDto {
    private final String campo;
    private final String erroMensagem;

    public FormErrorDto(String campo, String erroMensagem) {
        this.campo = campo;
        this.erroMensagem = erroMensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getErroMensagem() {
        return erroMensagem;
    }
}

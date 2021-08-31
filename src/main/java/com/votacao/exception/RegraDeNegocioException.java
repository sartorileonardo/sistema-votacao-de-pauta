package com.votacao.exception;

import org.springframework.http.HttpStatus;

public class RegraDeNegocioException extends RuntimeException{

    private final HttpStatus httpStatus;

    public RegraDeNegocioException(TipoMensagemRegraDeNegocioException tipoRegraDeNegocioException, HttpStatus httpStatus) {
        super(tipoRegraDeNegocioException.getMensagemDeErroDeNegocio(), null, true, false);
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return this.httpStatus.value();
    }
}

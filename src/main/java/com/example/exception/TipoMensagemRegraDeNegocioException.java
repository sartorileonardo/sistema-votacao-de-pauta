package com.example.exception;

public enum TipoMensagemRegraDeNegocioException {
    SESSAO_FECHADA{
        @Override
        String getMensagemDeErroDeNegocio() {
            return "A sessão já foi encerrada!";
        }
    },
    SESSAO_NAO_ENCONTRADA{
        @Override
        String getMensagemDeErroDeNegocio() {
            return "A sessão não foi encontrada!";
        }
    },
    SESSAO_JA_EXISTE{
        @Override
        String getMensagemDeErroDeNegocio() {
            return "Já existe sessão cadastrada com este identificador!";
        }
    },
    PAUTA_NAO_ENCONTRADA{
        @Override
        String getMensagemDeErroDeNegocio() {
            return "A pauta não foi encontrada!";
        }
    },
    VOTO_JA_REGISTRADO{
        @Override
        String getMensagemDeErroDeNegocio() {
            return "Você já registrou seu noto, só é permitido um voto por pessoa!";
        }
    };

    abstract String getMensagemDeErroDeNegocio();
}

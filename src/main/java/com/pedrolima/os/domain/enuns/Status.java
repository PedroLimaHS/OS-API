package com.pedrolima.os.domain.enuns;

public enum Status {

    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    FECHADO(2, "FECHADO");

    private Integer cod;
    private String descricao;

    Status(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Status toEnum(Integer cod) throws IllegalAccessException {
        if (cod == null) {
            return null;
        }
        for (Status x : Status.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalAccessException("Status inválido!" + cod);
    }
}


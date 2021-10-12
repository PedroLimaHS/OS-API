package com.pedrolima.os.domain.enuns;

public enum Prioridade {

    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private Integer cod;
    private String descricao;

    Prioridade(Integer cod, String descricao) {
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

    public static Prioridade toEnum(Integer cod) throws IllegalAccessException {
        if (cod == null) {
            return null;
        }
        for (Prioridade x : Prioridade.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalAccessException("Prioridade inválida!" + cod);
    }
}

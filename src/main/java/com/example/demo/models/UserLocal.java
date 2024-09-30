package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLocal {
    private String bairro;
    private String localidade;
    private String estado;
    private String regiao;

    @Override
    public String toString() {
        return "{" +
                "\"bairro\":" + this.bairro + "," +
                "\"localidade\":\"" + this.localidade + "\"," +
                "\"estado\":\"" + this.estado + "\"," +
                "\"regiao\":\"" + this.regiao + "\"" +
                "}";
    }
}

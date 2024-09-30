package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDataWiremock {
    private String name;
    private String job;
    private String RG;
    private String CEP;
    private String birth_date;
}

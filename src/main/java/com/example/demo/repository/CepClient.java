package com.example.demo.repository;

import com.example.demo.models.UserDataWiremock;
import com.example.demo.models.UserLocal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cep-client", url = "http://viacep.com.br")
public interface CepClient {
    @GetMapping("/ws/{cep}/json")
    UserLocal getInfo(@PathVariable("cep") String cep);
}

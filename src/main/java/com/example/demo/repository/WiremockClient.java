package com.example.demo.repository;

import com.example.demo.models.UserDataWiremock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "wiremock-client", url = "http://localhost:8081")
public interface WiremockClient {
    @GetMapping("/info")
    UserDataWiremock getInfo(@RequestParam("cpf") String cpf);
}

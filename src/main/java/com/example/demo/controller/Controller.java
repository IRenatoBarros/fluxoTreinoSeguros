package com.example.demo.controller;

import com.example.demo.models.User;
import com.example.demo.models.UserDataWiremock;
import com.example.demo.models.UserLocal;
import com.example.demo.repository.CepClient;
import com.example.demo.service.UserService;
import com.example.demo.repository.WiremockClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {


    private final UserService userService;
    private final WiremockClient wiremockClient;
    private final CepClient cepClient;


    @PostMapping("/validarcpf")
    public ResponseEntity<String> validarCpf(@RequestBody User user){
        if(userService.cpfValid(user.getCpf())){
            user.setValid(true);
            if(userService.findByCpf(user.getCpf()).isEmpty()){
                userService.save(user);
                return ResponseEntity.status(201).body("cpf valido e adicionado a base");
            }else {
                return ResponseEntity.status(400).body("o cliente ja tem o cpf na base");
            }

        }else{
            return ResponseEntity.status(400).body("cpf invalido");
        }
    }

    @GetMapping("/dadosClientes")
    public ResponseEntity<String> dadosCliente(@RequestParam String cpf){
        if(userService.cpfStored(cpf)){
            String cpfMockito = cpf.substring(1);
            UserDataWiremock jsonWiremock = wiremockClient.getInfo(cpfMockito);
            UserLocal userLocal = cepClient.getInfo(jsonWiremock.getCEP());
            String userLocalString = userLocal.toString();
            return ResponseEntity.status(200).body(userLocalString);
        }else{
            return ResponseEntity.status(404).body("O usuario nao foi encontrado na base, e o cpf nao foi validado");
        }
    }

}

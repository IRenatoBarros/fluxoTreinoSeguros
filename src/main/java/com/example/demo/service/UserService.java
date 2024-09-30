package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean cpfValid(String cpf){
        cpf = cpf.replaceAll("\\D", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int firstCheckDigit = 11 - (sum % 11);
        if (firstCheckDigit >= 10) {
            firstCheckDigit = 0;
        }

        // Verifica o primeiro dígito verificador
        if (firstCheckDigit != (cpf.charAt(9) - '0')) {
            return false;
        }

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int secondCheckDigit = 11 - (sum % 11);
        if (secondCheckDigit >= 10) {
            secondCheckDigit = 0;
        }

        // Verifica o segundo dígito verificador
        return secondCheckDigit == (cpf.charAt(10) - '0');

    }

    public Optional<User> findByCpf(String cpf){
        return userRepository.findByCpf(cpf);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public boolean cpfStored(String cpf){
        if(userRepository.findByCpf(cpf).isPresent()){
            return true;
        }
        return false;
    }

}

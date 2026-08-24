package com.eltonfernandesdev.library_api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class CnpjValidator implements ConstraintValidator<Cnpj, String> {


    @Override
    public boolean isValid(String cnpj, ConstraintValidatorContext context) {


        if (cnpj == null || cnpj.isBlank()) {
            return true;
        }

        if (cnpj.length() != 14){
            return false;
        }

        List<Integer> numeros = new ArrayList<>();

        for (char c : cnpj.toCharArray()) {

            int numero = Character.getNumericValue(c);
            numeros.add((numero));
        }

        int primeiroDigitoVerificador;
        int totalPrimeiroDigito = ((numeros.get(0) * 5)
                + (numeros.get(1) * 4)
                + (numeros.get(2) * 3)
                + (numeros.get(3) * 2)
                + (numeros.get(4) * 9)
                + (numeros.get(5) * 8)
                + (numeros.get(6) * 7)
                + (numeros.get(7) * 6)
                + (numeros.get(8) * 5)
                + (numeros.get(9) * 4)
                + (numeros.get(10) * 3)
                + (numeros.get(11) * 2)) % 11;

        if (totalPrimeiroDigito < 2){
            primeiroDigitoVerificador = 0;
        } else  {
            primeiroDigitoVerificador = 11 - totalPrimeiroDigito;
        }

        int segundoDigitoVerificador;
        int totalSegundoDigito = ((numeros.get(0) * 6)
                + (numeros.get(1) * 5)
                + (numeros.get(2) * 4)
                + (numeros.get(3) * 3)
                + (numeros.get(4) * 2)
                + (numeros.get(5) * 9)
                + (numeros.get(6) * 8)
                + (numeros.get(7) * 7)
                + (numeros.get(8) * 6)
                + (numeros.get(9) * 5)
                + (numeros.get(10) * 4)
                + (numeros.get(11) * 3)
                + (primeiroDigitoVerificador * 2)) % 11;

        if (totalSegundoDigito < 2) {
            segundoDigitoVerificador = 0;
        } else {
            segundoDigitoVerificador = 11 - totalSegundoDigito;
        }

        return primeiroDigitoVerificador == numeros.get(12)
                && segundoDigitoVerificador == numeros.get(13);
    }
}

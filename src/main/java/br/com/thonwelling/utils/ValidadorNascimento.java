package br.com.thonwelling.utils;

import java.time.LocalDate;
import java.time.Period;

public class ValidadorNascimento {
    public static boolean verificaMenorDe18(LocalDate dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears() < 18;
    }
}
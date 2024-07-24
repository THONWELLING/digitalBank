package br.com.thonwelling.utils;


public class ValidadorCPF {

    public boolean validarCpf(String cpf) {

        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        //Verifica se todos os dígitos são iguais
        for (int i = 1; i < 11; i++) {
            if (digitos[i] != digitos[0]) {
                break;
            } else if (i == 10) {
                return false;
            }
        }
        // Calcula os dígitos verificadores
        int soma1 = 0, soma2 = 0;

        for (int i = 0; i < 9; i++) {
            soma1 += digitos[i] * (10 - i);
            soma2 += digitos[i] * (11 - i);
        }

        int digitoVerificador1 = 11 - (soma1 % 11);

        if (digitoVerificador1 >= 10) {
            digitoVerificador1 = 0;
        }

        soma2 += digitoVerificador1 * 2;

        int digitoVerificador2 = 11 - (soma2 % 11);

        if (digitoVerificador2 >= 10) {
            digitoVerificador2 = 0;
        }

        // Verifica se os dígitos verificadores são iguais aos informados no CPF
        return digitos[9] == digitoVerificador1 && digitos[10] == digitoVerificador2;
    }

    public String imprimeCpf(String cpf) {
        return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
    }

    public String formatarCpf(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf;
    }
}
package br.com.thonwelling;

import br.com.thonwelling.utils.ValidadorCPF;
import br.com.thonwelling.utils.ValidadorNascimento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ValidadorCPF validaDocumentoCPF = new ValidadorCPF();


        Scanner console = new Scanner(System.in);
        System.out.println("Por Favor Digite seu Nome: ");
        String firstName = console.next();

        System.out.println("Digite Seu SobreNome: ");
        String lastName = console.next();
        console.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Digite sua Data de Nascimento(dd/MM/yyyy): ");
        String dataNascimentoStr = console.nextLine();

        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
        boolean menorDe18 = ValidadorNascimento.verificaMenorDe18(dataNascimento);
        if (!menorDe18){
            System.out.println("Digite seu CPF: ");
            String documento = console.next();

            System.out.println("Validando CPF Fornecido!");
            boolean documentoValido = validaDocumentoCPF.validarCpf(documento);
            if (documentoValido) {
                System.out.println("Documento CPF Válido. Criando Contas.");
                Client Thon = new Client();
                Thon.setFirstName(firstName);
                Thon.setLastName(lastName);
                Thon.setBirthDay(LocalDateTime.now().minusYears(38));
                Thon.setDocumentId(documento);
                System.out.printf("Hello and welcome %s !", Thon.getFirstName());

                System.out.println("Criando Conta Corrente.");
                Account currentAccount = new CurrentAccount(Thon);
                System.out.println("Criando Conta Poupança");
                Account savingAccount  = new SavingsAccount(Thon);

                double valorDepositado = 5000000;
                System.out.printf("Realizando Depósito No Valor De %.2f na Conta Corrente.", valorDepositado);
                currentAccount.depositMoney(5000000);
                currentAccount.printStatment();
                savingAccount.printStatment();

                double valorTransferido = 500000;
                System.out.printf("Tranferindo %.2f Para a Conta Poupança.", valorTransferido);
                currentAccount.transferMoney(500000, savingAccount);
                currentAccount.printStatment();
                savingAccount.printStatment();


            } else {
                System.out.println("Documento CPF Inválido. Confira o Número Digitado.");
            }
        } else {
            System.out.println("Não é Permitido Que Menores de 18 Anos de Idade Abram Contas. Favor Pedir Para Um(a) Responsável Maior de 18 Anos Abrir A(s) Contas.");
        }
    }
}
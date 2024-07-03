package br.com.thonwelling;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Client Thon = new Client();
        Thon.setFirstName("Thonwelling");
        Thon.setLastName("Dani");
        Thon.setBirthDay(LocalDateTime.now().minusYears(38));
        Thon.setDocumentId("084.422.828-15");

        System.out.printf("Hello and welcome %s !", Thon.getFirstName());

        Account currentAccount = new CurrentAccount(Thon);
        Account savingAccount  = new SavingsAccount(Thon);

        currentAccount.depositMoney(5000000);
        currentAccount.transferMoney(500000, savingAccount);

        currentAccount.printStatment();
        savingAccount.printStatment();

    }
}

package br.com.thonwelling;

public interface AccountInterface {
        void withdrawMoney(double withdrawValue);

        void depositMoney(double depositValue);

        void transferMoney(double transferValue, AccountInterface targetAccount);

        void printStatment();

}

package br.com.thonwelling;

public class SavingsAccount extends Account {
    public SavingsAccount(Client client) {
        super(client);
    }

    @Override
    public void printStatment(){
        System.out.println("---> Extrato De Conta Poupança <---");
        super.printCommonInfos();
    }
}

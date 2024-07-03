package br.com.thonwelling;

public class SavingsAccount extends Account {
    public SavingsAccount(Client client) {
        super(client);
    }

    @Override
    public void printStatment(){
        System.out.println("---> Savings Account Statment <---");
        super.printCommonInfos();
    }
}

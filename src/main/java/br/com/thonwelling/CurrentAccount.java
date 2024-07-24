package br.com.thonwelling;

public class CurrentAccount extends Account {
    public CurrentAccount(Client client) {
        super(client);
    }

    @Override
    public void printStatment(){
        System.out.println("---> Extrato De Conta Corrente <---");
        super.printCommonInfos();
    }
}

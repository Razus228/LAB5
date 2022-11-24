package Application;

import Application.Operations.Atm;
import Application.BankClient.Client;
import Application.Operations.Card;
import Application.Operations.Deposit;
import Application.Operations.Exchange;
import Application.Operations.Loan;
import Application.Operations.Operation;
import Application.Operations.Transaction;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Client client = new Client(0, 0);
        Card card = new Card(0, 0, 0, 0, "Use card");
        Exchange exchange = new Exchange(0, "Exchange", 0);
        Loan loan = new Loan(0, "Take loan", 0);
        Atm atm = new Atm(0, 0, 0, "Use atm");
        Transaction transaction = new Transaction(0, "Make transaction");
        Deposit deposit = new Deposit("Take deposit", 0, 0);
        List<Operation> operations = new ArrayList<>(List.of(atm, exchange, card, deposit, loan, transaction));
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int nrofClient = 0;
        int NrofOperations = 0;
        int totalNrofClients = 0;
        int totalNrofOperations = 0;
        int clientMoney = 0;


        String stop;

        boolean b = true;

        for (int i = 1; b; i++) {
            System.out.println("Day" + i);
            nrofClient = random.nextInt(1, 9);

            Operation operation = null;
            for (int j = 1; j <= nrofClient; j++) {
                System.out.println();
                client.setMoney(random.nextInt(0, 10000));
                client.setIdnp(random.nextInt(1000, 9999));
                System.out.println("Client with:" + " " + client.getIdnp() + " " + "id and " + client.getMoney() + " " + "lei" + " " + " enters the bank");

                NrofOperations = random.nextInt(1, 2);
                System.out.println("Do :");
                for (int k = 1; k <= NrofOperations; k++) {
                    operation = operations.get(random.nextInt(operations.size()));
                    System.out.println(operation.getName());
                    if (operation.getClass().equals(Atm.class)) {
                        atm.setAmount(random.nextInt(1000, 7000));

                        int randomchoice = random.nextInt(1, 8);
                        if (randomchoice > 5) {
                            if (atm.getAmount() <= client.getMoney()) {
                                System.out.println("takes" + " " + operation.getAmount() + " " + "lei");

                                client.setMoney(client.getMoney() + operation.getAmount());
                                System.out.println("Client has" + " " + client.getMoney() + " " + "left");
                            } else if (atm.getAmount() > client.getMoney())

                                System.out.println("tried to take, but Not enough money");


                        } else {
                            int putmoney = random.nextInt(1, 2000);
                            client.setMoney(client.getMoney() + putmoney);
                            System.out.println("put" + " " + putmoney + " " + "lei");

                            System.out.println("Client has" + " " + client.getMoney() + " " + "lei");
                        }


                    }
                    if (operation.getClass().equals(Card.class)) {
                        card.setAmount(random.nextInt(1, 5000));
                        System.out.println("Enter pin code");
                        card.setPinCode(random.nextInt(1111, 9999));
                        System.out.println("Pin code has been set" + " " + card.getPinCode());
                        int randomchoice = random.nextInt(1, 8);
                        if (randomchoice > 5) {
                            if (card.getAmount() <= client.getMoney()) {
                                System.out.println("takes" + " " + operation.getAmount() + " " + "lei");

                                client.setMoney(client.getMoney() - operation.getAmount());
                                //System.out.println("Client has" + " " + operation.getAmount() + " " + "money on card");
                                System.out.println("Client has" + " " + client.getMoney() + " " + "lei left");
                            } else if (card.getAmount() > client.getMoney())

                                System.out.println("tried to take, but Not enough money");

                        } else if (card.getAmount() <= client.getMoney()) {
                            int putmoney = random.nextInt(1, 2000);
                            client.setMoney(client.getMoney() - putmoney);
                            System.out.println("put" + " " + putmoney + " " + "lei");

                            System.out.println("Client has" + " " + putmoney + " " + "lei on card");
                            System.out.println("Client has" + " " + client.getMoney() + " " + "lei left");
                        } else if (card.getAmount() > client.getMoney()) {
                            int putmoney = random.nextInt(1, 2000);
                            System.out.println("put" + " " + putmoney + " " + "lei");
                            System.out.println("Client doesn't have enough money");
                        }
                    }

                    if (operation.getClass().equals(Deposit.class)) {
                        deposit.setAmount(random.nextInt(1000, 5000));
                        deposit.setId(random.nextInt(11111, 99999));
                        System.out.println("New deposit with id:" + " " + deposit.getId());
                        int randomchoice = random.nextInt(1000, 5000);
                        if (randomchoice > 4) {
                            if (deposit.getAmount() <= client.getMoney()) {
                                System.out.println("Client deposits" + " " + operation.getAmount() + " " + "lei's");
                                client.setMoney(client.getMoney() - operation.getAmount());
                                System.out.println("Client has" + " " + operation.getAmount() + " " + "lei's in bank");
                                System.out.println("Client has" + " " + client.getMoney() + " " + "lei's");
                            } else if (deposit.getAmount() > client.getMoney()) {
                                System.out.println("Client wants to deposit" + " " + operation.getAmount() + " " + " lei, but he doesn't have enough money");
                            }
                        }
                    }
                    if (operation.getClass().equals(Exchange.class)) {
                        exchange.setAmount(random.nextInt(1000, 5000));
                        exchange.setExchangeRateEuro(random.nextFloat(19, 20));
                        System.out.println("Exchange rate is" + " " + exchange.getExchangeRateEuro());
                        System.out.println("Client wants to exchange" + " " + operation.getAmount() + " " + "lei's");
                        //int randomchoice = random.nextInt(1, 8);
                        if (exchange.getAmount() < client.getMoney()) {
                            //if (randomchoice > 2){
                            if (exchange.getExchangeRateEuro() < 19.5) {
                                int randomizer = random.nextInt(1, 8);
                                if (randomizer > 5) {
                                    System.out.println("Client is gone because of the exchange rate that is" + " " + exchange.getExchangeRateEuro());
                                } else {
                                    client.setMoney(client.getMoney() - operation.getAmount());
                                    operation.setAmount(operation.getAmount() / exchange.getExchangeRateEuro());
                                    System.out.println("Client got" + " " + operation.getAmount() + " " + "euro");
                                    //client.setMoney(client.getMoney() - exchange.getAmount());
                                    System.out.println("Client has" + " " + client.getMoney() + " " + "lei and" + " " + operation.getAmount() + " " + "euro");
                                }
                            }
                            else if (exchange.getExchangeRateEuro() > 19.5) {
                                System.out.println("Exchange rate is" + " " + exchange.getExchangeRateEuro());
                                client.setMoney(client.getMoney() - operation.getAmount());
                                operation.setAmount(operation.getAmount() / exchange.getExchangeRateEuro());
                                System.out.println("Client got" + " " + operation.getAmount() + " " + "euro");
                                System.out.println("Client has" + " " + client.getMoney() + " " + "lei and" + " " + operation.getAmount() + " " + "euro");
                            }

                        } else if (exchange.getAmount() > client.getMoney())
                            System.out.println("Client doesn't have money to exchange");
                    }
                    if (operation.getClass().equals(Loan.class)) {
                        loan.setAmount(random.nextInt(1000, 5000));
                        loan.setLoanId(random.nextInt(11111, 99999));
                        System.out.println("Client wants to take a loan of" + " " + operation.getAmount() + " " + "lei's");
                        if (loan.getAmount() < client.getMoney()) {
                            System.out.println("Client takes a loan of" + " " + operation.getAmount() + " " + "lei's");
                            client.setMoney(client.getMoney() + operation.getAmount());
                            System.out.println("Client has" + " " + client.getMoney() + " " + "lei's and has to return to the bank" + " " + operation.getAmount());
                        } else if (loan.getAmount() > client.getMoney()) {
                            System.out.println("Client doesn't have enough money to loan from bank");
                        }

                    }
                    if (operation.getClass().equals(Transaction.class)){
                        transaction.setAmount(random.nextInt(1000,5000));
                        System.out.println("Client wants to make a transaction of" + "  " + operation.getAmount());
                        if (transaction.getAmount() < client.getMoney()){
                            System.out.println("Transaction completed");
                            client.setMoney(client.getMoney() - operation.getAmount());
                            System.out.println("Client now has" + " " + client.getMoney() + " " + " lei's left");
                        }
                        else if (transaction.getAmount() > client.getMoney()){
                            System.out.println("Transaction is not completed, not enough money");
                        }
                    }
                    clientMoney += operation.getAmount();

                }
            }
            System.out.println("***********************************");
            if (i % 30 == 0){
                System.out.println("***********************************");
                System.out.println(i/30 + " " + "Month");
                System.out.println("Press 0 to exit");
                stop = scanner.next();
                if (stop.equals("0")) {
                    System.out.println("************************************");
                    System.out.println("Money spent by Clients" + " " + clientMoney);
                    b = false;
                }
            }
        }
    }
}

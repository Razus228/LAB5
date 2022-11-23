package Application.BankClient;

import Application.BankEmployees.Employees;

public class Client extends Employees {
    public static int clientCount = 0;
    private float money;
    private int idnp;




    public Client(){}

    public Client(float money,int idnp){
        this.money = money;
        this.idnp = idnp;
        clientCount++;

    }

    public void setMoney(float money){
        this.money = money;
    }
    public float getMoney(){
        return this.money;
    }
    public void setIdnp(int idnp){
        this.idnp = idnp;
    }
    public int getIdnp(){
        return this.idnp;
    }



}

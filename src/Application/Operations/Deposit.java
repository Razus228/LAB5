package Application.Operations;


public class Deposit extends Operation {

    private int id;


    public Deposit(String name, float amount, int id) {
        super(name, amount);
        this.id = id;
    }

    ;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
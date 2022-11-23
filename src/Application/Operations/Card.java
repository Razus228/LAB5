package Application.Operations;



public class Card extends Operation {

    private int pinCode;
    private float amountput;
    private float amounttake;


    public Card(int pinCode, float amount, float amountput, float amounttake, String name) {
        super(name, amount);
        this.pinCode = pinCode;
        this.amountput = amountput;
        this.amounttake = amounttake;

    }


    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getPinCode() {
        return this.pinCode;
    }

    public void setAmountput(float amountput) {
        this.amountput = amountput;
    }

    public float getAmountput() {
        return this.amountput;
    }

    public void setAmounttake(float amounttake) {
        this.amounttake = amounttake;
    }

    public float getAmounttake() {
        return this.amounttake;
    }
}
package Application.Operations;


public class Atm extends Operation {

    private float take;
    private float put;



    public Atm(float amount, float take, float put,String name){
        super(name, amount);
        this.take = take;
        this.put = put;
    }
    public void setTake(float take) {
        this.take = take;
    }

    public float getTake() {
        return this.take;
    }

    public void setPut(float put) {
        this.put = put;
    }

    public float getPut() {
        return this.put;
    }
}

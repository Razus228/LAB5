package Application.Operations;



public class Exchange extends Operation {

    private float exchangeRateEuro = 0;




    public Exchange(float exchangeRateEuro,String name,float amount) {
        super(name,amount);
        this.exchangeRateEuro = exchangeRateEuro;

    }



    public void setExchangeRateEuro(float exchangeRateEuro) {
        this.exchangeRateEuro = exchangeRateEuro;
    }

    public float getExchangeRateEuro() {
        return this.exchangeRateEuro;
    }
}
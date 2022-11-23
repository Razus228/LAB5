package Application.HeadOffice;

public class HeadOffice {
    public void WalkinBank () {
        System.out.println ("EnterBank");

    }
    private String bankName;
    private String adress;
    public HeadOffice(){}

    public HeadOffice(String bankName,String adress){
        this.bankName = bankName;
        this.adress = adress;
    }
    public void setBankName(String bankAdress){
        this.bankName = bankAdress;
    }
    public String getBankName(){
        return this.bankName;
    }

    public void setAdress(String adress){
        this.adress = adress;
    }
    public String getAdress(){
        return this.adress;
    }

}
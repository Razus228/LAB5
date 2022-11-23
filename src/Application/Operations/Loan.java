package Application.Operations;

public class Loan extends Operation {

    private int loanId;


    public Loan(int loanId, String name,float amount){
        super(name,amount);
        this.loanId = loanId;

    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getLoanId() {
        return this.loanId;
    }

}
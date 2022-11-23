package Application.BankEmployees;

import Application.Employers.Employers;

public class Employees extends Employers {


    private int employeeId;
    private int idnp;

    public Employees(){}

    public Employees(int employeeId,int idnp){

        this.employeeId = employeeId;
        this.idnp = idnp;

    }



    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setIdnp(int idnp) {
        this.idnp = idnp;
    }

    public int getIdnp() {
        return this.idnp;
    }
}

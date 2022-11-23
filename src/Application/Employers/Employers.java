package Application.Employers;

import Application.HeadOffice.HeadOffice;

public class Employers extends HeadOffice {

    private int employerId;


    public Employers() {
    }

    public Employers(int employerId) {
        this.employerId = employerId;

    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public int getEmployerId() {
        return this.employerId;
    }
}

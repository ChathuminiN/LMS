package tm;

import javafx.scene.control.Button;

public class CustomerTM {
    private int CustId;
    private String name;
    private String address;
    private double salary;
    private Button btnDelete;
    
    public CustomerTM() {
    }

    public CustomerTM(int custId, String name, String address, double salary, Button btnDelete) {
        CustId = custId;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.btnDelete = btnDelete;
    }

    public int getCustId() {
        return CustId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setCustId(int custId) {
        CustId = custId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "CustomerTM [CustId=" + CustId + ", name=" + name + ", address=" + address + ", salary=" + salary
                + ", btnDelete=" + btnDelete + "]";
    }
    
    

    


    
}

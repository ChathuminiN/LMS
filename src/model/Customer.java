package model;

public class Customer {
    private int custId;
    private String custName;
    private String address;
    private double salary;
    public int getCustId() {
        return custId;
    }
    public String getCustName() {
        return custName;
    }
    public String getAddress() {
        return address;
    }
    public double getSalary() {
        return salary;
    }
    public void setCustId(int custId) {
        this.custId = custId;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Customer(int custId, String custName, String address, double salary) {
        this.custId = custId;
        this.custName = custName;
        this.address = address;
        this.salary = salary;
    }
    public Customer() {
    }
    @Override
    public String toString() {
        return "Customer [custId=" + custId + ", custName=" + custName + ", address=" + address + ", salary=" + salary
                + "]";
    }
    
    
}

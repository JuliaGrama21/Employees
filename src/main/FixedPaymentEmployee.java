package main;

public class FixedPaymentEmployee extends Employee {

    private int fixedMonthlyPayment;

    public FixedPaymentEmployee() {

    }

    public FixedPaymentEmployee(int id, String name, int fixedMonthlyPayment) {
        super(id, name);
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    protected double getAverageSalary() {
        return fixedMonthlyPayment;
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " "  +
                "salary = " + getAverageSalary();
    }
}

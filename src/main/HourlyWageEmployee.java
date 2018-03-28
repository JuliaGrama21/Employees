package main;

public class HourlyWageEmployee extends Employee {


    private int hourlyRate;

    public HourlyWageEmployee() {
    }

    public HourlyWageEmployee(int id, String name, int hourlyRate) {
        super(id, name);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected double getAverageSalary() {
        return 20.8 * 8 * hourlyRate;
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " +
                "salary = " + getAverageSalary();
    }
}

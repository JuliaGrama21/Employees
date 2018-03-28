package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new HourlyWageEmployee(1, "Pavlo", 500));
        employees.add(new HourlyWageEmployee(2, "Dima", 1000));
        employees.add(new FixedPaymentEmployee(3, "Petro", 100));
        employees.add(new HourlyWageEmployee(4, "Volodya", 3000));
        employees.add(new FixedPaymentEmployee(5, "Sasha", 100));
        employees.add(new FixedPaymentEmployee(6, "Masha", 200));


        if (employees.size() > 5) {
            for (int i = 0; i < 5; i++) {
                System.out.println(employees.get(i));
            }
        } else {
            employees.forEach(System.out::println);
        }


        employees.sort((left, right) -> {
            if (right.getAverageSalary() - left.getAverageSalary() == 0) {
                return right.getName().charAt(0) - left.getName().charAt(0);
            } else return (int) (right.getAverageSalary() - left.getAverageSalary());
        });

        System.out.println();
        employees.forEach(System.out::println);

        int index = employees.size() - 1;
        Employee employee = employees.get(index);
        int id = employee.getId();
        System.out.println(id);

        System.out.println(employees.get(employees.size() - 2).getId());
        System.out.println(employees.get(employees.size() - 3).getId());


        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("C:\\Users\\User\\Desktop\\employees.txt"))) {

            oos.writeObject(employees);
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        List<Employee> employeeList = null;
        try (ObjectInputStream ois
                     = new ObjectInputStream(new FileInputStream("C:\\Users\\User\\Desktop\\employees.txt"))) {
            employeeList = (List<Employee>) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(employeeList);
    }
}

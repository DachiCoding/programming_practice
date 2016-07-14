/**
 * Created by Dachi on 16/7/14.
 */

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

class Employee {
    public static int lastId = 0;
    private static final Random generator = new Random();
    private String name;
    private double salary;
    private final double id;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        this.id = ++Employee.lastId;
    }

    //An overload constructor
    public Employee(double salary){
        this("",salary);
    }

    public void raiseSalary(double byPercent){
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    public String getName(){
        return name;
    }
}

class CreditCardForm {
    private static final ArrayList<Integer> expirationYear = new ArrayList();

    static {
    }
}

class Invoice {
    private static class Item {
        String description;
        int quantity;
        double unitPrice;
        double price() {return quantity*unitPrice;}
    }

    public void addItem(String description, int quantity, double unitPrice){
        Item newItem = new Item();
        newItem.description = description;
        newItem.quantity = quantity;
        newItem.unitPrice = unitPrice;
        items.add(newItem);
    }

    private ArrayList<Item> items = new ArrayList<Item>();
}

class Network {

    public class Member {
        private String name;
        private ArrayList<Member> friends;

        public Member(String name){
            this.name = name;
            friends = new ArrayList();
        }
    }

    private ArrayList<Member> members;


}

public class OOP {

    public static void createEmployees(){
        ArrayList<Employee> staff = new ArrayList();
        staff.add(new Employee("James Bond",500000));
    }

    public static void numberFormatGenTest(){
        NumberFormat cFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat pFormatter = NumberFormat.getPercentInstance();
        double x = 0.1;
        System.out.println(cFormatter.format(x));
        System.out.println(pFormatter.format(x));
    }


    public static void main(String[] args){
        System.out.println(Employee.lastId);
        createEmployees();
        System.out.println(Employee.lastId);
        numberFormatGenTest();
    }

}

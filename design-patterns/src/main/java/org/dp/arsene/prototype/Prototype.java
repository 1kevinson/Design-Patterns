package org.dp.arsene.prototype;


/**
* Prefer use copy constructor than cloneable interface
* */
public class Prototype {

    public static void main(String[] args) {
        Employee john = new Employee("John", new Address("123 London Road","London", "Unietd Kingdom"));

        Employee chris = new Employee(john);
        chris.name = "Chris";

        System.out.println(john);
        System.out.println(chris);
    }
}


class Address {

    private final String streetAddress, city, country;

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    // Copy constructor
    public Address(Address otherAddress) {
        // "this" refer to the 1rst constructor
        this(otherAddress.streetAddress, otherAddress.city, otherAddress.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class Employee {

    public  String name;
    public  Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Employee(Employee otherEmployee) {
        this(otherEmployee.name, new Address(otherEmployee.address));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
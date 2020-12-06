package org.dp.arsene.prototype;

import java.util.Arrays;

public class Prototype {

    public static void main(String[] args) {
        final var john = new Person(
                new String[]{"John", "Smith"},
                new Address("London road", 123)
        );
    }
}


class Address implements Cloneable {
    public final String streetName;
    public final int houseNumber;

    public Address(String streetName, int houseNumber) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}


class Person {
    public final String[] names;
    public final Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }
}
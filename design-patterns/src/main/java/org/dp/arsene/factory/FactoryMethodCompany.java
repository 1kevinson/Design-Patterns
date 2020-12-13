package org.dp.arsene.factory;

import java.util.Arrays;

/**
* Provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
* */

public class FactoryMethodCompany {

    public static void main(String[] args) {
        final Company company = new GameDevCompany();
        System.out.println(Arrays.toString(company.getEmployees()));
    }
}

abstract class Company {

    // Interface for creating objects in this super class
    abstract Employee[] getEmployees();

    public String createSoftware() {
        return "Software created";
    }
}

// High level Classes
class GameDevCompany extends Company {

    @Override
    Employee[] getEmployees() {
        return new Employee[]{new Designer(), new Artist()};
    }
}

class OutSourcingCompany extends Company {

    @Override
    Employee[] getEmployees() {
        return new Employee[]{new Programmer()};
    }
}

// Abstractions
interface Employee {
    void doWork();
}

// Low level Classes
class Designer implements Employee {

    @Override
    public void doWork() {

    }

    @Override
    public String toString() {
        return "Designer{}";
    }
}

class Programmer implements Employee {

    @Override
    public void doWork() {

    }

    @Override
    public String toString() {
        return "Programmer{}";
    }
}

class Artist implements Employee {

    @Override
    public void doWork() {

    }

    @Override
    public String toString() {
        return "Artist{}";
    }
}
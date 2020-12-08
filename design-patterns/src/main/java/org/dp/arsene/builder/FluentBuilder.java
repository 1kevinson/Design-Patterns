package org.dp.arsene.builder;

class Person {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

// Fluent builder using Generics
class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    public Person build() {
        return person;
    }

    // Be able to override the behavior of self in derived classes
    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

public class FluentBuilder {

    public static void main(String[] args) {
        EmployeeBuilder builder = new EmployeeBuilder();
        Person person = builder
                .withName("Kevin")
                .worksAt("Developer")
                .build();

        System.out.println(person);
    }
}
package org.dp.arsene.builder;

class User {
    // address
    public String streetAddress, postCode, city;

    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "User{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

// Builder Facade
class UserBuilder {

    protected User user = new User();

    public UserAddressBuilder lives() {
        return new UserAddressBuilder(user);
    }

    public UserJobBuilder works() {
        return new UserJobBuilder(user);
    }

    public User build() {
        return user;
    }
}

class UserAddressBuilder extends UserBuilder {

    // We need a reference of this user in every sub-builder
    public UserAddressBuilder(User user) {
        this.user = user;
    }

    public UserAddressBuilder at(String streetAddress) {
        user.streetAddress = streetAddress;
        return this;
    }

    public UserAddressBuilder withPostCode(String postCode) {
        user.postCode = postCode;
        return this;
    }

    public UserAddressBuilder in(String city) {
        user.city = city;
        return this;
    }
}

class UserJobBuilder extends UserBuilder {

    public UserJobBuilder(User user) {
        this.user = user;
    }

    public UserJobBuilder at(String companyName) {
        user.companyName = companyName;
        return this;
    }

    public UserJobBuilder asA(String position) {
        user.position = position;
        return this;
    }

    public UserJobBuilder earning(int annualIncome) {
        user.annualIncome = annualIncome;
        return this;
    }
}

public class BuilderFacade {

    public static void main(String[] args) {
        final var userBuilder = new UserBuilder();
        final var user = userBuilder
                .lives()
                    .at("18 avenue baudelaire")
                    .withPostCode("34422")
                    .in("France")
                .works()
                    .at("Carbon IT")
                    .asA("Software Developer")
                    .earning(50000)
                .build();

        System.out.println(user);
    }
}
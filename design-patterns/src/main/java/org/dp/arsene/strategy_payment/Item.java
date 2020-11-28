package org.dp.arsene.strategy_payment;

public class Item {

    private final String upcCode;
    private final String name;
    private final String description;
    private final Integer price;

    public Item(String upcCode, String name, String description, Integer price) {
        this.upcCode = upcCode;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }
}

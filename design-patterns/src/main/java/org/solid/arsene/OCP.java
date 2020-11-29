package org.solid.arsene;

import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE
}

enum Size {SMALL, MEDIUM, LARGE, HUGE}


class Product {
    private final String name;
    private final Color color;
    private final Size size;

    Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }
}

/**
 * Work But bad practice
 */
// Bad practice because it's not close for modifications
class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(product -> product.getColor() == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(product -> product.getSize() == size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color) {
        return products.stream().filter(product -> product.getSize() == size && product.getColor() == color);
    }
}


// -------------------

interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> specification);
}

/**
 * Good way to respect open/close principle,
 * This class is open for extension but close for modification
 */
class GoodFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> specification) {
        return items.stream().filter(specification::isSatisfied);
    }
}

// If not use composite, set specialisation classes in one file
class ColorSpecification implements Specification<Product> {

    private final Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product product) {
        return product.getColor() == this.color;
    }
}

class SizeSpecification implements Specification<Product> {

    private final Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product product) {
        return product.getSize() == this.size;
    }
}

class NameSpecification implements Specification<Product> {

    private final String character;

    NameSpecification(String character) {
        this.character = character;
    }

    @Override
    public boolean isSatisfied(Product product) {
        return product.getName().contains(this.character);
    }
}

class And2Specification<T> implements Specification<T> {

    private final Specification<T> first, second;

    And2Specification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

class And3Specifications<T> implements Specification<T> {

    private final Specification<T> first, second, third;

    And3Specifications(Specification<T> first, Specification<T> second, Specification<T> third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item) && third.isSatisfied(item);
    }
}

public class OCP {

    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        final List<Product> products = List.of(apple, tree, house);

        final var productFiler = new ProductFilter();

        // BAD WAY OCP
        System.out.println("\nGreen Products (old) :");
        productFiler.filterByColor(products, Color.GREEN)
                .forEach(product -> System.out.println(
                        " - " + product.getName() + " is " + Color.GREEN
                ));

        // GOOD WAY OCP
        final var betterFilter = new GoodFilter();

        System.out.println("\nGreen Products (new) :");
        betterFilter.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(product -> System.out.println(
                        " - " + product.getName() + " is " + Color.GREEN
                ));

        System.out.println("\nGreen Products (new) => LARGE BLUE ITEMS:");
        betterFilter.filter(products, new And2Specification<>(
                new ColorSpecification(Color.BLUE),
                new SizeSpecification(Size.LARGE)
        )).forEach(product -> System.out.println(
                " - " + product.getName() + " is " + Color.BLUE + " and size is " + Size.LARGE
        ));

        System.out.println("\nGreen Products (new) => House LARGE BLUE ITEMS:");
        betterFilter.filter(products, new And3Specifications<>(
                new ColorSpecification(Color.BLUE),
                new SizeSpecification(Size.LARGE),
                new NameSpecification("h")
        )).forEach(product -> System.out.println(
                " - " + product.getName() + " is " + Color.BLUE + " and size is " + Size.LARGE
        ));
    }


}

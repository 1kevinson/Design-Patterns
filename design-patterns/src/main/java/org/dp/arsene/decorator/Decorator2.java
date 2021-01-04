package org.dp.arsene.decorator;

public class Decorator2 {

    public static void main(String[] args) {
        final Circle circle = new Circle(10f);
        System.out.println(circle.getInfo());

        final ColoredShape coloredCircle = new ColoredShape(circle, "Green");
        System.out.println(coloredCircle.getInfo());

        final TransparentShape transparentColoredShape = new TransparentShape(
                new ColoredShape(
                        new Square(10),
                        "Red"
                ),
                20
        );
        System.out.println(transparentColoredShape.getInfo());
    }
}

interface Shape {
    String getInfo();
}

class Circle implements Shape {

    private Float radius;

    Circle(Float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String getInfo() {
        return "Circle of radius " + radius;
    }
}

class Square implements Shape {

    private final int side;

    Square(int side) {
        this.side = side;
    }


    @Override
    public String getInfo() {
        return "A Square with side " + side;
    }
}

class ColoredShape implements Shape {

    private final Shape shape;
    private final String color;

    ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String getInfo() {
        return shape.getInfo() + " with color " + color;
    }
}

class TransparentShape implements Shape {

    private final Shape shape;
    private final int percentage;

    TransparentShape(Shape shape, int percentage) {
        this.shape = shape;
        this.percentage = percentage;
    }

    @Override
    public String getInfo() {
        return shape.getInfo() + " has " + percentage + " % transparency";
    }
}
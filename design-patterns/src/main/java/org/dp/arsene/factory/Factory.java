package org.dp.arsene.factory;

public class Factory {

    public static void main(String[] args) {
        final Point cartesianPoint = Point.newCartesianPoint(4, 2);
        final Point polarPoint = Point.newPolarPoint(43, 29);

        System.out.println(cartesianPoint);
        System.out.println(polarPoint);
    }
}

class Point {
    private final double x;
    private final double y;

    // Make constructor private force user to construct a point without the default constructor
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho * Math.cos(theta), theta * Math.sin(theta));
    }

    @Override
    public String toString() {
        return "Point{\n" +
                " x=" + x + ",\n" +
                " y=" + y + "\n" +
                "}\n";
    }
}

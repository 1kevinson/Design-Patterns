package org.dp.arsene.adapter;

/**
 * Also know as Wrapper
 * example >> Adapting square Pegs to round holes
 */
public class Adapter {

    public static void main(String[] args) {

        RoundHole hole = new RoundHole(10);
        RoundPeg roundPeg = new RoundPeg(10);

        if (isPegFitsHole(hole, roundPeg))
            System.out.println("Round peg r10 fits round hole r10");

        SquarePeg smallSquarePeg = new SquarePeg(3);
        SquarePeg bigSquarePeg = new SquarePeg(15);

        // Adapter
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSquarePeg);
        SquarePegAdapter bigSqPegAdapter = new SquarePegAdapter(bigSquarePeg);

        if (isPegFitsHole(hole, smallSqPegAdapter))
            System.out.println("Square peg w3 fits round hole r10.");

        if (!isPegFitsHole(hole, bigSqPegAdapter))
            System.out.println("Square peg w15 does not fit into round hole r10.");
    }

    private static boolean isPegFitsHole(RoundHole hole, RoundPeg roundPeg) {
        return hole.fits(roundPeg);
    }
}

// Compatible with round peg
class RoundHole {

    private final double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg) {
        return peg.getRadius() <= this.radius;
    }
}

// Compatible with round hole
class RoundPeg {

    private double radius;

    public RoundPeg() {
    }

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class SquarePeg {

    private final double width;


    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        return Math.pow(this.width, 2);
    }
}

class SquarePegAdapter extends RoundPeg {

    private final SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        return (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
    }
}
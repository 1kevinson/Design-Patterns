package org.dp.arsene.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeGraphic {
    private List<Graphic> allGraphics;

    void load() {
        allGraphics = new ArrayList<>();
        allGraphics.add(new Dot(1, 2));
        allGraphics.add(new Circle(1, 1, 5));
    }

    void groupSelected(List<Graphic> components) {
        final var group = new CompoundGraphic();

        for (Graphic component : components) {
            group.add(component);
            allGraphics.remove(component);
        }

        allGraphics.add(group);
        group.draw();
    }
}

interface Graphic {
    void move(int x, int y);

    void draw();
}

class Dot implements Graphic {

    private int x, y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void draw() {
        System.out.println("Draw a dot at X and Y");
    }
}

class Circle extends Dot {

    Circle(int x, int y, int radius) {
        super(x, y);
    }

    @Override
    public void draw() {
        System.out.println("Draw a circle with radius");
    }
}

class CompoundGraphic implements Graphic {

    final List<Graphic> graphicList = new ArrayList<>();

    void add(Graphic child) {
        graphicList.add(child);
    }

    void remove(Graphic child) {
        graphicList.remove(child);
    }

    @Override
    public void move(int x, int y) {
        for (Graphic graphic : graphicList) {
            graphic.move(x, y);
        }
    }

    @Override
    public void draw() {
        for (Graphic graphic : graphicList) {
            graphic.draw();
        }
    }
}


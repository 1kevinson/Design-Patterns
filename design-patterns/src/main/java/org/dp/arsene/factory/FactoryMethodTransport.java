package org.dp.arsene.factory;

/**
 * Provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
 */

public class FactoryMethodTransport {

    public static void main(String[] args) {
        final LogisticApp logistic = new RoadLogistic();
    }
}

interface Transport {
    void doDelivery();
}

class Sea implements Transport {
    @Override
    public void doDelivery() {
        System.out.println("Delivery by sea");
    }
}

class Road implements Transport {
    @Override
    public void doDelivery() {
        System.out.println("Delivery by road");
    }
}

abstract class LogisticApp {
    public final void doSomeLogisticStuff() {
        // Logistic stuff
    }

    public abstract Transport getTransportType();
}

class RoadLogistic extends LogisticApp {

    @Override
    public Transport getTransportType() {
        return new Road();
    }
}

class SeaLogistic extends LogisticApp {

    @Override
    public Transport getTransportType() {
        return new Sea();
    }
}
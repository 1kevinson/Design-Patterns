package org.dp.arsene.factory;

/**
 * Provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
 */

public class FactoryMethodTransport {

    public static void main(String[] args) {
        final LogisticApp roadLogistic = new RoadLogistic();
        roadLogistic.doLogisticStuff();
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

// Creator
abstract class LogisticApp {

    // Subclasses can indirectly change that business logic by overriding the factory method and returning a different type of product from it.
    public void doLogisticStuff() {

    }

    public abstract Transport getTransportType();
}

// Concrete Creators
class RoadLogistic extends LogisticApp {

    @Override
    public Transport getTransportType() {
        return new Road();
    }

    @Override
    public void doLogisticStuff() {
      Transport transportType = getTransportType();
      transportType.doDelivery();
    }
}

class SeaLogistic extends LogisticApp {

    @Override
    public Transport getTransportType() {
        return new Sea();
    }
}
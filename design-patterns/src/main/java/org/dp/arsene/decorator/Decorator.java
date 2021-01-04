package org.dp.arsene.decorator;

public class Decorator {

}

interface DataSource {
    void writeData(String data);

    void readData();
}

class FileDataSource implements  DataSource{

    private final String fileName;

    FileDataSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeData(String data) {
        // Data wrote
    }

    @Override
    public void readData() {
        // Data read
    }
}

class DataSourceDecorator implements DataSource {

    private final DataSource wrapper;

    DataSourceDecorator(DataSource wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void writeData(String data) {
        // Data wrote in decorator
        wrapper.writeData(data);
    }

    @Override
    public void readData() {
        // Data read in decorator
        wrapper.readData();
    }
}

class EncryptionDecorator extends DataSourceDecorator {

    EncryptionDecorator(DataSource wrapper) {
        super(wrapper);
    }

    @Override
    public void writeData(String data) {
        // Data wrote in encryption
    }

    @Override
    public void readData() {
        // Data read in encryption
    }
}

class CompressionDecorator extends DataSourceDecorator {

    CompressionDecorator(DataSource wrapper) {
        super(wrapper);
    }

    @Override
    public void writeData(String data) {
        // Data wrote in compression
    }

    @Override
    public void readData() {
        // Data read in compression
    }
}
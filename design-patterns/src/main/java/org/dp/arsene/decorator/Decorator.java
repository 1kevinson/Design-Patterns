package org.dp.arsene.decorator;

public class Decorator {

    public static void main(String[] args) {
        final var salaryRecords = "SalaryRecords";

        // FileDataSource
        final var fileSource = new FileDataSource("someFile.dat");
        fileSource.writeData(salaryRecords);

        // Compression > FileDataSource
        final var compressedSource = new CompressionDecorator(fileSource);
        compressedSource.writeData(salaryRecords);

        // Encryption > Compression > FileDataSource
        final var encryptionSource = new EncryptionDecorator(compressedSource);
        encryptionSource.writeData(salaryRecords);

    }
}

interface DataSource {
    void writeData(String data);

    void readData();
}

class FileDataSource implements DataSource {

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
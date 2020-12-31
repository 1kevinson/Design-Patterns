package org.dp.arsene.singleton;

public class BasicSingleton {

    public static void main(String[] args) {

    }
}


class Database {

    // STEP 1 - Store the singleton instance
    private static Database instance;

    // STEP 3 - Define private constructor so the class Database cannot be default initialize
    private Database() {
        System.out.println("initializing a lazy singleton");
    }

    // STEP 2 - Get the singleton instance
    public static Database getInstance() {
        if (Database.instance == null)
            Database.instance = new Database();

        return Database.instance;
    }

    public void query(String sql) {
    }
}
package org.dp.arsene.singleton;

public class Singleton1 {
}


class Database {

    private static Database instance;

    private Database() {
    }

    public static Database getInstance() {
        if (Database.instance == null)
            Database.instance = new Database();

        return Database.instance;
    }

    public void query(String sql) {
    }
}
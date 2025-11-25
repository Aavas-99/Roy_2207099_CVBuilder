package com.example.cvbuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:cv.db";

    public static Connection connect() {
        try {
            Connection c = DriverManager.getConnection(URL);
            System.out.println("Connected to SQLite database");
            return c;
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
            return null;
        }
    }

    public static void initialize() {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    Name TEXT NOT NULL,
                    Email TEXT,
                    Phone TEXT,
                    Address TEXT,
                    SSC TEXT,
                    SSCGroup TEXT,
                    SSCGPA TEXT,
                    HSC TEXT,
                    HSCGroup TEXT,
                    HSCGPA TEXT,
                    Hons TEXT,
                    HonsDept TEXT,
                    HonsCGPA TEXT,
                    Org1 TEXT,
                    From1 TEXT,
                    To1 TEXT,
                    Org2 TEXT,
                    From2 TEXT,
                    To2 TEXT,
                    Org3 TEXT,
                    From3 TEXT,
                    To3 TEXT,
                    Skills TEXT,
                    Projects TEXT
                );
                """;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSQL);
            System.out.println("✔ Database initialized");

        } catch (SQLException e) {
            System.out.println("Initialization failed");
            e.printStackTrace();
        }
    }
}

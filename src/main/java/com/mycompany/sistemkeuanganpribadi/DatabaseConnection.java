/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkeuanganpribadi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class ini digunakan untuk membuat koneksi ke database MySQL
 * menggunakan Laragon (localhost).
 *
 * Database: db_keuangan
 * User: root
 * Password: (kosong)
 */
public class DatabaseConnection {

    // Konfigurasi database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_keuangan";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private static Connection connection;

    // Private constructor agar tidak bisa dibuat instance
    private DatabaseConnection() {}

    /**
     * Method untuk mendapatkan koneksi aktif ke database.
     * Jika koneksi belum ada, sistem akan membuat baru.
     *
     * @return objek Connection yang bisa digunakan di seluruh aplikasi
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("✅ Koneksi ke database db_keuangan berhasil!");
            } catch (SQLException e) {
                System.err.println("❌ Gagal terhubung ke database: " + e.getMessage());
            }
        }
        return connection;
    }

    /**
     * Method opsional untuk menutup koneksi database dengan aman.
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("🔒 Koneksi database ditutup.");
            } catch (SQLException e) {
                System.err.println("⚠️ Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
}

package org.example.filmstpsit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/films";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione riuscita al database!");
            return connection;

        } catch (SQLException e) {
            System.err.println("Errore di connessione al database: " + e.getMessage());
            e.printStackTrace(); // Stampa il dettaglio dell'errore
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non trovato: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }


    public static List<Film> getFilms() throws SQLException {
        List<Film> films = new ArrayList<>();

        String query = "SELECT * FROM films INNER JOIN registi ON films.IDRegista = registi.IDRegista";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String titolo = rs.getString("Titolo");
                    String durata = rs.getString("Durata");
                    String nomeRegista = rs.getString("Nome");
                    String CognomeRegista = rs.getString("Cognome");

                    Film film = new Film(titolo, durata, nomeRegista, CognomeRegista);
                    films.add(film);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return films;
    }

}
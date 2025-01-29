package org.example.filmstpsit;

import com.google.gson.Gson;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "filmsArchive", value = "/filmsArchive")
public class FilmArchive extends HttpServlet {
    private String message;

    public void init() {
        message = "FILMS ARCHIVE";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Film> films = new ArrayList<Film>();
        try {
            films = DBConnection.getFilms(); // Ottieni i film dal DB
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        response.setContentType("text/html");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<style>");
//        out.println("body { font-family: 'Helvetica Neue', Arial, sans-serif; background: linear-gradient(135deg, #ece9e6, #ffffff); color: #333; display: flex; flex-wrap: wrap; justify-content: center; padding: 20px; }");
//
//        // Stile titolo
//        out.println("h1 {");
//        out.println("  color: #2c3e50;");
//        out.println("  font-size: 2.5rem;");
//        out.println("  background: #d6d8db;");
//        out.println("  padding: 20px 40px;");
//        out.println("  border-radius: 10px;");
//        out.println("  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);");
//        out.println("  text-align: center;");
//        out.println("  width: 100%;");
//        out.println("  margin-bottom: 30px;");
//        out.println("}");
//
//        // Stile card
//        out.println(".film-card {");
//        out.println("  width: 250px;"); // Larghezza fissa
//        out.println("  height: 350px;"); // Altezza fissa
//        out.println("  background-color: #ffffff;");
//        out.println("  border-radius: 10px;");
//        out.println("  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);");
//        out.println("  margin: 15px;");
//        out.println("  display: flex;");
//        out.println("  flex-direction: column;");
//        out.println("  justify-content: space-between;");
//        out.println("  padding: 20px;");
//        out.println("  transition: transform 0.3s ease, box-shadow 0.3s ease;");
//        out.println("  cursor: pointer;");
//        out.println("  text-align: center;");
//        out.println("}");
//
//        out.println(".film-card:hover {");
//        out.println("  transform: translateY(-10px);");
//        out.println("  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);");
//        out.println("}");
//
//        // Stile titolo, durata e regista
//        out.println(".film-card h2 { font-size: 1.5rem; color: #333; margin: 0; }");
//        out.println(".film-card p { font-size: 1rem; color: #555;}");
//
//        out.println("</style>");
//        out.println("</head>");
//        out.println("<body>");
//
//        out.println("<h1>" + message + "</h1>");
//
//        //card di ogni film che trova nel db
//        for (Film film : films) {
//            out.println("<div class='film-card'>");
//            out.println("<h2>" + film.getTitolo() + "</h2>");
//            out.println("<p><strong>Regista:</strong> " + film.getNomeRegista() + " " + film.getCognomeRegista() + "</p>");
//            out.println("<p><strong>Durata:</strong> " + film.getDurata() + "</p>");
//            out.println("</div>");
//        }
//
//        out.println("</body>");
//        out.println("</html>");

        response.setContentType("application/json");
        // Crea un oggetto Gson per la serializzazione
        Gson gson = new Gson();

        // Serializza i film in formato JSON
        String jsonResponse = gson.toJson(films);

        // Invia la risposta JSON
        try (PrintWriter out = response.getWriter()) {
                out.println(jsonResponse);
        }
    }
}

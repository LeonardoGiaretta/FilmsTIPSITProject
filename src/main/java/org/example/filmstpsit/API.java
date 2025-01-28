package org.example.filmstpsit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class API {

    private static Gson gson = new Gson();
    private static List<Film> films;

    public API() {}

    public static void get(String uri) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //avevo un errore e l'unica soluzione è stata usare i typetoken
        Type filmListType = new TypeToken<List<Film>>() {}.getType();

        // Deserializza il JSON
        films = gson.fromJson(response.body(), filmListType);
    }

    public Film searchFilm(String titolo) {
        for (Film film : films) {
            if (film.getTitolo().equalsIgnoreCase(titolo)) {
                return film;
            }
        }
        return null; // Ritorna null se il film non è trovato
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Film film : films) {
            result.append("Film: ").append(film.getTitolo())
                    .append("\nDurata: ").append(film.getDurata())
                    .append("\nRegista: ").append(film.getNomeRegista()).append(" ").append(film.getCognomeRegista())
                    .append("\n\n");
        }
        return result.toString();
    }

}

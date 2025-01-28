package org.example.filmstpsit;

public class Film {
    String titolo;
    String nomeRegista;
    String cognomeRegista;
    String durata;

    public Film() {}

    public Film(String titolo, String durata, String nomeRegista, String cognomeRegista) {
        this.titolo = titolo;
        this.nomeRegista = nomeRegista;
        this.cognomeRegista = cognomeRegista;
        this.durata = durata;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getNomeRegista() {
        return nomeRegista;
    }

    public String getCognomeRegista() {
        return cognomeRegista;
    }

    public String getDurata() {
        return durata;
    }
}

package org.example.filmstpsit;

public class Film {
    String titolo;
    String nomeRegista;
    String cognomeRegista;
    int durata;

    public Film() {}

    public Film(String titolo, int durata, String nomeRegista, String cognomeRegista) {
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

    public int getDurata() {
        return durata;
    }
}

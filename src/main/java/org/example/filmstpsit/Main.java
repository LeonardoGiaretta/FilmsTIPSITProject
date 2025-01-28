package org.example.filmstpsit;

import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        try {
            API api = new API();
            api.get("http://localhost:8080/FilmsTPSIT_war_exploded/filmsArchive");

            Scanner scanner = new Scanner(System.in);

            String scelta = "";
            while(true){
                System.out.println("----------------film archive----------------\n");
                System.out.println("1- showFilms\n");
                System.out.println("2- searchFilms\n");
                System.out.println("0- exit");
                System.out.println("inserisci numeri << ");
                scelta = scanner.nextLine();

                if(Integer.parseInt(scelta) == 0){
                    System.out.println("\nProgramma in chiusura...");
                    break;
                }

                switch (scelta){
                    case "1":
                        System.out.println(api.toString());
                        break;
                    case "2":
                        System.out.println("inserisci il nome del film << ");
                        String cerca = scanner.nextLine();

                        Film filmTrovato = api.searchFilm(cerca);
                        if (filmTrovato != null) {
                            System.out.println("Film trovato: \n" + "titolo: " + filmTrovato.getTitolo() + "\nRegista: " + filmTrovato.getCognomeRegista() + "\n" + filmTrovato.getNomeRegista() + "\nDurata: " + filmTrovato.getDurata());
                        } else {
                            System.out.println("Film non trovato.");
                        }
                        break;
                    default:
                        System.out.println("Scelta non valida.");
                        break;
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}



package org.example.filmstpsit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        try {
            API api = new API();
            api.get("http://localhost:8080/FilmsTPSIT_war_exploded/filmsArchive");

            Scanner scanner = new Scanner(System.in);

            String scelta = "";
            while(true){
                System.out.println("----------------film archive----------------");
                System.out.println("\t1- show Films");
                System.out.println("\t2- search Films");
                System.out.println("\t3- search Films with params");
                System.out.println("\t0- exit");
                System.out.println("--------------------------------------------\n");
                System.out.println("inserisci numeri << ");
                scelta = scanner.nextLine();

                if(Integer.parseInt(scelta) == 0){
                    System.out.println("\nProgramma in chiusura...");
                    break;
                }

                switch (scelta){
                    case "1":
                        System.out.println("\n" + api.toString());
                        break;
                    case "2":
                        System.out.println("inserisci il nome del film << ");
                        String cerca = scanner.nextLine();

                        Film filmTrovato = api.searchFilm(cerca);
                        if (filmTrovato != null) {
                            System.out.println("\n\t---Film trovato---\n" + "\ttitolo: " + filmTrovato.getTitolo() + "\n\tRegista: " + filmTrovato.getCognomeRegista() + " " + filmTrovato.getNomeRegista() + "\n\tDurata: " + filmTrovato.getDurata() + "\n");
                        } else {
                            System.out.println("\t---Film non trovato---\n");
                        }
                        break;
                    case "3":
                        System.out.println("cognome regista<< ");
                        String cognome = scanner.nextLine();

                        if(cognome.equals("null")){
                            cognome = null;
                        }
                        System.out.println("durata film e filtro (es. <120 , >100) -- se non vuoi immettere il filtro scrivi 'null'<< ");
                        String durataFiltro = scanner.nextLine();
                        String op = "";
                        Integer durata = null;

                        if(durataFiltro.equals("null"))
                            durataFiltro = null;
                        else{
                            op = durataFiltro.substring(0, 1);
                            durata = Integer.parseInt(durataFiltro.substring(1, durataFiltro.length()));
                        }
                        System.out.println("operazione in corso...\t");
                        List<Film> Films = api.getFilmsWithParams(cognome, durata, op);
                        System.out.println("\n\t---Film trovato---\n");

                        for (Film film : Films)
                            System.out.println( "\ttitolo: " + film.getTitolo() + "\n\tRegista: " + film.getCognomeRegista() + " " + film.getNomeRegista() + "\n\tDurata: " + film.getDurata() + "\n");
                        break;
                    default:
                        System.out.println("\t---Scelta non valida---\n");
                        break;
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



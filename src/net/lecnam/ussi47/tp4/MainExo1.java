package net.lecnam.ussi47.tp4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainExo1 {

    static Auteur[] auteurs = new Auteur[100];
    static int nbAuteur = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("Que voulez vous faire ? ");
            System.out.println("1. ajouter un auteur ");
            System.out.println("2. voir les auteurs");
            System.out.println("3. Quitter");
            Scanner sc = new Scanner(System.in);
            try {
                int choix = Integer.parseInt(sc.nextLine());
                if (choix == 1) {
                    ajoutAuteur();
                } else if (choix == 2) {
                    voirAuteurs();
                } else if (choix == 3) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Saisir 1, 2 ou 3 seulement");
            }
        }


    }

    public static void voirAuteurs() {
        if (nbAuteur==0) {
            System.out.println("Aucun auteur");
            return;
        }
        System.out.println("Liste des auteurs : ");
        for (int i = 0; i < nbAuteur; i++) {
            System.out.println(auteurs[i]);
        }
    }

    public static void ajoutAuteur() {

        System.out.println("Ajouter un auteur : ");
        System.out.println("Nom :");
        Scanner sc = new Scanner(System.in);
        String nom = sc.nextLine();

        System.out.println("Prénom :");
        String prenom = sc.nextLine();

        System.out.println("Date Naissance (format jj/mm/aaaa) : ");
        LocalDate dateNaissance;
        while (true) {
            String dateNaissanceEnChaine = sc.nextLine();
            try {
                dateNaissance = LocalDate.parse(dateNaissanceEnChaine, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (Exception e) {
                System.out.println("La date n'est pas correcte, rééssayer (exemple : 01/10/2001) : ");
            }
        }

        Auteur auteur = new Auteur(nom, prenom, dateNaissance);
        auteurs[nbAuteur] = auteur;
        nbAuteur++;



    }
}

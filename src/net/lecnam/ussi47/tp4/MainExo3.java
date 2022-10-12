package net.lecnam.ussi47.tp4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainExo3 {

    static Auteur[] auteurs = new Auteur[100];
    static Bibliotheque bibliotheque = new Bibliotheque();
    static int nbAuteur = 0;
    static int nbLivre = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("Que voulez vous faire ? ");
            System.out.println("1. Ajouter un auteur ");
            System.out.println("2. Voir les auteurs");
            System.out.println("3. Ajouter un livre a la bibliothèque");
            System.out.println("4. Voir les livres");
            System.out.println("5. Quitter");
            Scanner sc = new Scanner(System.in);
            try {
                int choix = Integer.parseInt(sc.nextLine());
                if (choix == 1) {
                    ajoutAuteur();
                } else if (choix == 2) {
                    voirAuteurs();
                } else if (choix == 3) {
                    ajoutLivre();
                } else if (choix == 4) {
                    voirLivres();
                } else if (choix == 5) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Saisir 1, 2 ou 3 seulement");
            }
        }


    }

    private static void voirLivres() {
        if (nbLivre==0) {
            System.out.println("Aucun livre");
            return;
        }
        System.out.println("Liste des livres : ");
        bibliotheque.afficheLivres();
    }

    public static void voirAuteurs() {
        if (nbAuteur==0) {
            System.out.println("Aucun auteur");
            return;
        }
        System.out.println("Liste des auteurs : ");
        for (int i = 0; i < nbAuteur; i++) {
            System.out.println(i + " : " + auteurs[i]);
        }
    }

    private static Auteur choixAuteur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selectionner le numéro de l'auteur : ");
        voirAuteurs();
        while(true) {
            try {
                int choix = Integer.parseInt(sc.nextLine());
                if (choix < 0 || choix >= nbAuteur) {
                    throw new Exception();
                }
                return auteurs[choix];
            } catch (Exception e) {
                System.out.println("Veuillez saisir un nombre entre 0 et " + (nbAuteur - 1));
            }
        }

    }

    public static void ajoutLivre() {
        System.out.println("Ajouter un livre : ");
        int choix = 1;
        Scanner sc = new Scanner(System.in);
        Auteur auteur;
        while (true) {
            try {

                if (nbAuteur > 0) {
                    System.out.println("1. Ajouter un nouvel auteur");
                    System.out.println("2. Selectionner un auteur déjà référencé");
                    choix = Integer.parseInt(sc.nextLine());
                }

                if (choix == 1) {
                    auteur = ajoutAuteur();
                    break;
                } else if (choix == 2) {
                    auteur = choixAuteur();
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Saisir 1, 2 seulement");
            }
        }

        System.out.println("Titre : ");
        String titre = sc.nextLine();


        String isbn;
        while (true) {
            System.out.println("Isbn : ");
            isbn = sc.nextLine();

            if (!isbnExiste(isbn)) {
                break;
            } else {
                System.out.println("L'isbn existe déjà ! ressaisir un autre isbn");
            }
        }

        Livre livre = new Livre(auteur, titre, isbn);
        bibliotheque.ajoutLivre(livre);
    }

    private static boolean isbnExiste(String isbn) {
        if (nbLivre==0) {
            return false;
        }
        if (bibliotheque.rechercheLivre(isbn) != null) {
            return true;
        }
        return false;
    }

    public static Auteur ajoutAuteur() {

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

        return auteur;



    }


}

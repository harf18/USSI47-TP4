# TP4 : Classes et Objets

### Objectifs
Manipuler les classes :

- Création de classe & instanciation d'objet
- Constucteurs
- Méthodes
- Attributs

### Prérequis
- Cloner le projet sur votre poste dans le repertoire de votre choix
- Ouvrir le projet :
  - Sur l'écran d'accueil d'IntelliJ, cliquer sur **Open**
  - Sélectionner le dossier **tp4-xxx** qui a été copié depuis github puis cliqué sur **OK**.
  - Le projet s'ouvre
  - Allez vérifier que le SDK est bien sélectionné dans **File > Project Structure** onglet **Project**

### Utilisation de GIT

- Créer une nouvelle branche **prenomNom**
- Faire **1 commit** par exercice
- Ouvrir **une seule** *pull request* sur github et **ne pas** la fermer/merger !!

----

### Modalité du TP

- Utiliser la méthode *main()* de la classe **Exec** pour tester vos développements : Création d'objets, appel de méthodes, etc... au rythme ou vous le desirez, ce n'est pas précisé dans chaque exercice.
- Toutes les classes des exercices doivent être ajoutées au package **net.lecnam.ussi2a.tp4**

> Si vous ne l'avez pas encore fait, pensez a créer une nouvelle branche **prenomNom**

### Exercice 1

- Créer une classe **Auteur**. Un auteur a un **nom**, un **prénom** et une **date de naissance** (de type LocalDate).
- Ajouter un constructeur **Auteur(String nom, String prenom, LocalDate dateNaissance)** pour initialiser ces propriétés.
- Écrire une méthode privée **getAge()** qui retourne l'age de l'auteur (Vous aurez besoin de [Doc Periode](https://download.java.net/java/early_access/loom/docs/api/java.base/java/time/class-use/Period.html) et [Doc LocalDate](https://download.java.net/java/early_access/panama/docs/api/java.base/java/time/LocalDateTime.html))
- Ecrire la méthode **toString()** pour qu'elle retourne une chaine qui contient, nom, prenom et age.

> Pensez a faire votre 1er commit !!  
> Pour tester votre code, faites :   
> ```git checkout main1```  
> ```git checkout master```  
> ```git merge main1```  
> La classe MainExo1 a été créé, executer le main de cette classe, et cliquer dans la fenetre du bas pour pouvoir tester le programme


### Exercice 2
- Créer une classe **Livre**. Un livre a un **auteur**, un **titre** et un **isbn** (une chaine)
- Ajouter les accesseurs
- Ajouter un instructeur **Livre(Auteur auteur, String titre, String isbn)** avec les paramètres de type Livre et 2 String pour initialiser les attributs. 
- Écrire la méthode **toString()** 
- Ecrire la méthode **equals(Livre livre)** : 2 livres sont égaux s'ils ont le même isbn

> Pensez a faire un commit !!
> Pour tester votre code, faites :   
> ```git checkout main2```  
> ```git checkout master```  
> ```git merge main2```  
> La classe MainExo2 a été créé, executer le main de cette classe, et cliquer dans la fenetre du bas pour pouvoir tester le programme


### Exercice 3
- Créer une classe **Bibliotheque**. 
- Cette classe contient un tableau de 100 livres et une propriété qui indique le nombre de livres dans la bibliothèque.
- Écrire la méthode **toString()** qui retourne le nombre de livres 
- Écrire une méthode **ajoutLivre(Livre livre)** qui permet d'ajouter un livre dans le tableau des livres disponibles.
- Écrire une méthode **afficheLivres()** qui affiche la liste des livres.
- Écrire la méthode **rechercheLivre(String isbn)** qui retourne le livre avec cet isbn.

> Pensez a faire un commit !!
> Pour tester votre code, faites :   
> ```git checkout main3```  
> ```git checkout master```  
> ```git merge main3```  
> La classe MainExo3 a été créé, executer le main de cette classe, et cliquer dans la fenetre du bas pour pouvoir tester le programme

> Pensez à faire un push (```git push origin *prenomNom*```)  
> Si elle n'est pas déjà ouverte, ouvrez une pull request (branche **prenomNom** vers **master**) NE PAS LA FERMER/MERGER !

### Exercice 4 (bonus)
La bibliothèque décide de louer des CD... ajouter le code nécessaire pour prendre en charge des CD.

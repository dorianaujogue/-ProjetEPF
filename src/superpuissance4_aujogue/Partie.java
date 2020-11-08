
package superpuissance4_aujogue;

import java.util.Scanner; //on importe le scanner

public class Partie {
    Joueur ListeJoueurs [] = new Joueur [1];
    Joueur joueurCourant;
    
public void attribuerCouleursAuxJoueurs(){
    ListeJoueurs[0].affecterCouleur("jaune");
    ListeJoueurs[1].affecterCouleur("rouge");

}

public void initialiserPartie(){
    Grille grilleDeJeu = new Grille();
    grilleDeJeu.viderGrille();
    
    //création des joueurs
    Scanner sc = new Scanner(System.in);
    System.out.println("Choix du pseudo du premier joueur");
    String rep1 = sc.nextLine();
    System.out.println("Choix du pseudo du second joueur");
    String rep2 = sc.nextLine();
    Joueur joueur1 = Joueur(rep1);
    Joueur joueur2 = Joueur(rep2);
    ListeJoueurs[0] = joueur1;
    ListeJoueurs[1] = joueur2;

    attribuerCouleursAuxJoueurs();
    
            
    int nb1 = 0;
    int nb2 = 0;
    //création des trous noirs
    while (nb1 < 6){
        int i = (int) (Math.random() * (6-1));//cela permet de trouver des coordonnées aléatoire pour ensuite placer un trou noir
        int j = (int) (Math.random() * (7-1));
        grilleDeJeu.placerTrouNoir(i,j);
        nb1++;
    }
    
    //création des désintégrateurs
    while (nb2 < 7){
        int i = (int) (Math.random() * (6-1));
        int j = (int) (Math.random() * (7-1));
        grilleDeJeu.placerDesintegrateur(i,j);
        nb2++;
    }
    
    //définition du joueur qui débute
    joueurCourant = ListeJoueurs[0];
}

public void debuterPartie(){
    initialiserPartie();
    while ( grilleDeJeu.etreGagnantePourJoueur(ListeJoueurs[0]) == true || grilleDeJeu.etreGagnantePourJoueur(ListeJoueurs[1]) == true || grilleDeJeu.etreRemplie() == true){
        System.out.println("Que souhaitez vous faire ? \n 1)Jouer un jeton \n 2)Récuperer un jeton \n 3)Utiliser un désintégrateur");
    }
}
}



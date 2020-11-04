
package superpuissance4_aujogue;

public class Partie {
    Joueur ListeJoueurs [] = new Joueur [2];
    Joueur joueurCourant;
    
public void attribuerCouleursAuxJoueurs(){
    ListeJoueurs[0].affecterCouleur("jaune");
    ListeJoueurs[1].affecterCouleur("rouge");

}

public void initialiserPartie(){
    Grille G = new Grille();
    G.viderGrille();
    int nb1 = 0;
    int nb2 = 0;
    //création des trous noirs
    while (nb1 < 6){
        int i = (int) Math.random() * (5);//cela permet de trouver des coordonnées aléatoire pour ensuite placer un trou noir
        int j = (int) Math.random() * (6);
        G.placerTrouNoir(i,j);
        nb1++;
    }
    
    //création des désintégrateurs
    while (nb2 < 7){
        int i = (int) Math.random() * (5);
        int j = (int) Math.random() * (6);
        G.placerDesintegrateur(i,j);
        nb2++;
    }
    
    //création et attribution des jetons
    for (int i = 0 ; i<21 ; i++){
        ListeJoueurs[0].ajouterJeton(new Jeton(ListeJoueurs[0].couleur));
        ListeJoueurs[1].ajouterJeton(new Jeton(ListeJoueurs[1].couleur));
    }
    
    //définition du joueur qui débute
    joueurCourant = ListeJoueurs[0];
}

public void debuterPartie(){
    initialiserPartie();
    while (G.etreGagnantePourJoueur(ListeJoueurs[0]) == true || G.etreGagnantePourJoueur(ListeJoueurs[1]) == true || G.etreRemplie() == true){
        
    }
}
}



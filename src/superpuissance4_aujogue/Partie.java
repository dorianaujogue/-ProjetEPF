
package superpuissance4_aujogue;

import java.util.Scanner; //on importe le scanner

public class Partie {
    Joueur ListeJoueurs [] = new Joueur [2];
    Joueur joueurCourant;
    Grille grilleDeJeu = new Grille();
    
public void attribuerCouleursAuxJoueurs(){
    ListeJoueurs[0].affecterCouleur("jaune");
    ListeJoueurs[1].affecterCouleur("rouge");

}

public void initialiserPartie(){
    
    grilleDeJeu.viderGrille();
    
    //création des joueurs
    /*Scanner sc = new Scanner(System.in);
    System.out.println("Choix du pseudo du premier joueur");
    String rep1 = sc.nextLine();
    System.out.println("Choix du pseudo du second joueur");
    String rep2 = sc.nextLine();*/
    Joueur joueur1 = new Joueur();
    Joueur joueur2 = new Joueur();
    ListeJoueurs[0] = joueur1;
    ListeJoueurs[1] = joueur2;

    attribuerCouleursAuxJoueurs();
    
          
    int nb1 = 0;
    int nb2 = 0;
    //création des trous noirs
    while (nb1 < 5){
        int i = (int) (Math.random() * (6-1));//cela permet de trouver des coordonnées aléatoire pour ensuite placer un trou noir
        int j = (int) (Math.random() * (7-1));
        grilleDeJeu.placerTrouNoir(i,j);
        nb1++;
    }
    
    //création des désintégrateurs
    while (nb2 < 5){
        int i = (int) (Math.random() * (6-1));
        int j = (int) (Math.random() * (7-1));
        grilleDeJeu.placerDesintegrateur(i,j);
        nb2++;
    }
    
    //définition du joueur qui débute
    joueurCourant = ListeJoueurs[0];
}

public Joueur prochainJoueur (Joueur unJoueur){
    if(ListeJoueurs[0] == joueurCourant){
        return ListeJoueurs[1];
    }else{
        return ListeJoueurs[0];
    }       
}

public void debuterPartie(){
    
    initialiserPartie();
    int choix; 
    Scanner sc = new  Scanner (System.in);
    while ( grilleDeJeu.etreGagnantePourJoueur(ListeJoueurs[0]) == true || grilleDeJeu.etreGagnantePourJoueur(ListeJoueurs[1]) == true || grilleDeJeu.etreRemplie() == true){
        System.out.println("Que souhaitez vous faire ? \n 1)Placer un jeton \n 2)Récuperer un jeton \n 3)Utiliser un désintégrateur");
        choix = sc.nextInt();
        while (choix<1 || choix>4){
            System.out.println("Choix non valide, que souhaitez vous faire ?");
            choix = sc.nextInt();
        }
        if (choix == 1){
            System.out.println("Dans quelle colonne souhaitez vous ajouter votre jeton ?");
            Scanner scanner1 = new Scanner(System.in);
            int colonne = scanner1.nextInt();
            grilleDeJeu.ajouterJetonDansColonne(joueurCourant.listejetons[joueurCourant.nbJetonsRestants],colonne);
            joueurCourant.nbJetonsRestants = joueurCourant.nbJetonsRestants - 1;
            prochainJoueur(joueurCourant);
        }
        if (choix == 2){
            System.out.println("Quelle est la colonne du jeton que vous voulez récupérer ?");
            Scanner scanner2 = new Scanner(System.in);
            int colonne1 = scanner2.nextInt();
            System.out.println("Quelle est la ligne du jeton que vous voulez récupérer ?");
            Scanner scanner3 = new Scanner(System.in);
            int ligne1 = scanner3.nextInt();
            grilleDeJeu.recupererJeton(ligne1,colonne1);
            prochainJoueur(joueurCourant);
        }
        if (choix == 3){
            if (joueurCourant.nbDesintegrateurs > 0){
                System.out.println("Dans quelle colonne voulez vous utiliser un désintégrateur ?");
                Scanner scanner4 = new Scanner(System.in);
                int colonne2 = scanner4.nextInt();
                System.out.println("Dans quelle ligne voulez vous utiliser un désintégrateur ?");
                Scanner scanner5 = new Scanner(System.in);
                int ligne2 = scanner5.nextInt();
                grilleDeJeu.Cellules[ligne2][colonne2] = null;                
            }else{
                System.out.println("Vous ne possédez pas de désintégrateur, pour la peine, vous sautez votre tour ");
                prochainJoueur(joueurCourant);
            }
        }
    }
    
}
}



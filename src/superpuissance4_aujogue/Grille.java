
package superpuissance4_aujogue;


public class Grille {
    Cellule Cellules[][] = new Cellule[6][7];
    
public boolean ajouterJetonDansColonne (Jeton unJeton,int colonne){
    boolean result = false;
    if (Cellules [0][colonne].jetonCourant !=null){
        result = false;
        return result;
    }else{
        for (int i=0 ; i<6 ; i++){
            if (Cellules [i][colonne].jetonCourant == null){
                Cellules [i][colonne].jetonCourant = unJeton;
                result = true;
                return result;
            }
        }
    }            
        return result;
}

public boolean etreRemplie(){
    boolean result = false;
    for (int i = 0 ; i<6 ; i++){
        for (int j = 0 ; j<7 ; j++){
            if (Cellules[i][j].jetonCourant != null){
                result =true;
            }else{
                result = false;
                break;
            }
        }
    }
    return result;
}

public void viderGrille(){
    for (int i = 0 ; i<6 ; i++){
        for (int j = 0 ; j<7 ; j++){
            Cellules[i][j].jetonCourant=null;
        }
    } 
}

public void afficherGrilleSurConsole(){
    for (int i = 0 ; i<6 ; i++){
        for (int j = 0 ; j<7 ; j++){
            if (Cellules[i][j].trouNoir){
                System.out.print("T");
            }
            else if (Cellules[i][j].desintegrateur){
                System.out.print("D");
            }
            else if (Cellules[i][j].jetonCourant == null){
                System.out.print("N");
            }
            else{
                System.out.print(Cellules[i][j].jetonCourant);
            }
        }  
    }
}

public boolean celluleOccupee(int i , int j){
    if(Cellules[i][j].jetonCourant != null){
       return true;
    }else{
        return false;
    }   
}

public String lireCouleurDuJeton(int i , int j){
    return Cellules[i][j].jetonCourant.couleur;
}

public boolean etreGagnantePourJoueur(Joueur unJoueur){
    boolean a = false;
    for (int i = 0 ; i<6 ; i++){
        for (int j = 0 ; j<7 ; j++){
            if (lireCouleurDuJeton(i,j).equals(unJoueur.couleur) && lireCouleurDuJeton(i+1,j).equals(unJoueur.couleur) && lireCouleurDuJeton(i+2,j).equals(unJoueur.couleur) && lireCouleurDuJeton(i+3,j).equals(unJoueur.couleur));{
                a = true;
            }if (lireCouleurDuJeton(i,j).equals(unJoueur.couleur) && lireCouleurDuJeton(i,j+1).equals(unJoueur.couleur) && lireCouleurDuJeton(i,j+2).equals(unJoueur.couleur) && lireCouleurDuJeton(i,j+3).equals(unJoueur.couleur)){
                a = true;
            }if (lireCouleurDuJeton(i,j).equals(unJoueur.couleur) && lireCouleurDuJeton(i+1,j+1).equals(unJoueur.couleur) && lireCouleurDuJeton(i+2,j+2).equals(unJoueur.couleur) && lireCouleurDuJeton(i+3,j+3).equals(unJoueur.couleur)){
                a = true;    
            }          
        }
    }
    return a;
}

public void tasserGrille(int ligne, int colonne){
    for (int i = ligne ; i<6 ; i++){
        if (i == 5){
            Cellules[i][colonne].jetonCourant = null;
        }else{
            Cellules[i][colonne].jetonCourant = Cellules[i+1][colonne].jetonCourant;
        }
    }
}

public boolean colonneRemplie(){
    boolean result = false;
    for (int i = 0 ; i<6 ; i++){
        if (Cellules[i][6].jetonCourant != null){
            result = true;
            return result;
        }
    }
        return result;
}

public boolean placerTrouNoir(int i,int j){
    if (Cellules[i][j].trouNoir){
        Cellules[i][j].trouNoir = true;
        return true;
    }else{
        return false;
    }
}

public boolean placerDesintegrateur(int i, int j){
    if (Cellules[i][j].desintegrateur){
        Cellules[i][j].desintegrateur = true;
        return true;
    }else{
        return false;
    }
}

public boolean supprimerJeton(int i, int j){
    if (Cellules[i][j].jetonCourant != null){
        Cellules[i][j].supprimerJeton();
        return true;
    }else{
        return false;
    }
}

public Jeton recupererJeton(int i, int j){
    Jeton unJeton = Cellules[i][j].recupererJeton();
    Cellules[i][j].supprimerJeton();
    return unJeton;
}
}

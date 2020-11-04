
package superpuissance4_aujogue;

public class Cellule {
    boolean trouNoir;
    boolean desintegrateur;
    Jeton jetonCourant = null;
    
public Cellule (){
    trouNoir = false;
    desintegrateur = false;
    jetonCourant = null;
}

public boolean affecterJeton (Jeton jetonActif){
    if (jetonCourant == null){
        jetonCourant = jetonActif;
        return true;
    }else{
        return false;
    }
    
}

public Jeton recupererJeton(){
    return jetonCourant;
}

public boolean supprimerJeton(){
    if (jetonCourant == null){
        return false;
    }else{
        jetonCourant = null;
        return true;
    }
}

public boolean placerTrouNoir(){
    if (trouNoir == true){
        return false;
    }else{
        trouNoir = true;
        return true;
    }
}

public boolean placerDesintegrateur(){
    if (desintegrateur ==true){
        return false;
    }else{
        desintegrateur = true;
        return true;
    }
}

public boolean presenceTrouNoir(){
    return trouNoir;
}

public boolean presenceDesintegrateur(){
    return desintegrateur;
}

public String lireCouleurDuJeton(){
    return jetonCourant.couleur;
}

public boolean recupererDesingrateur(){
    if (desintegrateur == true){
        desintegrateur = false;
        return true;
    }else{
        return false;
    }
}

public boolean activerTrouNoir(){
    if (trouNoir == true){
        jetonCourant = null;
        trouNoir = false;
        return true;       
    }else{
        return false;
    }
}
}

